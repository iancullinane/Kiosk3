/**
 * @author Jacob Dwyer
 * Submit panel with speech to text buttons
 */
package GUI;

import Admin.AdminWindow;
import connectKiosk.RecordControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.miginfocom.swing.MigLayout;


public class SubmitPanel extends JPanel
{
    
    private Color buttonColor = new Color(26, 0, 180);
    private Color textColor = Color.WHITE;
    
    public JPanel panel_1 , panel_2, panel_3, panel_4, panel_5;
    public JButton submit, close, admin;
    public KioskButton test;
    
    //record control object?
    private RecordControl control;
    
    public SubmitPanel(ActionListener listen)
    {
        //Create grid layout
        super(new MigLayout(
                "", // Layout Constraints
                "[][grow, fill][]", // Column constraints
                "[center]")); // Row constraints
        
        
        
        //crete 5 panels for lame formatting
        panel_1 = new JPanel();
        panel_3 = new JPanel();
        panel_5 = new JPanel();
      
       //add them to the panel
        add(panel_1, "width 50:150:150");
        add(panel_3, "center");
        add(panel_5, "width 50:150:150");
        
        
        //create action buttons
        submit = new JButton("Submit");
        submit.setBackground(buttonColor);
        submit.setForeground(textColor);
        submit.setPreferredSize(new Dimension(200, 50));
        submit.addActionListener(listen);
        
        
        close = new JButton("Close");
        close.setBackground(buttonColor);
        close.setForeground(textColor);
        close.setPreferredSize(new Dimension(200, 50));
        close.addActionListener(listen);        
        
        admin = new JButton("Administrator");
        admin.setBackground(buttonColor);
        admin.setForeground(textColor);
        admin.setPreferredSize(new Dimension(200, 50));
        admin.addActionListener(listen);
        
        
        //add them to each panel
        
        panel_1.add(submit);
        panel_3.add(close);
        panel_5.add(admin);
        
    }
    
    public JButton getSubmit(){
        return submit;
    }    
}


