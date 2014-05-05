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

/**
 *
 * @author Ian
 */
public class ReportPanel extends JPanel{
    
    
    
    private JScrollPane scroll;
    
    private JTable table;
    
    ResultSet res;
    
    public ReportPanel(){
        super(new GridLayout(3, 1));
        
        scroll = new JScrollPane();
        
    }
    
    public ReportPanel(Query query) throws SQLException{
        super(new GridLayout(3, 1));
        this.setBorder(new EmptyBorder(10, 10, 10, 10) );
        
        //table = new DefaultTableModel();
        
        res = query.getTable("visits");
        table = new JTable(buildTableModel(res));
        
        scroll = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        add(scroll);
        
    }
    
    
    
    
    public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
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
}
