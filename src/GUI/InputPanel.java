/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Ian
 */
public class InputPanel extends JPanel {
    
    
    JLabel fName, lName, email, phone, role, reason, location, followUp;
    JComboBox reasonBox, locationBox, roleBox;
    JCheckBox followCheck;
    
    JTextField fNameField, lNameField, emailField, phoneField;
    
    public Font font = new Font("SERIF", Font.BOLD, 24);
    
    private final int CHAR_LENGTH = 30;
    
    public InputPanel(){
        super(new GridBagLayout());
        buildPanel();
        setVisible(true);
    }
    
    public void buildPanel(){
        
        GridBagConstraints grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.HORIZONTAL;
        
        //first
        fName = new JLabel("First Name: ");
        fName.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 2;
        grid.gridwidth = 1;
        add(fName, grid);
        
        
        //first name input
        fNameField = new JTextField(CHAR_LENGTH);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 2;
        grid.gridwidth = 4;
        add(fNameField, grid);
        
        //last
        lName = new JLabel("Last Name: ");
        lName.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 3;
        grid.gridwidth = 1;
        add(lName, grid);
        
        
        //last name input
        lNameField = new JTextField(CHAR_LENGTH);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 3;
        grid.gridwidth = 4;
        add(lNameField, grid);
        
        //role
        role = new JLabel("Role: ");
        role.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 4;
        grid.gridwidth = 1;
        add(role, grid);
        
        //RoleI
        String[] roles = {"Student", "Teacher", "Parent", "Administrator"};
        roleBox = new JComboBox(roles);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 4;
        grid.gridwidth = 4;
        add(roleBox, grid);
        
        //email
        email = new JLabel("Email: ");
        email.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 5;
        grid.gridwidth = 1;
        add(email, grid);
        
        
        //email input
        emailField = new JTextField(CHAR_LENGTH);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 5;
        grid.gridwidth = 4;
        add(emailField, grid);
        
        //phone
        phone = new JLabel("Phone: ");
        phone.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 6;
        grid.gridwidth = 1;
        add(phone, grid);
        
        
        //phone input
        phoneField = new JTextField(CHAR_LENGTH);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 6;
        grid.gridwidth = 4;
        add(phoneField, grid);
        
        
        //reason
        reason = new JLabel("Reason: ");
        reason.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 7;
        grid.gridwidth = 1;
        add(reason, grid);
        
        //reasonI
        String[] reasons = {"New, Prospective Student/Group","Disclose and Document Disability (In-take)","Placement Testing with Accommodation",
      "Schedule An Appointment with Disability Specialist","Meet with a Disability Specialist","Take Test with Accommodations","Drop Off/Pick Up Notes",
      "Academic Advising (Course Selection, Add/Drop, Withdrawal)","Fill Out Accommodation Forms","Address Problems with Specific Accommodations",
      "Address Specific Course Assignment or Issue","Alternative Format for Texts and Handouts",
      "Professional Consultation (Faculty, Staff, Administration, Department)","Other"};
          reasonBox = new JComboBox(reasons);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 7;
        grid.gridwidth = 4;
        add(reasonBox, grid);
        
          //location
       
        location = new JLabel("Location: ");
        location.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 8;
        grid.gridwidth = 1;
        
        add(location, grid);
        
        //LocationI
        String[] locations = {"Framingham", "Wellesley", "Ashland"};
        locationBox = new JComboBox(locations);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 8;
        grid.gridwidth = 4;
        add(locationBox, grid);
        
        //phone
        followUp = new JLabel("Follow Up: ");
        followUp.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 9;
        grid.gridwidth = 1;
        add(followUp, grid);
        
        
        //phone input
        followCheck = new JCheckBox();
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 9;
        grid.gridwidth = 4;
        add(followCheck, grid);
    }
}
