/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package muestra;

import java.awt.Graphics;
import javax.swing.JApplet;

/**
 *
 * @author claudio
 */
public class Test extends JApplet {

   
    
    @Override
    public void init() {
        // TODO start asynchronous download of heavy resources
        resize(500, 500);
       
       
        
    }
    @Override
    public void paint(Graphics g){
    
        
        Circulo[] c1 = new Circulo[50];

        
            g.clearRect(0, 0, 500, 500);
        for(int i = 0; i <c1.length ; i++){
        
        
            
            Circulo circulogen = new Circulo();
            c1[i] =  circulogen;
            c1[i].dibujar(g);
            
//            if(Circulo.numCirculos == 500){
//            
//            
//                stop();
//            }
            
        for(int h =0; h < 100000000; h++);
        }
    
        
    
    
    }
    
    

    // TODO overwrite start(), stop() and destroy() methods

}
