package lecturas;
import java.io.*;
import java.util.regex.*;

/**
 *
 * @author claudio
 */
public class Main {

    
    public static void main(String[] args) {


        //String a = "hola claduio lalala   lalaa";
        //String n=a.replaceAll(" ", "\n");
        //String []b = a.split(" ");
        Main a = new Main();
        System.out.println(a.cuentaLineas("file.txt"));
        System.out.println(a.elimSpecial(a.lee("file.txt")));
        
        String r = a.buscarEnIndice("file.txt", "puta");
        System.out.println(r+"----");
        String chorizo = a.leeDirectorio();
        String chorixo[] = a.palabras(chorizo);
        System.out.println(chorixo.length);
        String conSaltos =a.chorizoSaltoLinea(a.leeDirectorio()) ;
        System.out.println(conSaltos);
        a.escribir("indices/indice-rep.txt",conSaltos);
//        Main.listaFicheros();
        
        
    }

    public void sacarRepetidas(){

//TODO crear arreglo con todas las palabras, traspasar a un nuevo arreglo
        // cada palabra una sola vez.






    }

    public void crearIndice(){



    }

    public String arregloToString(String []a){


        String s="";

        for(int i = 0; i < a.length; i++){

            s += a[i] + " ";

        }



        return s;


    }

    public String chorizoSaltoLinea(String chori){

        String salida="";


        salida = chori.replaceAll(" ", "\n");



        return salida;
    }

    public String buscarEnIndice(String file, String palabra){
    
        String resultado ="";
        //leer todas las lineas y compararlas con palabra
        //si la encuetra retornar el string
         

        try{
 DataInputStream fileIn =new DataInputStream (new BufferedInputStream(new FileInputStream(file)));
 BufferedReader fileBuff = new BufferedReader(new InputStreamReader(fileIn));

 String s = "";

 while((s = fileBuff.readLine()) != null){

     if(s.contains(palabra)){

         resultado = s;

     }
     }
       }catch(IOException e) {
System.err.println("Fin del flujo-indice. "+e);
        }
    
    
        return resultado;
    }

    public String[] listaFicheros(){

        File fichero = new File(".");

        String []listaArchivos = fichero.list(new Filtro(".txt"));
        System.out.println("Archivos.---");
        for(int i= 0; i < listaArchivos.length ; i++){
        System.out.println(listaArchivos[i]);
        
        }
        return listaArchivos;
    }

    public void escribir(String file, String chorizo){

        try {
 FileWriter fw = new FileWriter(file);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter salida = new PrintWriter(bw);
    
  salida.println(chorizo);
    
    salida.close();


        }catch(IOException e){
        System.err.println("Fin del flujo escribir"+e);

        }




    }

    //guarda palabras en arreglo
    public String[] palabras(String s){

        String palabras[] = s.split(" ");


        return palabras;



    }

