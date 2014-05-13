/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imagenes2;

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

/**
 *<APPLET
 * codebase="classes"
 * code="imagenes/Resizer.class"
 * width=600 height=600>
 *
 * </APPLET>
 *
 */
public class Imagen extends Applet implements MouseListener {

    Image image;
    boolean mouseUp = false;
    Point start, end;

    @Override
    public void init() {


        image = getImage(getCodeBase(), "img/gatito.png");
        //URL s = getCodeBase();
        //System.out.println("ruta: "+s);

      
        resize(500, 500);

        setBackground(Color.black);
        addMouseListener(this);
    }

    public void mousePressed(MouseEvent e) {

        mouseUp = false;
        start = new Point(e.getX(), e.getY());

    }

    public void mouseReleased(MouseEvent e) {

        mouseUp = true;
        end = new Point(Math.max(e.getX(), start.x), Math.max(e.getY(), start.y));
        start = new Point(Math.min(e.getX(), start.x), Math.min(e.getY(), start.y));
        repaint();

    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("coordenadas" + e.getX() + "," + e.getY());
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void paint(Graphics g) {


        if (mouseUp) {

            int ancho = end.x - start.x;
            int alto = end.y - start.y;
            g.drawImage(image, start.x, start.y, ancho, alto, this);

        } else {

            g.drawImage(image, 0, 0, image.getHeight(this), image.getWidth(this), this);

            g.setColor(Color.red);
            g.drawString("ARRASTRA Y SUELTA CON EL RATON", 100, 50);

        }
    }
}
