/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBConnection;
import model.TreatmentType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pc
 */

public class TreatmentTypeDAO {

    public List<TreatmentType> getAllTreatmentTypes() {

        List<TreatmentType> list =new ArrayList<>();

        String sql ="SELECT * FROM treatment_types "+ "ORDER BY type_name";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {TreatmentType treatment =new TreatmentType();
                treatment.setTreatmentTypeId(rs.getInt("treatment_type_id"));
                treatment.setTypeName(rs.getString("type_name"));
                treatment.setDescription(rs.getString("description"));
                treatment.setFee(rs.getDouble("fee"));
                list.add(treatment);
            }

        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public boolean updateTreatmentPrice(int treatmentTypeId,double newPrice) {

        String sql ="UPDATE treatment_types "+ "SET fee=? "+ "WHERE treatment_type_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setDouble(1, newPrice);
            pst.setInt(2, treatmentTypeId);
            return pst.executeUpdate() > 0;

        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}