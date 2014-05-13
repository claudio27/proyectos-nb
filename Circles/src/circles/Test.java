package circles;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JApplet;

/**
 *
 * @author claudio
 */
public class Test extends JApplet implements MouseListener {

    boolean mouseUp = false;
    Point start, end;
//@todo hacer objeto global newcirle, y entregarle las coordenadas del mouse
//@todo dibujarlo con las nuevas coordenadas en el metodo paint
    @Override
    public void init() {
       
        resize(500, 500);



    }

    @Override
    public void paint(Graphics g) {


        Circulo[] c1 = new Circulo[50];


        g.clearRect(0, 0, 500, 500);
        for (int i = 0; i < c1.length; i++) {



            Circulo circulogen = new Circulo();
            c1[i] = circulogen;
            c1[i].dibujar(g);


                //retardo para el dibujo de los circulos
            for (int h = 0; h < 100000000; h++);
        }




    }

    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
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

    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
