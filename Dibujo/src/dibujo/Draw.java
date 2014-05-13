/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dibujo;


import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.applet.Applet;

/**
 *
 * @author claudio
 */
public class Draw extends Applet implements ActionListener,MouseListener, MouseMotionListener {
   
    Button bdraw, bline, boval, brect, brounded;
    Point dot[] = new Point[1000];
    Point start, end;
    int puntos = 0;
    
    boolean mouseup = false;
    boolean draw = false;
    boolean line = false;
    boolean oval = false;
    boolean rectangle = false;
    boolean rounded = false;
    
    @Override
    public void init(){
     
        bline = new Button("Rectas");
        boval = new Button("Ovalos");
        brect = new Button("Rectangulos");
        brounded = new Button("Rectangulos Redondeados");
        bdraw = new Button("Dibujo Libre");
        
        add(bline);
        add(boval);
        add(brect);
        add(brounded);
        add(bdraw);
        
        
        bline.addActionListener(this);
        boval.addActionListener(this);
        brect.addActionListener(this);
        brounded.addActionListener(this);
        bdraw.addActionListener(this);
        
        addMouseListener(this);
        addMouseMotionListener(this);
        
        
    
    
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bdraw)
            draw=true;
        if(e.getSource()==bline)
            line=true;
        if(e.getSource()==boval)
            oval = true;
        if(e.getSource()==brounded)
            rounded=true;
    }

    public void mouseClicked(MouseEvent e) {
       
    }

    public void mousePressed(MouseEvent e) {
        
        mouseup = false;
        start = new Point(e.getX(), e.getY());
    }

    public void mouseReleased(MouseEvent e) {
        
        if(line){
        end = new Point(e.getX(), e.getY());
        
        }else{
        end = new Point(Math.max(e.getX(), start.x), Math.max(e.getY(), start.y));

        start = new Point(Math.min(e.getX(),start.x),
                Math.min(e.getY(), start.y));
        }
        mouseup = true;
        repaint();
      
    }

    public void mouseEntered(MouseEvent e) {
        
    }

    public void mouseExited(MouseEvent e) {
       
    }

    public void mouseDragged(MouseEvent e) {
        
        if(draw){
        dot[puntos] = new Point(e.getX(), e.getY());
        puntos++;
        repaint();
        }
    }

    public void mouseMoved(MouseEvent e) {
       
    }
    
    public void paint(Graphics g){
    
    
        if (mouseup) {
            int ancho = end.x - start.x;
            int alto = end.y - start.y;
            
            if (line) {
                g.drawLine(start.x, start.y, end.x, end.y);

            }else if(oval){
                
                g.drawOval(start.x, start.y, ancho, alto);
            
           
            }else if(rectangle){
                
                g.drawRect(start.x, start.y, ancho, alto);
            
            
            
            }else if(rounded){
                g.drawRoundRect(start.x, start.y, ancho, alto, 10, 10);
            
            
            
            }
            else if(draw){
                for(int i =0 ; i < puntos -1; i++){
                g.drawLine(dot[i].x, dot[i].y,dot[i+1].x, dot[i+1].y);
                
                }
            }

            

        }

    
    
    
    
    }
    

}
