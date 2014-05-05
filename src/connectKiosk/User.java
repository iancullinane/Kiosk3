/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectKiosk;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;

/**
 *
 * @author Ian
 */
public class User {
  //table to use
    private String table;
    
    //names of everything
    private String fname;
    private String lname;
    private String email;
    private String desc;
    private String phone;
    private String role;
    
    
    public Statement stmt;
    private String query;
    
    //constructor takes a connect object and generates a statement for query
    public User(Connect conn) throws SQLException{

        //get a statement
        stmt = Connect.connect.createStatement();
       
    }
    
    
    //prints out the whole tables]
    public void getUserTable() throws SQLException{
        
        query = "SELECT lname, fname, email, description, phone, role FROM users";
        
        ResultSet rs = stmt.executeQuery(query);
        
        while(rs.next()){
                System.out.println(
                        rs.getString("fname") + " " + 
                        rs.getString("lname") + "\n" + 
                        "email: " + rs.getString("email") + "\n" +
                        "description: " + rs.getString("description") + "\n" +
                        "phone: " + rs.getString("phone") + "\n" +
                        "role: " + rs.getString("role")
                        + "\n");
                
               
               System.out.println(); 
                
            }
    }   
}
