/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectKiosk;

import com.mysql.jdbc.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.SQLException;
import java.text.DateFormat;

/**
 *
 * @author Ian
 */
public class RecordControl {
    
    //to select a table
    private String table;
    

    
    //create a statement to be used 
    public Statement stmt;
    private String query = null;

        
    //constructor,establishes connection
    public RecordControl(Connect conn) throws SQLException{
        //get a statement
        stmt = Connect.connect.createStatement();
        System.out.println("Record Control Object Connected");
        
       
    }
    
    
    
//    //PREFERRED CONSTRUCTOR WILL ENTER
//    //second constructor, will only take all data, makes a "complete" entry 
//    public RecordControl(Connect conn, String fname, String lname, String email, String description, String phone, String role) throws SQLException {
//
//        boolean found = false;
//        
//        
//        stmt = Connect.connect.createStatement();
//        System.out.println("Created DB Connection....");
//        
//        //get every user email
//        query = "SELECT email FROM users";
//        ResultSet rs = stmt.executeQuery(query);
//        
//        //cycle through results looking for that email
//        //sets found to true
//        while (rs.next()) {
//            if (rs.getString("email") == email) {
//                found = true;
//            }
//        }
//
//        if (found == false) {
//            query = "INSERT INTO USERS (fname, lname, email, description, phone, role) "
//                    + "values "
//                    + "('" + fname + "',"
//                    + "'" + lname + "',"
//                    + "'" + email + "',"
//                    + "'" + description + "',"
//                    + "'" + phone + "',"
//                    + "'" + role + "');";
//
//            stmt.executeUpdate(query);
//        } else {
//            System.out.println("User already exists");
//        }
//    }
    
    //adds a new user, takes all fields as argument
    public void newUser(String fname, String lname, String email, String description, String phone, String role ) throws SQLException{
        boolean found = false;
        query = "SELECT email FROM users";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            if (rs.getString("email") == email) {
                found = true;
            }
        }

        //if that user wasn't in the db continue
        if (found == false) {
            query = "INSERT INTO USERS (fname, lname, email, description, phone, role) "
                    + "values "
                    + "('" + fname + "',"
                    + "'" + lname + "',"
                    + "'" + email + "',"
                    + "'" + description + "',"
                    + "'" + phone + "',"
                    + "'" + role + "');";

            stmt.executeUpdate(query);
        } else {
            System.out.println("User already exists");
        }
    }
    
    
    //adds a new visit
    public void newVisit(String reason, int follow, String location, String email) throws SQLException{
       
         DateFormat dfshort = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        
        query = "INSERT INTO visits (reason, follow, location, email) "
                + "values "
                + "('" + reason + "',"
                + "'" + follow + "',"
                + "'" + location + "',"
                + "'" + email + "');";
        
        stmt.executeUpdate(query);
    }
    
    public void deleteRecord(){
        
    }
    
    
    
    
    
    //deletes a user by their email
    public void delUser(String email) throws SQLException{
        
        query = "DELETE FROM users WHERE email = " + email + ";";
        stmt.executeUpdate(query);
    };
    
    
    
}
