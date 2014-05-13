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
public class Secantes extends JApplet {

    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    public void init() {
        resize(500, 500);
    }

    public void paint(Graphics g) {

        for (int i = 0; i < 200; i++) {

            int r = (int) (Math.random() * 255 + 1);
            int gr = (int) (Math.random() * 255 + 1);
            int b = (int) (Math.random() * 255 + 1);
            Color c = new Color(r, gr, b);

            g.setColor(c);
            g.drawOval(0, 0, 200, 200);

            double ang = Math.random() * (2 * Math.PI);
            double x1 = 200 * Math.cos(ang) + 200;
            double y1 = 200 * Math.sin(ang) + 200;

            double ang1 = Math.random() * (2 * Math.PI);
            double x2 = 200 * Math.cos(ang1) + 200;
            double y2 = 200 * Math.sin(ang1) + 200;

            g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
            for (int delay = 0; delay < 10000000; delay++);
           
        }

    }
}
