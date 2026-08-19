/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBConnection;
import model.Bill;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pc
 */
public class BillDAO {
    public boolean saveBill(Bill b) {
        String sql = "INSERT INTO bills(appointment_no,consultation_fee,treatment_fee,discount,total,bill_date) " +
                     "VALUES(?,?,?,?,?,NOW()) ON DUPLICATE KEY UPDATE consultation_fee=VALUES(consultation_fee)," +
                     "treatment_fee=VALUES(treatment_fee),discount=VALUES(discount),total=VALUES(total),bill_date=NOW()";
        try (Connection con = DBConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, b.getAppointmentNo());
            pst.setDouble(2, b.getConsultationFee());
            pst.setDouble(3, b.getTreatmentFee());
            pst.setDouble(4, b.getDiscount());
            pst.setDouble(5, b.getTotal());
            return pst.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public List<Bill> getAllBills() {
        List<Bill> list = new ArrayList<>();
        String sql = "SELECT * FROM bills ORDER BY bill_date DESC";
        try (Connection con = DBConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Bill b = new Bill();
                b.setBillId(rs.getInt("bill_id"));
                b.setAppointmentNo(rs.getString("appointment_no"));
                b.setConsultationFee(rs.getDouble("consultation_fee"));
                b.setTreatmentFee(rs.getDouble("treatment_fee"));
                b.setDiscount(rs.getDouble("discount"));
                b.setTotal(rs.getDouble("total"));
                b.setBillDate(rs.getTimestamp("bill_date").toString());
                list.add(b);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public double getTotalRevenue() {
        String sql = "SELECT COALESCE(SUM(total),0) AS total_revenue FROM bills";
        try (Connection con = DBConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
            if (rs.next()) return rs.getDouble("total_revenue");
        } catch (Exception e) { e.printStackTrace(); }
        return 0;
    }
}
