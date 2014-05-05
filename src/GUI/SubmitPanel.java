/**
 * @author Jacob Dwyer
 * Submit panel with speech to text buttons
 */
package GUI;

import Admin.AdminWindow;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SubmitPanel extends JPanel
{
    public JPanel panel_1 , panel_2, panel_3, panel_4, panel_5;
    public JButton submit, close, admin;
    
    public SubmitPanel()
    {
        //Create grid layout
        super(new GridLayout(0,3));
        //crete 5 panels for lame formatting
        panel_1 = new JPanel(new GridLayout(0,2));
        
        panel_3 = new JPanel(new GridLayout(0,2));
        
        panel_5 = new JPanel(new GridLayout(0,2));
      
       //add them to the panel
        add(panel_1);
       
        add(panel_3);
       
        add(panel_5);
        
        
        //create action buttons
        submit = new JButton("Submit");
        submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        
        close = new JButton("Close");
        close.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        
        admin = new JButton("Administrator");
        admin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new AdminWindow();
                } catch (SQLException ex) {
                    Logger.getLogger(SubmitPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        //add them to each panel
        
        panel_1.add(submit);

        
        panel_3.add(close);
        
       
        panel_5.add(admin);
    }
    
    public JButton getSubmit(){
        return submit;
    }
    
    
}


