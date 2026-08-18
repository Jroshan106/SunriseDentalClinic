package dao;

import db.DBConnection;
import model.Appointment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    public boolean appointmentExists(String appointmentNo) {
        String sql = "SELECT appointment_no FROM appointments WHERE appointment_no=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, appointmentNo);
            try (ResultSet rs = pst.executeQuery()) { return rs.next(); }
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public boolean isDentistAvailable(int dentistId, String date, String time) {
        String sql = "SELECT availability_id FROM dentist_availability " +
                     "WHERE dentist_id=? AND available_date=? AND is_available=1 " +
                     "AND ? >= start_time AND ? < end_time";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            Time t = Time.valueOf(normalizeTime(time));
            pst.setInt(1, dentistId);
            pst.setDate(2, Date.valueOf(date));
            pst.setTime(3, t);
            pst.setTime(4, t);
            try (ResultSet rs = pst.executeQuery()) { return rs.next(); }
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public boolean isDentistBooked(int dentistId, String date, String time) {
        String sql = "SELECT appointment_no FROM appointments WHERE dentist_id=? AND appointment_date=? " +
                     "AND appointment_time=? AND status NOT IN ('DECLINED','CANCELLED')";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, dentistId);
            pst.setDate(2, Date.valueOf(date));
            pst.setTime(3, Time.valueOf(normalizeTime(time)));
            try (ResultSet rs = pst.executeQuery()) { return rs.next(); }
        } catch (Exception e) { e.printStackTrace(); }
        return true;
    }

    public boolean addAppointment(Appointment a) {
        Connection con = null;
        try {
            con = DBConnection.getConnection();
            con.setAutoCommit(false);

            int patientId = findPatientByContact(con, a.getContactNo());
            if (patientId == 0) {
                String psql = "INSERT INTO patients(name,address,contact_no) VALUES(?,?,?)";
                try (PreparedStatement pst = con.prepareStatement(psql, Statement.RETURN_GENERATED_KEYS)) {
                    pst.setString(1, a.getPatientName());
                    pst.setString(2, a.getAddress());
                    pst.setString(3, a.getContactNo());
                    pst.executeUpdate();
                    try (ResultSet keys = pst.getGeneratedKeys()) {
                        if (keys.next()) patientId = keys.getInt(1);
                    }
                }
            } else {
                String usql = "UPDATE patients SET name=?, address=? WHERE patient_id=?";
                try (PreparedStatement pst = con.prepareStatement(usql)) {
                    pst.setString(1, a.getPatientName());
                    pst.setString(2, a.getAddress());
                    pst.setInt(3, patientId);
                    pst.executeUpdate();
                }
            }

            String sql = "INSERT INTO appointments(appointment_no,patient_id,dentist_id,treatment_type_id," +
                         "appointment_date,appointment_time,status,created_by,created_date) VALUES(?,?,?,?,?,?, 'PENDING', ?, NOW())";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, a.getAppointmentNo());
                pst.setInt(2, patientId);
                pst.setInt(3, a.getDentistId());
                pst.setInt(4, a.getTreatmentTypeId());
                pst.setDate(5, Date.valueOf(a.getAppointmentDate()));
                pst.setTime(6, Time.valueOf(normalizeTime(a.getAppointmentTime())));
                pst.setInt(7, a.getCreatedBy());
                pst.executeUpdate();
            }
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (con != null) try { con.rollback(); } catch (Exception ignored) {}
            return false;
        } finally {
            if (con != null) try { con.close(); } catch (Exception ignored) {}
        }
    }

    private int findPatientByContact(Connection con, String contact) throws SQLException {
        String sql = "SELECT patient_id FROM patients WHERE contact_no=?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, contact);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) return rs.getInt("patient_id");
            }
        }
        return 0;
    }

    public Appointment getAppointmentByNo(String no) {
        String sql = baseSelect() + " WHERE a.appointment_no=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, no);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) return map(rs);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    public List<Appointment> getAppointmentsForDentist(int dentistId) {
        String sql = baseSelect() + " WHERE a.dentist_id=? ORDER BY a.appointment_date, a.appointment_time";
        List<Appointment> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, dentistId);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) list.add(map(rs));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public List<Appointment> getAllAppointments() {
        return getBySql(baseSelect() + " ORDER BY a.appointment_date DESC, a.appointment_time");
    }

    public List<Appointment> getTodayAppointments() {
        return getBySql(baseSelect() + " WHERE a.appointment_date=CURDATE() ORDER BY a.appointment_time");
    }

    public List<Appointment> getApprovedAppointments() {
        return getBySql(baseSelect() + " WHERE a.status='APPROVED' ORDER BY a.appointment_date DESC");
    }

    private List<Appointment> getBySql(String sql) {
        List<Appointment> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) list.add(map(rs));
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public boolean updateAppointmentStatus(String appointmentNo, int dentistId, String status) {
        String sql = "UPDATE appointments SET status=? WHERE appointment_no=? AND dentist_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, status);
            pst.setString(2, appointmentNo);
            pst.setInt(3, dentistId);
            return pst.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    private String baseSelect() {
        return "SELECT a.appointment_no,a.patient_id,p.name AS patient_name,p.address,p.contact_no," +
               "a.dentist_id,d.name AS dentist_name,a.treatment_type_id,t.type_name,t.fee," +
               "a.appointment_date,a.appointment_time,a.status,a.created_by " +
               "FROM appointments a JOIN patients p ON a.patient_id=p.patient_id " +
               "JOIN dentists d ON a.dentist_id=d.dentist_id " +
               "JOIN treatment_types t ON a.treatment_type_id=t.treatment_type_id";
    }

    private Appointment map(ResultSet rs) throws SQLException {
        Appointment a = new Appointment();
        a.setAppointmentNo(rs.getString("appointment_no"));
        a.setPatientId(rs.getInt("patient_id"));
        a.setPatientName(rs.getString("patient_name"));
        a.setAddress(rs.getString("address"));
        a.setContactNo(rs.getString("contact_no"));
        a.setDentistId(rs.getInt("dentist_id"));
        a.setDentistName(rs.getString("dentist_name"));
        a.setTreatmentTypeId(rs.getInt("treatment_type_id"));
        a.setTreatmentType(rs.getString("type_name"));
        a.setTreatmentFee(rs.getDouble("fee"));
        a.setAppointmentDate(rs.getDate("appointment_date").toString());
        a.setAppointmentTime(rs.getTime("appointment_time").toString().substring(0,5));
        a.setStatus(rs.getString("status"));
        a.setCreatedBy(rs.getInt("created_by"));
        return a;
    }

    private String normalizeTime(String time) {
        return time.length() == 5 ? time + ":00" : time;
    }
}
