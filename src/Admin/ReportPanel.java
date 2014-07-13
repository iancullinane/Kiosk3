/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import connectKiosk.Query;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Ian
 */
public class ReportPanel extends JPanel {

    private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;

    ResultSet res;

    
    //default constructor with no table data set
    //adds a blank table to the window
    public ReportPanel() {
        super(new MigLayout(
                "", // Layout Constraints
                "[fill]", // Column constraints
                "[fill]")); // Row constraints
        
        table = new JTable();
        scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scroll, "span, push");

    }

    //constructor that displays a table on creation
    //THIS CONSRUCTOR CURRENTLY NOT BEING USED
    public ReportPanel(Query query) throws SQLException {
        super(new MigLayout(
                "", // Layout Constraints
                "[fill]", // Column constraints
                "[fill]")); // Row constraints
        table = new JTable(buildTableModel(res));
        scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scroll, "span, push");

    }
    
    //mthod to build a new table, second argument is used to get entire table
    public void buildTable(Query query, String tableChoice) throws SQLException{
        
        //get a query, build a table model, set the new table
        res = query.getTable(tableChoice);
        model = this.buildTableModel(res);
        table.setModel(model);

        
        
    }
    
    
    //table model to add data to the table
    public DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            String tempName = columnNameChecker(metaData.getColumnName(column));
            
            columnNames.add(tempName);
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }
    
    //method to change column names to more readable format for user
    //called withing the buildTableMehod
    //TODO: add if/else for visits table
    public String columnNameChecker (String name) {
        String newName = "";
        
        if(name.equals("fname")){
            name = "First Name";
        } else if(name.equals("lname")){
            name = "Last Name";
        } else if(name.equals("email")){
            name = "Email";
        } else if(name.equals("Role")){
            name = "Role";
        }else if(name.equals("lname")){
            name = "Last Name";
        }         
        
        return name;
        
    }
}