    //elimina caracteres especiales y pasa a minuscula
    public String elimSpecial(String s){

        String str = s.toLowerCase();

        Pattern p1 = Pattern.compile(Pattern.quote("¡"));
        Pattern p2 = Pattern.compile(Pattern.quote("!"));
        Pattern p3 = Pattern.compile(Pattern.quote("¿"));
        Pattern p4 = Pattern.compile(Pattern.quote("?"));
        Pattern p5 = Pattern.compile(Pattern.quote("<"));
        Pattern p6 = Pattern.compile(Pattern.quote(">"));
        Pattern p7 = Pattern.compile(Pattern.quote("["));
        Pattern p8 = Pattern.compile(Pattern.quote("]"));
        Pattern p9 = Pattern.compile(Pattern.quote("{"));
        Pattern p10 = Pattern.compile(Pattern.quote("}"));
        Pattern p11 = Pattern.compile(Pattern.quote("("));
        Pattern p12 = Pattern.compile(Pattern.quote(")"));
        Pattern p13 = Pattern.compile(Pattern.quote("$"));
        Pattern p14 = Pattern.compile(Pattern.quote("%"));
        Pattern p15 = Pattern.compile(Pattern.quote("á"));
        Pattern p16 = Pattern.compile(Pattern.quote("é"));
        Pattern p17 = Pattern.compile(Pattern.quote("í"));
        Pattern p18 = Pattern.compile(Pattern.quote("ó"));
        Pattern p19 = Pattern.compile(Pattern.quote("ú"));
        Pattern p20 = Pattern.compile(Pattern.quote("\""));
        Pattern p21 = Pattern.compile(Pattern.quote("#"));
        Pattern p22 = Pattern.compile(Pattern.quote("."));
        Pattern p23 = Pattern.compile(Pattern.quote(","));
        Pattern p24 = Pattern.compile(Pattern.quote("/"));
        Pattern p25 = Pattern.compile(Pattern.quote("&"));

        Matcher a = p1.matcher(str);
        //reemplazar con
        String resul = a.replaceAll("");

        Matcher a2 = p2.matcher(resul);
        resul = a2.replaceAll("");

        Matcher a3 = p3.matcher(resul);
        resul = a3.replaceAll("");

        Matcher a4 = p4.matcher(resul);
        resul = a4.replaceAll("");

        Matcher a5 = p5.matcher(resul);
        resul = a5.replaceAll("");

        Matcher a6 = p6.matcher(resul);
        resul = a6.replaceAll("");

        Matcher a7 = p7.matcher(resul);
        resul = a7.replaceAll("");

        Matcher a8 = p8.matcher(resul);
        resul = a8.replaceAll("");

        Matcher a9 = p9.matcher(resul);
        resul = a9.replaceAll("");

        Matcher a10 = p10.matcher(resul);
        resul = a10.replaceAll("");

        Matcher a11 = p11.matcher(resul);
        resul = a11.replaceAll("");

        Matcher a12 = p12.matcher(resul);
        resul = a12.replaceAll("");

        Matcher a13 = p13.matcher(resul);
        resul = a13.replaceAll("");

        Matcher a14 = p14.matcher(resul);
        resul = a14.replaceAll("");

        Matcher a15 = p15.matcher(resul);
        resul = a15.replaceAll("a");

        Matcher a16 = p16.matcher(resul);
        resul = a16.replaceAll("e");

        Matcher a17 = p17.matcher(resul);
        resul = a17.replaceAll("i");

        Matcher a18 = p18.matcher(resul);
        resul = a18.replaceAll("o");

        Matcher a19 = p19.matcher(resul);
        resul = a19.replaceAll("u");

        Matcher a20 = p20.matcher(resul);
        resul = a20.replaceAll("");

        Matcher a21 = p21.matcher(resul);
        resul = a21.replaceAll("");

        Matcher a22 = p22.matcher(resul);
        resul = a22.replaceAll("");

        Matcher a23 = p23.matcher(resul);
        resul = a23.replaceAll("");

        Matcher a24 = p24.matcher(resul);
        resul = a24.replaceAll("");

        Matcher a25 = p25.matcher(resul);
        resul = a25.replaceAll("");

        return resul;
    }

    //entrega todas las lineas concatenadas de un archivo
    public String lee(String file){

        String lineas="";

        try{
 DataInputStream fileIn =new DataInputStream (new BufferedInputStream(new FileInputStream(file)));
 BufferedReader fileBuff = new BufferedReader(new InputStreamReader(fileIn));

 String s = "";

 while((s = fileBuff.readLine()) != null){
 System.out.println(s);
 lineas += s;

   }
       }catch(IOException e) {
System.err.println("Fin del flujo"+e);
        }

        return lineas;

    }
    //cuenta lineas del archivo file
    public int cuentaLineas(String file){

    int cont=0;

    try{
 DataInputStream fileIn =new DataInputStream (new BufferedInputStream(new FileInputStream(file)));
 BufferedReader fileBuff = new BufferedReader(new InputStreamReader(fileIn));

 String s = null;

 while((s = fileBuff.readLine()) != null){
// System.out.println(s);
cont++;
   }
       }catch(IOException e) {
System.err.println("Fin del flujo"+e);
        }

    return cont;
    }
    //lee todos los archivos y concatena sus salidas
    public String leeDirectorio(){

    String total="";//para almacenar todo
    int cantArchivos = 0;
    String []ficheros;
    Main obj = new Main();
    ficheros = obj.listaFicheros();
    cantArchivos = ficheros.length;

    //veces que debe---leer y guardar
    for(int i=0; i< cantArchivos; i++){

        total += obj.lee(ficheros[i]);


    }

    total = obj.elimSpecial(total);
    System.out.println(total);
    //TODO hacer el split con palabras---escribir cada elemento en indice-rep
    return total;






    }

}
