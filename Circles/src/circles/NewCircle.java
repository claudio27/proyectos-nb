/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package circles;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author claudio
 */
public class NewCircle {

    int x, y, r;
    public static int numCirculos = 0;
    final double PI = Math.PI;
    Color color;
    String mensaje;
    //para hacer un color aleatorio
    int red = (int) (Math.random() * 255 + 1);
    int green = (int) (Math.random() * 255 + 1);
    int blue = (int) (Math.random() * 255 + 1);
   

    public NewCircle() {
        //posicion aleatoria, y  radio 10
        this.x = (int) (Math.random() * 500 + 1);
        this.y = (int) (Math.random() * 500 + 1);
        this.r = 10;
        this.color = new Color(red, green, blue);
        this.mensaje = "(" + x + "," + y + ")";
        numCirculos++;
    }

    public void dibujar(Graphics g) {


        g.setColor(color);
        g.drawOval(x, y, 2 * r, 2 * r);
        double ang = Math.random() * PI;
        double px = r * Math.cos(ang) + r;
        double py = r * Math.sin(ang) + r;

        g.drawString(mensaje, (int) px + x, (int) py + y);


    }
}
