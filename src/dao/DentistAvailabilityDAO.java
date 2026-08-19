/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBConnection;
import model.DentistAvailability;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pc
 */
public class DentistAvailabilityDAO {
    public boolean addAvailability(DentistAvailability a) {
        String sql = "INSERT INTO dentist_availability(dentist_id,available_date,start_time,end_time,is_available) VALUES(?,?,?,?,1)";
        try (Connection con = DBConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, a.getDentistId());
            pst.setDate(2, Date.valueOf(a.getAvailableDate()));
            pst.setTime(3, Time.valueOf(norm(a.getStartTime())));
            pst.setTime(4, Time.valueOf(norm(a.getEndTime())));
            return pst.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public boolean deleteAvailability(int availabilityId, int dentistId) {
        String sql = "DELETE FROM dentist_availability WHERE availability_id=? AND dentist_id=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, availabilityId);
            pst.setInt(2, dentistId);
            return pst.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public List<DentistAvailability> getByDentist(int dentistId) {
        List<DentistAvailability> list = new ArrayList<>();
        String sql = "SELECT da.*, d.name AS dentist_name FROM dentist_availability da JOIN dentists d ON da.dentist_id=d.dentist_id " +
                     "WHERE da.dentist_id=? ORDER BY da.available_date, da.start_time";
        try (Connection con = DBConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, dentistId);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) list.add(map(rs));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public List<DentistAvailability> getAll() {
        List<DentistAvailability> list = new ArrayList<>();
        String sql = "SELECT da.*, d.name AS dentist_name FROM dentist_availability da JOIN dentists d ON da.dentist_id=d.dentist_id " +
                     "ORDER BY da.available_date, d.name, da.start_time";
        try (Connection con = DBConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
            while (rs.next()) list.add(map(rs));
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    private DentistAvailability map(ResultSet rs) throws SQLException {
        DentistAvailability a = new DentistAvailability();
        a.setAvailabilityId(rs.getInt("availability_id"));
        a.setDentistId(rs.getInt("dentist_id"));
        a.setDentistName(rs.getString("dentist_name"));
        a.setAvailableDate(rs.getDate("available_date").toString());
        a.setStartTime(rs.getTime("start_time").toString().substring(0,5));
        a.setEndTime(rs.getTime("end_time").toString().substring(0,5));
        a.setAvailable(rs.getBoolean("is_available"));
        return a;
    }

    private String norm(String time) { return time.length()==5 ? time+":00" : time; }
}
