/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBConnection;
import model.PatientNote;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pc
 */

public class PatientNoteDAO {
    public boolean addOrUpdateNote(String appointmentNo, int dentistId, String note) {
        String check = "SELECT note_id FROM patient_notes WHERE appointment_no=? AND dentist_id=?";
        try (Connection con = DBConnection.getConnection()) {
            int id = 0;
            try (PreparedStatement pst = con.prepareStatement(check)) {
                pst.setString(1, appointmentNo);
                pst.setInt(2, dentistId);
                try (ResultSet rs = pst.executeQuery()) { if (rs.next()) id = rs.getInt(1); }
            }
            if (id == 0) {
                String sql = "INSERT INTO patient_notes(appointment_no,dentist_id,note,note_date) VALUES(?,?,?,NOW())";
                try (PreparedStatement pst = con.prepareStatement(sql)) {
                    pst.setString(1, appointmentNo); pst.setInt(2, dentistId); pst.setString(3, note);
                    return pst.executeUpdate() > 0;
                }
            } else {
                String sql = "UPDATE patient_notes SET note=?, note_date=NOW() WHERE note_id=?";
                try (PreparedStatement pst = con.prepareStatement(sql)) {
                    pst.setString(1, note); pst.setInt(2, id);
                    return pst.executeUpdate() > 0;
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public List<PatientNote> getNotesByAppointment(String appointmentNo) {
        List<PatientNote> list = new ArrayList<>();
        String sql = "SELECT pn.*, d.name AS dentist_name FROM patient_notes pn JOIN dentists d ON pn.dentist_id=d.dentist_id " +
                     "WHERE pn.appointment_no=? ORDER BY pn.note_date DESC";
        try (Connection con = DBConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, appointmentNo);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    PatientNote n = new PatientNote();
                    n.setNoteId(rs.getInt("note_id"));
                    n.setAppointmentNo(rs.getString("appointment_no"));
                    n.setDentistId(rs.getInt("dentist_id"));
                    n.setDentistName(rs.getString("dentist_name"));
                    n.setNote(rs.getString("note"));
                    n.setNoteDate(rs.getTimestamp("note_date").toString());
                    list.add(n);
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}
