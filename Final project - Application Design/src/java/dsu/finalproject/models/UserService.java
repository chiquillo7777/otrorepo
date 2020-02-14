/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsu.finalproject.models;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chiquillo
 */
public class UserService {

    public List<User> listUsers() {
        // Step 1: Initialize connection objects
        List<User> listUsers = new ArrayList<>();
        Connection con = null;
        Statement stt = null;

        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?"
                    + "user=root&password=root&autoReconnect=true"
                    + "&useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

            // Step 2: Create a SQL statements string
            String query = "Select * from users";
            stt = con.createStatement();

            // Step 3: Execute SQL query
            rs = stt.executeQuery(query);
            // Step 4: Process the result set
            while (rs.next()) {
                listUsers.add(new User(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getString("password")));
            }
            System.out.print(listUsers.get(0));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUsers;
    }
    
    public static boolean login(String email, String password){
        Connection con = null;
        Statement stt = null;
        ResultSet rs = null;
        
          boolean status = false;
             try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?"
                    + "user=root&password=root&autoReconnect=true"
                    + "&useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

            // Step 2: Create a SQL statements string
           
            stt = con.createStatement();
            String query = "select * from users where email='email' and password='password'";
            status = stt.execute(query);

            // Step 3: Execute SQL query
             PreparedStatement ps = con.prepareStatement("select * from users where email=? and pass=?");
             ps.setString(1, email);
             ps.setString(2, password);
             
            rs = ps.executeQuery();
            // Step 4: Process the result set
            status = rs.next();
            System.out.println(status);
            
        } catch (SQLException e) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
          return status;
    }

    public boolean addUser(User user) {

        Connection con = null;
        

        PreparedStatement pStatement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?"
                    + "user=root&password=root&autoReconnect=true"
                    + "&useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

            String username = user.getUsername();
            String email = user.getEmail();
            String password = user.getPassword();
            String query = "insert into users (username,email, password) values (?,?,?)";
            pStatement = con.prepareStatement(query);
            pStatement.setString(1, username);
            pStatement.setString(2, email);
            pStatement.setString(3, password);
            return pStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
       
    }
    }



