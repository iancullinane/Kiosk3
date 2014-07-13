/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Admin;

import connectKiosk.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Ian
 */
public class AdminWindow extends JFrame {
    
    //data control
    private Connect conn;
    private Query query;
    private RecordControl recControl;
    
    //report window
    private JLabel title;
    private ReportPanel report;
    private TestButtons test;
    
    private JButton userButton;
    private JButton visitsButton;
    
    
    private final int WINDOW_WIDTH = 800; //Width
    private final int WINDOW_HEIGHT = 800; //Height
    
    private Border border;
    
    public AdminWindow() throws SQLException{
        //Display a title
        setTitle("Disability Resource Kiosk");
        //set the window size
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        //setExtendedState(Frame.MAXIMIZED_vBOTH);
        //setUndecorated(true);
        //Specify an action on close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Create a Border Layout
        setLayout(new MigLayout(
                "debug, fill", // Layout Constraints
                "[fill]", // Column constraints
                "[]")); // Row constraints
        
        
        
        
        title = new JLabel("User Table");
        Border paddingBorder = BorderFactory.createEmptyBorder(10,10,10,10);
        title.setBorder(BorderFactory.createCompoundBorder(border,paddingBorder));

        
        
        
        
        conn = new Connect();
        query = new Query(conn);
        
        report = new ReportPanel();
//        test = new TestButtons();
        userButton = new JButton("Get Users Table");
        visitsButton = new JButton("Get Visits Table");
//        test.getQuery.addActionListener(new AdminWindow.QueryButtonListener());
            
        userButton.addActionListener(new QueryButtonListener());
        visitsButton.addActionListener(new QueryButtonListener());
        
        add(title, "span, wrap");
        add(report, "span, wrap");
//        add(test);
        add(userButton, "span, wrap");
        add(visitsButton, "span, wrap");
        

        //set the windows position to the center of the screen
        setLocationRelativeTo(null);
        //Make the window visable
        setVisible(true);
    }
    
    private class QueryButtonListener implements ActionListener
  {
      public void actionPerformed(ActionEvent e)
      {
          if (e.getSource() == userButton)
          {
              try {
                  conn = new Connect();
                  query = new Query(conn);
                  
                  report.buildTable(query, "users");
              
              } catch (SQLException ex) {
                  Logger.getLogger(AdminWindow.class.getName()).log(Level.SEVERE, null, ex);
              }
        
          } else if (e.getSource() == visitsButton)
          {
              try {
                  conn = new Connect();
                  query = new Query(conn);
                  
                  report.buildTable(query, "visits");
              
              } catch (SQLException ex) {
                  Logger.getLogger(AdminWindow.class.getName()).log(Level.SEVERE, null, ex);
              }
      } 
    }
}}
