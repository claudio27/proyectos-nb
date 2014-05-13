/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package canvas;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author claudio
 */
public class Canvas extends Applet implements MouseListener{

    graphicscanvas gc;
    Button boton1;


    @Override
    public void init(){

    gc = new graphicscanvas();
  gc.setSize(100, 100);
  add(gc);
  addMouseListener(this);


    }

    public void mouseClicked(MouseEvent e) {

      
    }

    public void mousePressed(MouseEvent e) {
          for(int i=0; i <200; i++){

            gc.setLocation(i, 0);
            

        }
         
       
    }

    public void mouseReleased(MouseEvent e) {
       
    }

    public void mouseEntered(MouseEvent e) {
       
    }

    public void mouseExited(MouseEvent e) {
       
    }





}

class graphicscanvas extends java.awt.Canvas{

    public graphicscanvas(){
    }
    @Override
public void paint(Graphics g){

g.drawOval(10, 50, 40, 40);
g.drawLine(10, 50, 50, 90);
g.drawLine(50, 50, 10, 90);


}

   


}
