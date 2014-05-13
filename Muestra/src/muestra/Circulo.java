/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muestra;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author claudio
 */
public class Circulo {

    int x, y, r;
    public static int numCirculos = 0;
    final double PI = Math.PI;
    Color color;
    String mensaje;
    int red = (int) (Math.random() * 255 + 1);
    int green = (int) (Math.random() * 255 + 1);
    int blue = (int) (Math.random() * 255 + 1);

    public Circulo() {
        //posicion aleatoria, y  radio 10
        this.x = (int) (Math.random() * 200 + 1);
        this.y = (int) (Math.random() * 200 + 1);
        this.r = 10;
        this.color = new Color(red, green, blue);
        this.mensaje = "" + numCirculos;
        numCirculos++;
    }

    public void dibujar(Graphics g) {

        //g.clearRect(0, 0, 500, 500);
        g.setColor(color);
        g.drawOval(x, y, 2 * r, 2 * r);
        double ang = Math.random() * PI;
        double px = r * Math.cos(ang) + r;
        double py = r * Math.sin(ang) + r;

        g.drawString(mensaje, (int) px + x, (int) py + y);


    }
}
