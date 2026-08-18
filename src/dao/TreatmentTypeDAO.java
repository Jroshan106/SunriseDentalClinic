package dao;

import db.DBConnection;
import model.TreatmentType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TreatmentTypeDAO {
    public List<TreatmentType> getAllTreatmentTypes() {
        List<TreatmentType> list = new ArrayList<>();
        String sql = "SELECT * FROM treatment_types ORDER BY type_name";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                TreatmentType t = new TreatmentType();
                t.setTreatmentTypeId(rs.getInt("treatment_type_id"));
                t.setTypeName(rs.getString("type_name"));
                t.setDescription(rs.getString("description"));
                t.setFee(rs.getDouble("fee"));
                list.add(t);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}
