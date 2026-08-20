/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pc
 */

public class DentistDAO {

    public List<Dentist> getAllDentists() {
        List<Dentist> list =new ArrayList<>();

        String sql =
                "SELECT d.* "
                + "FROM dentists d "
                + "JOIN users u "
                + "ON d.dentist_id=u.dentist_id "
                + "WHERE u.role='DENTIST' "
                + "ORDER BY d.name";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Dentist dentist =new Dentist();
                dentist.setDentistId(rs.getInt("dentist_id"));
                dentist.setName(rs.getString("name"));
                dentist.setEmail(rs.getString("email"));
                dentist.setPhone(rs.getString("phone"));
                dentist.setSpecialization(rs.getString("specialization"));
                list.add(dentist);}

        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    public Dentist getDentistById(
            int dentistId) {

        String sql ="SELECT * FROM dentists "+ "WHERE dentist_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, dentistId);
            ResultSet rs =pst.executeQuery();

            if (rs.next()) {

                Dentist dentist =new Dentist();
                dentist.setDentistId(rs.getInt("dentist_id"));
                dentist.setName(rs.getString("name"));
                dentist.setEmail(rs.getString("email"));
                dentist.setPhone(rs.getString("phone"));
                dentist.setSpecialization(rs.getString("specialization"));
                return dentist;
            }

        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
