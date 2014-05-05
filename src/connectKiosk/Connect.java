/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectKiosk;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ian
 */
public class Connect {

    //connect variable, when a query is made take this value
    //will not work unless a Connect object has been made
    public static Connection connect = null;
    
    
    public Connection returnConn(){
        return connect;
    }


//constructor will build the connection, thats it
    public Connect() throws SQLException {
        System.out.println (
        "-------- MySQL JDBC Connection Testing ------------");
        
        
        //get the driver from JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("No Driver?");
            e.printStackTrace();
            return;
        }
        
        //confirm driver found
        System.out.println (
                "MySQL JDBC Driver Registered");
        
        
        
        
        //connect to the database
        try {
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/kiosk", "eignh", "#mountain08");
        } catch (SQLException e) {
            System.out.println("Connection Failed at host name, port, un");
            e.printStackTrace();
            return;
        }

        if (connect != null) {
            System.out.println("Database Connected");
        } else {
            System.out.println("Failed to make connection!");
        }
    }
    
    //close a connection, cannot be reopened, a new object needs to be created to do so
    public void closeConnect() throws SQLException{
        System.out.println("\ngood bye");
        connect.close();
    }
}
