/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;

/**
 *
 * @author Ian
 */
public class KioskButton extends JButton{
    
   
    
    private Color buttonColor = new Color(26, 0, 255);
    
    public KioskButton(String label) {
    super(label);
    this.setBackground(buttonColor);
}
    
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        Dimension originalSize = super.getPreferredSize();
//        int gap = (int) (originalSize.height * 0.2);
//        int x = originalSize.width + gap;
//        int y = gap;
//        int diameter = originalSize.height - (gap * 2);
//
//    }
//    
//     @Override
//    public Dimension getPreferredSize() {
//        Dimension size = super.getPreferredSize();
//        size.width += size.height;
//        return size;
//    }
}
