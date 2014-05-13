package arboles;
import java.io.*;
import java.util.regex.*;

/**
 *
 * @author claudio
 */
public class Lectura {



   
    //@todo arreglar este metodo para que escriba sin sobreescrir
public String leer(String file){
   try{                             // ISO-8859-1
 DataInputStream entrada5 =new DataInputStream (new BufferedInputStream(new FileInputStream(file)));
 BufferedReader entrada5br = new BufferedReader(new InputStreamReader(entrada5, "ISO-8859-1"));
// String s =entrada5br.readLine();
 String s = null;
 int cont = 0;
 String sinSpecial="";
 while((s = entrada5br.readLine()) != null){

 //System.out.println(s);
 
         
        sinSpecial += elimSpecial(s);
       // Lectura.escribir(sinSpecial);

 cont++;
 
       }
 return sinSpecial;
 
 //System.out.println("lineas " + cont);

        }catch(IOException e) {
System.err.println("Fin del flujo"+e);
        return "no leyo";
        }

    }

public static void escribir(String s){
    try {
 FileWriter fw = new FileWriter("salida.txt");
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter salida = new PrintWriter(bw);
    salida.println(s);
    salida.close();

    
        }catch(IOException e){
        System.err.println("Fin del flujo escribir"+e);

        }


    }
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
        Pattern p26 = Pattern.compile(Pattern.quote("-"));
        //eliminar espacios en blanco 3 4 5 6
        Pattern p27 = Pattern.compile(Pattern.quote("   "));
        Pattern p28 = Pattern.compile(Pattern.quote("    "));
        Pattern p29 = Pattern.compile(Pattern.quote("     "));
        Pattern p30 = Pattern.compile(Pattern.quote("      "));


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

        Matcher a26 = p26.matcher(resul);
        resul = a26.replaceAll("");

                Matcher a27 = p27.matcher(resul);
        resul = a27.replaceAll("");

                Matcher a28 = p28.matcher(resul);
        resul = a28.replaceAll("");

                Matcher a29 = p29.matcher(resul);
        resul = a29.replaceAll("");

                Matcher a30 = p30.matcher(resul);
        resul = a30.replaceAll("");
        return resul;
    }

public String[] entregaPalabras(String s){

    String palabra[] =  s.split(" ");
    return palabra;

}

}
