package dsu.finalproject;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlos.chiquillo
 */
public class DBConnection {

    public static Connection con;
    public static Statement stt;
    
    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?" +
                "user=root&password=root&autoReconnect=true" +
                "&useSSL=false&allowPublicKeyRetrieval=true");
        
        stt = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
        }
        
    }

}
