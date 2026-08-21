/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Pc
 */

public class StatisticsDAO {

    public int getTotalAppointments() {

        String sql ="SELECT COUNT(*) AS total "+ "FROM appointments";
        return getCount(sql);
    }

    public int getApprovedAppointments() {

        String sql ="SELECT COUNT(*) AS total "+ "FROM appointments "+ "WHERE status='APPROVED'";
        return getCount(sql);
    }

    public int getDeclinedAppointments() {

        String sql ="SELECT COUNT(*) AS total "+ "FROM appointments "+ "WHERE status='DECLINED'";
        return getCount(sql);
    }


    public int getPendingAppointments() {

        String sql ="SELECT COUNT(*) AS total "+ "FROM appointments "+ "WHERE status='PENDING'";
        return getCount(sql);
    }

    
    public int getCompletedAppointments() {

        String sql ="SELECT COUNT(*) AS total " + "FROM appointments "+ "WHERE status='COMPLETED'";
        return getCount(sql);
    }


    public int getCancelledAppointments() {

        String sql ="SELECT COUNT(*) AS total "+ "FROM appointments "+ "WHERE status='CANCELLED'";
        return getCount(sql);
    }


    public int getTotalPatients() {

        String sql ="SELECT COUNT(*) AS total "+ "FROM patients";
        return getCount(sql);
    }


    public double getTotalIncome() {

        String sql ="SELECT COALESCE(SUM(total),0) "+ "AS total_income "+ "FROM bills";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            if (rs.next()) {
                return rs.getDouble("total_income");
            }

        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }


    private int getCount(String sql) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("total");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}