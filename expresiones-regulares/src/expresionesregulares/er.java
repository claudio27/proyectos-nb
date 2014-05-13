package expresionesregulares;
import java.util.regex.*;
/**
 *
 * @author Claudio Serrano
 */
public class er {

   
    public static void main(String[] args) {

        //compilamos el patron
        Pattern patron = Pattern.compile("a*b");
        //creamos el matcher a partir del patron, la cadena como parametro
        Matcher encaja = patron.matcher("aabmanoloaabmanoloabmanolob");
        //invocamos al metodo replaceAll
        String resultado = encaja.replaceAll("-");
        System.out.println(resultado);

        System.out.println("-------------");
        
      

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
        //linea a modificar
        Matcher a = p20.matcher("hola commo ests \" ");
        //reemplazar con
        String resul = a.replaceAll("ddd");
        System.out.println(resul);
        String str ="HoLA".toLowerCase();
        System.out.println(str);


    }

}
