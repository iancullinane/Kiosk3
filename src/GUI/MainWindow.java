/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import javax.swing.JFrame;

/**
 *
 * @author Ian
 */
public class MainWindow extends JFrame {

    private final int WINDOW_WIDTH = 800; //Width
    private final int WINDOW_HEIGHT = 800; //Height

    private final IntroPanel header;
    private final InputPanel input;
    private final SubmitPanel submit;
    
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public MainWindow() throws MalformedURLException {
        //Display a title
        setTitle("Disability Resource Kiosk");
        //set the window size
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setExtendedState(MAXIMIZED_BOTH);
        setSize(screenSize);
        //setUndecorated(true);
        //Specify an action on close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Create a Border Layout
        
        setResizable(false);
        
        //initiate the three panels we need
        
        
        
       
        //add the panels
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        
        header = new IntroPanel();
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = 10;
        c.ipadx = 40;
        c.ipady = 30;
        c.gridwidth = 2;
        add(header, c);
        
        input = new InputPanel();
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = 20;
        c.ipadx = 40;
        c.ipady = 30;
        c.gridwidth = 2;
        add(input, c);
        
        submit = new SubmitPanel();
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = 30;
        c.ipadx = 40;
        c.ipady = 30;
        c.gridwidth = 1;
        add(submit, c);

        //set the windows position to the center of the screen
        setLocationRelativeTo(null);
        //Make the window visable
        setVisible(true);
    }
    
    
    

}

