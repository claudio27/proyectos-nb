package danitarea;
/** uso de paquete java.io(input output), se refiere a la entrada y salida
estandar, teclado y pantalla.*/
import java.io.*;

public class Caja {

  /** métodos para insertar, buscar, borrar elementos de un arreglo*/

    public void insertar(int []a, int b){

        /**tamaño del arreglo*/
        int tam = a.length;

    //primero ver si ya está el elemento en el arreglo
        for(int i=0; i < a.length; i++){

                if(a[i] == b ){

                    System.out.println("El elemto ya existe");
                }
                else{  //inserta al final del arreglo

                    a[tam - 1] = b;
                }

        }
    }

    //busca el elemento b, en el arreglo a[], sólo dice si está o no
    public void buscar(int []a, int b){


         //busca por el arreglo lineal
        for(int i=0; i < a.length; i++){

                if(a[i] == b ){

                    System.out.println("El elemento ya existe");
                   
                }
                else{

                    System.out.println("El elemento no existe");

                    }

        }

    }

    //borra el elemento b del arreglo a[], pone en su lugar un 0 'cero'
    public void borrar(int []a, int b){

        for(int i= 0; i < a.length; i++){

            // si pilla el elemento lo pone a cero, borra
           if(a[i] == b){

               a[i] = 0;

           }

        }
    }


    public void mostrar(int a[]){


     System.out.print("[");
    for(int idx = 0; idx < a.length ; idx++){
   
    System.out.print(a[idx]+",");
    
        }
    System.out.print("]\n");

    }

    public int[] llenar(int []a){

        for(int j= 0; j < a.length; j++){

            a[j] = (int) (Math.random()*10);

        }

        return a;

    }

    public int ingresoDatos(){

    int dato = 0;

    try{

        BufferedReader q =  new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese un número");
        dato =Integer.parseInt(q.readLine());  //lee un numero del teclado


        }
        catch(java.io.IOException ioex) {
  System.out.println("se presento el error: "+ioex.toString());
    }



    return dato;
    }

    public String lecturaComandos(){



String dato = "";

    try{

        BufferedReader q =  new BufferedReader(new InputStreamReader(System.in));
        dato =(q.readLine());  //lee un numero del teclado


        }
        catch(java.io.IOException ioex) {
  System.out.println("se presento el error: "+ioex.toString());
    }



    return dato;
    }

}
