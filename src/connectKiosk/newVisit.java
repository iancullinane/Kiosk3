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

/**
 *
 * @author Ian
 */
public class newVisit {
    
    //names of everything
    private String reason;
    private String email;
    private String location;
    
    
    //create a statement to be used 
    public Statement stmt;
    private String query;

        
    //constructor?
    public newVisit(Connect conn) throws SQLException{
        //get a statement
        stmt = Connect.connect.createStatement();
        System.out.println("Created DB Connection....");
        
       
    }
    
    //new entry takes all the necessary fields
    public void newEntry(String reason, String email, String location) throws SQLException{
        
        query = "insert into visits "
                + "(reason, email, location) values ("
                + "'" + reason + "',"
                + "'" + email + "',"
                + "'" + location + "');";
        
        stmt.executeUpdate(query);
    }
    
  
}
