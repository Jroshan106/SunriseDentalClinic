package dao;

import db.DBConnection;
import model.Dentist;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DentistDAO {
    public List<Dentist> getAllDentists() {
        List<Dentist> list = new ArrayList<>();
        String sql = "SELECT d.* FROM dentists d JOIN users u ON d.dentist_id=u.dentist_id "
                   + "WHERE u.role='DENTIST' ORDER BY d.name";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Dentist d = new Dentist();
                d.setDentistId(rs.getInt("dentist_id"));
                d.setName(rs.getString("name"));
                d.setEmail(rs.getString("email"));
                d.setPhone(rs.getString("phone"));
                d.setSpecialization(rs.getString("specialization"));
                list.add(d);
            }
        } catch (Exception e) {}
        return list;
    }

    public Dentist getDentistById(int id) {
        String sql = "SELECT * FROM dentists WHERE dentist_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Dentist d = new Dentist();
                    d.setDentistId(rs.getInt("dentist_id"));
                    d.setName(rs.getString("name"));
                    d.setEmail(rs.getString("email"));
                    d.setPhone(rs.getString("phone"));
                    d.setSpecialization(rs.getString("specialization"));
                    return d;
                }
            }
        } catch (Exception e) {}
        return null;
    }
}
