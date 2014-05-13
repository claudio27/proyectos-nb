package mergesort;

import java.io.*;

/**
 *
 * @author claudio serrano
 */
public class Main {

   
    public static void main(String[] args) {

            int dato = 0;
            Mergesort ms = new Mergesort();
            //el arreglo que vamos a usar
            
            
        System.out.println("****    Mergesort   ****");
        System.out.println("Ingrese un numero para el rango 0 hasta ...");

        try{

        BufferedReader q =  new BufferedReader(new InputStreamReader(System.in));
        dato =Integer.parseInt(q.readLine());  //lee un numero del teclado


        }
        catch(java.io.IOException ioex) {
  System.out.println("se presento el error: "+ioex.toString());
    }


        for(int i = 500 ; i <= 50000; i += 500){

            int []arr = new int[i];
            ms.llenar(arr, dato);
            System.out.println(arr[i]);



        }

        
    }

}
