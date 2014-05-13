/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fractales;

import java.applet.*;
import java.awt.*;
import java.net.URL;





/**
 *
 * @author claudio
 */
public class Imagen extends Applet {


 Image a ;

    public void init() {
        resize(350, 452);
        URL url = getCodeBase();
        System.out.println(" --- "+ url);
        a = getImage(getCodeBase(),"img/4.gif");

       

    }

    public void paint(Graphics g){

    

        for (int i = 0; i < 200; i++) {
            g.drawImage(a, 0, 0, 130 + i, 130 + i, this);
        }


    }

}
