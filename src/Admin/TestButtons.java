/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Admin;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Ian
 */
public class TestButtons extends JPanel {
    
    
    
    public JButton getQuery;
    
  
    
    public TestButtons(){
        super(new GridLayout(3, 1));
        buildPanel();
        setVisible(true);
        
       
    }
    
    public void buildPanel(){
        getQuery = new JButton("Get Query");
        
        
        add(getQuery);
        
    }
    
    public JButton getGetQuery(){
        return this.getQuery;
    }
    
    }

