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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.Collections.list;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import java.lang.Math.*;




/**
 *
 * @author Ian
 */
public class Query {

    

    public Statement stmt;
    private String query;

    
    
    //get column names
    public ResultSet getColumnNames(Connect conn, String table) throws SQLException{
        
        stmt = Connect.connect.createStatement();
        query = "DESCRIBE " + table + ";";
        
        ResultSet rs = stmt.executeQuery(query);
        
        return rs;
    }




    //constructor takes a connect object and creatse statement for query
    public Query(Connect conn) throws SQLException {
        //get a statement
        stmt = Connect.connect.createStatement();
        System.out.println("Query object connected...");
    }

    //will print out all entries for a give table and field
    public void getValue(String table, String field) throws SQLException {
        query = "SELECT " + field + " FROM " + table + ";";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            System.out.print(
                    rs.getString(field) + "\n");
        }
    }
    
    
    //this method will return the query as a List
    //use this example to get other methods to return as a list
    public void getUsers(Connect conn){
        
        query = "Select * FROM users;";
        
        List result = null;
        
        
        try{
            QueryRunner runner = new QueryRunner();
            result = (List) runner.query(conn.returnConn(), query, new MapListHandler());
        } catch (Exception e){
            e.printStackTrace();
        }
        
        for(int i = 0; i < result.size();i++){
           result = (List) result.get(i);
           System.out.println(result);
        }
    }

    //prints out a whole table, takes table name as argument
    public ResultSet getTable(String table) throws SQLException {

        query = "SELECT * FROM " + table;

        ResultSet rs = stmt.executeQuery(query);
        return rs;

    }

    //get all visits from a user ordered by the date of the visit
    public void getUserVisits(String email) throws SQLException {
        
        //statement is hardcoded, only takes the email
        String query = "SELECT users.email, users.fname, users.lname, visits.email, "
                + "visits.visitDate, visits.reason "
                + " FROM users"
                + " INNER JOIN visits"
                + " WHERE users.email='" + email +"'" 
                + " ORDER BY visits.visitDate";

        //get results of query
        ResultSet rs = stmt.executeQuery(query);

        //print each line of the query
        while (rs.next()) {
            System.out.print(
                    rs.getString("users.email") + " | "
                    + rs.getString("users.lname") + " | "
                    + rs.getDate("visitDate") + " | "
                    + rs.getTime("visitDate") + " | "
                    + rs.getString("reason"));

            System.out.println();
        }
    }

    public void closeQuery() {

    }
}

//SELECT Customers.CustomerName, Orders.OrderID
//FROM Customers
//INNER JOIN Orders
//ON Customers.CustomerID=Orders.CustomerID
//ORDER BY Customers.CustomerName;
