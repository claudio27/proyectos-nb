/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fractales;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JApplet;

/**
 *
 * @author claudio
 */
public class CirculoMov extends JApplet {

    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    public void init() {
        resize(800, 800);
    }

    public void paint(Graphics g) {

        for (double ang1 = Math.PI; ang1 > 0; ang1 -= 0.01) {
            
            g.clearRect(0, 0, 700, 500);
           
            double x = 100 * Math.cos(ang1) + 200;
            double y = 100 * Math.sin(ang1) + 200;
            
            g.fillOval((int) x, (int) y, 10, 10);
            for (int h = 0; h < 40000000; h++);






        }



    }
}
