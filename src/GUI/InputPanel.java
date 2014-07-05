/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import static java.awt.font.TextAttribute.FONT;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Ian
 */
public class InputPanel extends JPanel {

    JLabel fName, lName, email, phone, role, reason, location, followUp;
    JTextField fNameField, lNameField, emailField, phoneField;
    
    JComboBox reasonBox, locationBox, roleBox;
    JCheckBox followCheck;
    
    public Font font = new Font("SERIF", Font.BOLD, 24);

    public InputPanel() {
        super(new MigLayout(
                "", // Layout Constraints
                "[75]5[500]", // Column constraints
                "[]")); // Row constraints

        buildPanel();
        
        UIManager.put("Label.font", new Font("Arial", Font.PLAIN, 30));
        UIManager.put("TextField.font", new Font("Arial", Font.PLAIN, 30));
        UIManager.put("ComboBox.font", new Font("Arial", Font.PLAIN, 30));
        
        
        
        SwingUtilities.updateComponentTreeUI(this);
        
        setVisible(true);
    }

    public void buildPanel() {
        this.Init();
        
        add(fName);
        add(fNameField, "w 4in, wrap");
        
        add(lName);
        add(lNameField, "w 4in, wrap");
        
        add(role);
        add(roleBox, "wrap");
        
        add(email);
        add(emailField, "w 2in, wrap");
        
        add(phone);
        add(phoneField, "w 2in, wrap");
        
        add(reason);
        add(reasonBox, "span 2, wrap");
        
        add(location);
        add(locationBox, "wrap");
        
        add(followUp);
        add(followCheck, "wrap");

        
    }
    
    
    
    public void Init(){
        //first
        fName = new JLabel("First Name: ");
        //fName.setFont(new Font("Serif", Font.PLAIN, 14));
        fNameField = new JTextField();

        //last
        lName = new JLabel("Last Name: ");
        lNameField = new JTextField();

        //role
        role = new JLabel("Role: ");
        String[] roles = {"Student", "Teacher", "Parent", "Administrator"};
        roleBox = new JComboBox(roles);

        //email
        email = new JLabel("Email: ");
        emailField = new JTextField();

        //phone
        phone = new JLabel("Phone: ");
        phoneField = new JTextField();

        //reason
        reason = new JLabel("Reason: ");
        String[] reasons = {"New, Prospective Student/Group", "Disclose and Document Disability (In-take)", "Placement Testing with Accommodation",
            "Schedule An Appointment with Disability Specialist", "Meet with a Disability Specialist", "Take Test with Accommodations", "Drop Off/Pick Up Notes",
            "Academic Advising (Course Selection, Add/Drop, Withdrawal)", "Fill Out Accommodation Forms", "Address Problems with Specific Accommodations",
            "Address Specific Course Assignment or Issue", "Alternative Format for Texts and Handouts",
            "Professional Consultation (Faculty, Staff, Administration, Department)", "Other"};
        reasonBox = new JComboBox(reasons);

        //location
        location = new JLabel("Location: ");
        String[] locations = {"Framingham", "Wellesley", "Ashland"};
        locationBox = new JComboBox(locations);

        //follow
        followUp = new JLabel("Follow Up: ");
        followCheck = new JCheckBox();
        
        
    }
    
    public String getTextFName(){
        return fNameField.getText();
    }
        
}

