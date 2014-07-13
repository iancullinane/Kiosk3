/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.net.MalformedURLException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Ian
 */
public class NewsPanel extends JPanel {
    
    JLabel greetings;
    
    public NewsPanel() throws MalformedURLException {
        super(new MigLayout(
                "", // Layout Constraints
                "[fill]", // Column constraints
                "[fill]")); // Row constraints

        greetings = new JLabel("");
        setBorder(new EmptyBorder(10, 50, 10, 50) );
        
        add(greetings);

    }
    
    public void changeText (String newText){
        greetings.setText(newText);
                
    }

}

    

