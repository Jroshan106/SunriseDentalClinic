/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pc
 */

public class UserDAO {

    public User login(String username, String password) {

        String sql = "SELECT user_id, username, password, role, dentist_id "
                   + "FROM users "
                   + "WHERE username=? AND password=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, username);
            pst.setString(2, password);

            try (ResultSet rs = pst.executeQuery()) 
            {

                if (rs.next()) {

                    User u = new User();

                    u.setUserId(rs.getInt("user_id"));

                    u.setUsername(rs.getString("username"));

                    u.setPassword(rs.getString("password"));

                    u.setRole(rs.getString("role"));

                    Object did = rs.getObject("dentist_id");

                    if (did != null) {

                        u.setDentistId(rs.getInt("dentist_id"));
                    }

                    return u;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean usernameExists(
            String username) {

        String sql =
                "SELECT user_id "
              + "FROM users "
              + "WHERE username=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, username);

            try (ResultSet rs = pst.executeQuery()) {

                return rs.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean createStaffAccount(
            String username,
            String password) 
    {

        String sql =
                "INSERT INTO users "
              + "(username,password,role,dentist_id) "
              + "VALUES(?,?,'STAFF',NULL)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, username);

            pst.setString(2, password);

            return pst.executeUpdate() > 0;

        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean createDentistAccount(
            String username,
            String password,
            String name,
            String email,
            String phone,
            String specialization) {

        Connection con = null;

        try {

            con = DBConnection.getConnection();

            con.setAutoCommit(false);

            String dentistSql =
                    "INSERT INTO dentists "
                  + "(name,email,phone,specialization) "
                  + "VALUES(?,?,?,?)";

            int dentistId = 0;

            try (PreparedStatement pst = con.prepareStatement(dentistSql,Statement.RETURN_GENERATED_KEYS)) 
            {

                pst.setString(1, name);

                pst.setString(2, email);

                pst.setString(3, phone);

                pst.setString(4, specialization);

                pst.executeUpdate();

                try (ResultSet rs = pst.getGeneratedKeys()) {

                    if (rs.next()) {
                        dentistId = rs.getInt(1);
                    }
                }
            }


            if (dentistId == 0) {
                con.rollback();
                return false;
            }


            String userSql =
                    "INSERT INTO users "
                  + "(username,password,role,dentist_id) "
                  + "VALUES(?,?,'DENTIST',?)";

            try (PreparedStatement pst = con.prepareStatement(userSql)) {

                pst.setString(1, username);

                pst.setString(2, password);

                pst.setInt(3, dentistId);

                pst.executeUpdate();
            }


            con.commit();

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            if (con != null) {

                try {
                    con.rollback();
                } 
                
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        } 
        
        finally {

            if (con != null) {

                try {
                    con.close();
                } 
                
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }


    public List<User> getAllUsers() {

        List<User> list = new ArrayList<>();

        String sql =
                "SELECT user_id, username, role, dentist_id "
              + "FROM users "
              + "ORDER BY user_id";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {

                User u = new User();

                u.setUserId(rs.getInt("user_id"));

                u.setUsername(rs.getString("username"));

                u.setRole(rs.getString("role"));

                Object did =
                        rs.getObject("dentist_id");

                if (did != null) {
                    u.setDentistId(rs.getInt("dentist_id"));
                }

                list.add(u);
            }

        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    public boolean resetPassword(
            int userId,
            String newPassword) {

        String sql =
                "UPDATE users "
              + "SET password=? "
              + "WHERE user_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, newPassword);

            pst.setInt(2, userId);

            return pst.executeUpdate() > 0;

        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean deleteUser(
            int userId) {

        String checkSql =
                "SELECT role "
              + "FROM users "
              + "WHERE user_id=?";

        try (Connection con = DBConnection.getConnection()) {

            String role = null;

            try (PreparedStatement pst = con.prepareStatement(checkSql)) {
                pst.setInt(
                        1,
                        userId
                );

                try (ResultSet rs = pst.executeQuery()) {

                    if (rs.next()) {

                        role = rs.getString("role");
                    }
                }
            }


            if (role == null) {

                return false;
            }

            if ("ADMIN".equalsIgnoreCase(role)) {

                return false;
            }


            String deleteSql =
                    "DELETE FROM users "
                  + "WHERE user_id=?";

            try (PreparedStatement pst =con.prepareStatement(deleteSql)) {

                pst.setInt(1, userId);
 
                return pst.executeUpdate() > 0;
            }

        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}