/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Admin.AdminWindow;
import connectKiosk.RecordControl;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import static sun.swing.SwingUtilities2.submit;

/**
 *
 * @author Ian
 */
public class MainWindow extends JFrame {

    private final int WINDOW_WIDTH = 800; //Width
    private final int WINDOW_HEIGHT = 800; //Height

    //three panel objects
    private final IntroPanel header;
    final InputPanel input;
    final SubmitPanel submitP;
    
    //create a record control object to store a new user
    private RecordControl control;
    
    //listener instance
    private ActionListener listener;

    //for fullscreen
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public MainWindow() throws MalformedURLException {

        //set things like size, close operation, etc
        this.Build();
        
        //panel which will hold three panels
        JPanel panel = new JPanel(new MigLayout(
                "debug, fill", // Layout Constraints
                "10", // Column constraints
                "")); // Row constraints

         listener = new SubmitPanelListener();
        
        //initiate the three panels we need for user actions
        header = new IntroPanel();
        input = new InputPanel();
        submitP = new SubmitPanel(listener);
        
        
        
        panel.add(header, "span, center, aligny bottom, pushy, w 800");
        panel.add(input, "span, center, w 800");
        panel.add(submitP, "span, center, aligny top, pushy, w 800");
        
        

        panel.setBackground(Color.white);
        
        this.setContentPane(panel);
        this.setBackground(Color.white);
//        this.setLayout(new GridBagLayout());
//        add(panel, new GridBagConstraints());

        //set the windows position to the center of the screen
        setLocationRelativeTo(null);
        //Make the window visable
        setVisible(true);
        
    }

    public void Build() {
        //Display a title
        setTitle("Disability Resource Kiosk");
        //set the window size
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setExtendedState(MAXIMIZED_BOTH);
        setSize(screenSize);
        //setUndecorated(true);
        //Specify an action on close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        //this.setLayout());
    }
    
    public void newUser() throws SQLException{
        control.newUser(input.getTextFName(), 
                null, 
                null, 
                null, 
                null, 
                null);
    }
    
 
    //listener class which is passed into the submit panel
    //by keeping it a memeber of MainWindow it can access all panels
    public class SubmitPanelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == submitP.submit){
                System.out.println("fuck yeaaaaaaa");
            } else if(ae.getSource() == submitP.close){
                System.exit(0);
            } else if(ae.getSource() == submitP.admin){
                try {
                    new AdminWindow();
                } catch (SQLException ex) {
                    Logger.getLogger(SubmitPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
    
}

