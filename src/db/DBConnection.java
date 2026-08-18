package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/sunrise_dental_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final DBConnection INSTANCE = new DBConnection();

    private DBConnection() {
    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found. Add mysql-connector-java-5.1.49.jar to Libraries.", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
