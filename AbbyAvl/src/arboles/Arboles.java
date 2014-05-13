package arboles;

import java.io.*;

/**
 *
 * @author claudio
 *
 */

public class Arboles {



    public static void main(String[] args) {

        //declaracion de buffers para guardar los archivos
        BufferedReader bf2 = null;
        BufferedReader bf3 = null;
        FileWriter fichero = null;
        PrintWriter pw = null;

        try {
            
            FileInputStream fis = new FileInputStream("psicologia_revolucionaria.txt");//CAMBIAR RUTA DEL ARCHIVO
            InputStreamReader is = new InputStreamReader(fis, "ISO-8859-1");
            BufferedReader bf = new BufferedReader(is);

            fichero = new FileWriter("sinespeciales.txt");
            pw = new PrintWriter(fichero);

            //declaracion de arboles abb y avl
            Arbolbinario binario = new Arbolbinario();
            AVLTree avl = new AVLTree();
            String linea;
            String palabras[];
            



            while ((linea = bf.readLine()) != null) {


                palabras = linea.trim().split("\\s+");

                for (int i = 0; i < palabras.length; i++) {


                    String palabra_co = palabras[i];
                    pw.print(eliminarSpecials(palabra_co));
                    pw.print(" ");

                }
           pw.println();

            }

            bf.close();
            fichero.close();
               //archivo nuevo sin caracteres especiales
           FileInputStream fis2 = new FileInputStream("sinespeciales.txt");
           FileInputStream fis3 = new FileInputStream("sinespeciales.txt");
           InputStreamReader is2 = new InputStreamReader(fis2, "UTF8");
           InputStreamReader is3 = new InputStreamReader(fis3, "UTF8");
           bf2 = new BufferedReader(is2);
           bf3 = new BufferedReader(is3);

           System.out.println("Insertando palabras en abb y avl");

           boolean comprobar = false;
           double tiempototalabb ;
           double tiempototalavl ;


            /*Empieza a contar tiempo en ingresar palabras en el abb*/
            long tiempoinicial = System.currentTimeMillis();

            while ((linea = bf2.readLine()) != null) {

                palabras = linea.trim().split("\\s+");


                for (int i = 0; i < palabras.length; i++) {

                     if((palabras[i].isEmpty()) == comprobar){
                        // insera la palabra en en el abb
                         binario.insert(palabras[i]);

                     }
                 }

             }
            // termina de contar y hace el calculo de CUANTO DEMORO
             long tiempofinal = System.currentTimeMillis();
             tiempototalabb = (((double)(tiempofinal - tiempoinicial))/1000) ;

             /*EMPEZAMOS A CONTAR PALABRAS EN EL AVL*/
              long tiempoinicial2 = System.currentTimeMillis();
             while ((linea = bf3.readLine()) != null) {

              palabras = linea.trim().split("\\s+");

                 for (int i = 0; i < palabras.length; i++) {

                     if((palabras[i].isEmpty()) == comprobar){

                         avl.insert(palabras[i]);

                     }

                 }

              }

              long tiempofinal2 = System.currentTimeMillis();
              tiempototalavl = (((double)(tiempofinal2 - tiempoinicial2))/1000) ;
            bf3.close();
            bf2.close();// CERRAMOS LOS ARCHIVOS PARA QUE NO QUEDE ABIERTO STREAM

           int alturabinario = binario.calcularAltura();
           int alturaavl = avl.calcularAltura();
           //SACAR PALABRAS Y CUANTO APARECEN
           String canbinario[] = binario.cantidadpalabras();

           //ordena el abb en arreglo

           //sin nulos calcula el largo
           int i;
           for(i = 0; i<canbinario.length; i++){

               if(canbinario[i] ==null){
                   break;

               }
           }
           String canbinario2[] = new String [i] ;

           for(i = 0; i<canbinario.length; i++){

               if(canbinario[i] !=null){
                   canbinario2[i] = canbinario[i];

               }
           }

           String binordenado [] = Quicksort(canbinario2,0,canbinario2.length-1);


           String cantavl[] = avl.cantidadpalabras();
           //ordenar arreglo AVL

           for(i = 0; i<cantavl.length; i++){

               if(cantavl[i] ==null){
                   break;

               }
           }
           String cantavl2[] = new String [i] ;

           for(i = 0; i<cantavl.length; i++){

               if(cantavl[i] != null){
                   cantavl2[i] = cantavl[i];

               }
               else{
                   break;
               }

           }
           String avlorden [] = Quicksort(cantavl2,0,cantavl2.length-1);


            //Imprimir los arboles
            System.out.println("\t\timprimiendo arbol abb");
            binario.printTree();
            System.out.println("--- aqui termina abb");
            System.out.println("\n\n\n");
            System.out.println("\t\timprimiendo arbol avl");
            avl.printTree();
            System.out.println("---aqui termina avl\n\n\n");
            //Tiempo de inserción de los arboles
            System.out.println("tiempo insercion abb: "+tiempototalabb +"seg");
            System.out.println("tiempo insercion avl: "+tiempototalavl +"seg\n");

            //Pasar los arboles a arreglo para poder saber cual palabra tiene mayor largo

            /*Enumerar las palabras mas repetidas*/

            System.out.println("Las 10 palabras mas repetidas son:\n");

            int cont = 0;
            int c = binordenado.length -1;
            double tbinario = 0 ;
            double tavl = 0 ;

            while( c > 0){

                System.out.println((cont + 1)+"  " + binordenado[c]);

                if(cont == 10){

                    break;
                }
                c--;
                cont ++;
            }

            /*Borrar palabras en ABB*/

             cont = 0;
             c = binordenado.length -1;
             long tiempoinicial3 = System.nanoTime();
              while( c > 0){
             String palabra[] = binordenado[c].trim().split("\\s+");
             binario.borrar(palabra[1]);

                if(cont == 49){

                    break;
                }
                c--;
                cont ++;
            }
             long tiempofinal3 = System.nanoTime();
             tbinario = (((double)(tiempofinal3 - tiempoinicial3))) ;

             /* Borrar palabras en AVL*/
             cont = 0;
             c = avlorden.length -1;
           long tiempoinicial4 = System.nanoTime();
              while( c > 0){
             String palabra[] = avlorden[c].trim().split("\\s+");
             avl.remove(palabra[1]);

                if(cont == 49){

                    break;
                }
                c--;
                cont ++;
            }

           long tiempofinal4 = System.nanoTime();
           tavl = (((double)(tiempofinal4 - tiempoinicial4))) ;


            System.out.println("\n\n");
            System.out.println("tiempo eliminar 50 mas repetidas\n");

            System.out.println("tiempo para borrar abb:"+tbinario+ " ns");
            System.out.println("tiempo para borrar avl:"+tavl+ "ns");
            System.out.println("\n\n");



        }

  catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != bf2) {
                    bf2.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }

    }
    
    public static String eliminarSpecials(String palabra){
     
        String minuscula = palabra.toLowerCase();
       
        String tildes = minuscula;
        tildes = tildes.replace('á', 'a');
        tildes = tildes.replace('é', 'e');
        tildes = tildes.replace('í', 'i');
        tildes = tildes.replace('ó', 'o');
        tildes = tildes.replace('ú', 'u');
        
        
        String signos = tildes;
        
        signos = signos.replace('\\', ' ');
        signos = signos.replace('/', ' ');
        signos = signos.replace('?', ' ');
        signos = signos.replace('¿', ' ');
        signos = signos.replace('¡', ' ');
        signos = signos.replace('*', ' ');
        signos = signos.replace('-', ' ');
        signos = signos.replace('+', ' ');
        signos = signos.replace('[', ' ');
        signos = signos.replace(']', ' ');
        signos = signos.replace('!', ' ');
        signos = signos.replace('#', ' ');
        signos = signos.replace('$', ' ');
        signos = signos.replace('%', ' ');
        signos = signos.replace(')', ' ');
        signos = signos.replace('(', ' ');
        signos = signos.replace('=', ' ');
        signos = signos.replace(',', ' ');
        signos = signos.replace('.', ' ');
        signos = signos.replace(';', ' ');
        signos = signos.replace(':', ' ');
        signos = signos.replace('"', ' ');
        signos = signos.replace('<', ' ');
        signos = signos.replace('>', ' ');
        signos = signos.replace('«', ' ');
        signos = signos.replace('»', ' ');
        signos = signos.replace('', ' ');
        signos = signos.replace('', ' ');         
        signos = signos.replace('', ' ');
        signos = signos.replace('ª', ' ');
        signos = signos.replace('º', ' ');

       
        signos = signos.replace('0', ' ');
        signos = signos.replace('1', ' ');
        signos = signos.replace('2', ' ');
        signos = signos.replace('3', ' ');
        signos = signos.replace('4', ' ');
        signos = signos.replace('5', ' ');
        signos = signos.replace('6', ' ');
        signos = signos.replace('7', ' ');
        signos = signos.replace('8', ' ');
        signos = signos.replace('9', ' ');
        
        
        String sinespacios = "";
        for (int x = 0; x < signos.length(); x++) {
            if (signos.charAt(x) != ' ') {
                sinespacios += signos.charAt(x);
            }
        }
     
        
            
    return sinespacios;
    
    }
    
   public static String[] Quicksort(String[] vector, int primero, int ultimo){
        int i= primero, j= ultimo;
        String pivote = vector[((primero + ultimo) / 2)];
        String pivote2[] = pivote.trim().split("\\s+");
        pivote = pivote2[0];
        int pivote3 = Integer.parseInt(pivote);
              
        String auxiliar;
 
        do{
                
                while( (Integer.parseInt(vector[i].trim().split("\\s+")[0])) < pivote3) i++;                  
                while( (Integer.parseInt(vector[j].trim().split("\\s+")[0])) > pivote3) j--;
 
                if (i<=j){
                        auxiliar = vector[j];
                        vector[j]= vector[i];
                        vector[i]= auxiliar;
                        i++;
                        j--;
                }
 
        } while (i<=j);
 
        if(primero<j) Quicksort(vector,primero, j);
        if(ultimo>i)  Quicksort(vector,i, ultimo);
   
        return vector; 
   }
    
    

}
