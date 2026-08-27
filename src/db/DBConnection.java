/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author rxam
 */
public class DBConnection {
    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName(
            "com.mysql.jdbc.Driver");

            con = (Connection) DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/sunrise_dental_db",
            "root",
            "");
            
            System.out.println("Database Connected");
        }
        catch(Exception e){
            System.out.println(e);
        }
        return con;

    }
}
