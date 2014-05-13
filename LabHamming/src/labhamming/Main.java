package labhamming;
import java.io.*;
/**
 *
 * @author claudio
 */
public class Main {

    /**
     * @return data arreglo con los caracteres separados por indice en ASCII

     */
      public int[] ingresoDatos(){

    String dato = "";

    try{

        BufferedReader q =  new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese palabra :");
        dato =q.readLine();


        }
        catch(java.io.IOException ioex) {
  System.out.println("se presento el error: "+ioex.toString());
        }

        char[] caracteres = dato.toCharArray();

        int[] c = new int[caracteres.length];
        System.out.println("Convirtiendo a ASCII \n Entrada \t Salida");
        


          for (int i = 0; i < caracteres.length; i++) {
              
              // aqui se pasan a ASCII
              c[i] = (int)caracteres[i];
System.out.println(caracteres[i] + "\t" + c[i]);

          }
                  

          System.out.println("\n------------------OK");


        return c;
    }

/**
 * @param a arreglo con los numeros en ASCII
 * @return bin arreglo con los numeros binaros
 */
      public String[] pasarBin(int[] a){
          
          String[] bin = new String[a.length];
          
          System.out.println("Pasando ASCII a Binario\n Entrada \t Salida\n");

          for (int i = 0; i < bin.length; i++) {
              
              bin[i] = Integer.toBinaryString(a[i]);
System.out.println(a[i]+"\t"+bin[i]);
              
              
          }
          System.out.println("OK");
          
          return bin;
      
      
      
      }



    public static void main(String[] args) {



        Main obj = new Main();
        Hamming h = new Hamming();
       
        // los datos en ascii
        int ascii[] = obj.ingresoDatos();
        String[] bin = obj.pasarBin(ascii);


//pasando bin a hamming
        String nuevobinh[] = h.transformarCadena(bin);

System.out.println("Usando Transporte()...\nEntrada\tSalida\n");
// String de salida para transporte
String []tout = new String[nuevobinh.length];

        for (int k = 0; k < nuevobinh.length; k++) {
            // hace el cambio del bin hamming a transporte,
            // lo guarda tout[k]
            tout[k] = Transporte.Transporte(nuevobinh[k]);
            System.out.println(nuevobinh[k]+"\t"+tout[k]);
            

        }


//TODO encontrar el error despues que paso por el hamming y arreglar el bit mostrarlo

//comprobacion de los bits de paridad

//TODO pasar del hamming corregido a binario, quitar bits de paridad
//TODO de binario pasar a ascii mostrar el mensaje corregido













    }

}
