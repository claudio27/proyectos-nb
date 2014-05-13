/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genardortrafico;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 *
 * @author claudio
 */
public class Main {

    public static void main(String[] args) throws MalformedURLException, IOException {

      try{
        String direccion = args[0];
        int nHebras = Integer.parseInt(args[1]);

        // Crea cada subproceso con un nuevo objeto Runnable
//        Thread subproceso1 = new Thread(new TareaImprimir("tarea1"));
//        Thread subproceso2 = new Thread(new TareaImprimir("tarea2"));
//        Thread subproceso3 = new Thread(new TareaImprimir("tarea3"));


        // inicia los subprocesos y los coloca en el estado "en ejecucion"

//        subproceso1.start(); // invoca al metodo run de tarea1
//        subproceso2.start();
//        subproceso3.start();

        System.out.println("Tareas iniciadas, main termina\n");

        Thread[] hebras = new Thread[nHebras];

        for (int i = 0; i < hebras.length; i++) {
            //hebras[i] = new Thread(new TareaImprimir("proc" + i));
            hebras[i] = new Thread(new Conector(direccion));
            hebras[i].start();


        }


        }
      catch(ArrayIndexOutOfBoundsException arre){

          System.out.println("Ingrese url numeroHebras\n"
                  + "Ej: java -jar generadoTrafico www.algo.com 10\n"+arre);
      }
    }
}
