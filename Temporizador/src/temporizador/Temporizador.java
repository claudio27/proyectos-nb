/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package temporizador;

//import javax.swing.JOptionPane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author claudio
 */
public class Temporizador {

   

    public static void main(String args[])  {
        
        
//        String tiempo = JOptionPane.showInputDialog("Cuenta Regresiva");
//        int t = Integer.parseInt(tiempo);
//        
//        Thread.sleep(t * 1000);
//        
//        System.out.println("se acabo " + t + " milisegundos");
//        
//        JOptionPane.showMessageDialog(null, "Se acabo el tiempo");
        
        int a = 0;
//        
        System.out.println("entre");
        try {
             a = System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(a);
                
    }

}
