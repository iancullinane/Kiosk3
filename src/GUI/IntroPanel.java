/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Font;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Ian
 */
public class IntroPanel extends JPanel {

    Font font1 = new Font("Book Antiqua", Font.PLAIN, 30);

    public IntroPanel() throws MalformedURLException {

        JLabel greetings = new JLabel("Welcome to the Disability Resource Center Kiosk");
        greetings.setFont(font1);
        setBorder(new EmptyBorder(10, 50, 10, 50) );
        
        add(greetings);

    }

}
