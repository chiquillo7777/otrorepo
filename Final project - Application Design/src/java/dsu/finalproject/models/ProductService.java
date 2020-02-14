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
 * @author carlos.chiquillo
 */
public class ProductService {
    
     public boolean addProduct(Product product) {

        Connection con = null;
        

        PreparedStatement pStatement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?"
                    + "user=root&password=root&autoReconnect=true"
                    + "&useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

            String name = product.getName();
            String description = product.getDescription();
            String category = product.getCategory();
            Float price = product.getPrice();
            String query = "insert into products (name, description, category, price) values (?,?,?,?)";
            pStatement = con.prepareStatement(query);
            pStatement.setString(1, name);
            pStatement.setString(2, description);
            pStatement.setString(3, category);
            pStatement.setFloat(4, price);
            return pStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
       
    }
     
    
    
    public List<String> getProductByCategory() {
        // Step 1: Initialize connection objects
        List<String> categories = new ArrayList<>();
        Connection con = null;
        Statement stt = null;

        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?"
                    + "user=root&password=root&autoReconnect=true"
                    + "&useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

            // Step 2: Create a SQL statements string
            String query = "Select * from products";
            stt = con.createStatement();

            // Step 3: Execute SQL query
            rs = stt.executeQuery(query);
            // Step 4: Process the result set
            while (rs.next()) {
                categories.add(rs.getString("category"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }
}
