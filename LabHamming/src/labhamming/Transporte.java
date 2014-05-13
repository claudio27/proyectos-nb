package labhamming;
import java.util.Random;

public class Transporte{

    public static String Transporte(String in) {
        String out = new String();
        //Probabilidad de modificar cada caracter
        double p = 0.1;
        // semilla para numeros aleatorios
        Random r = new Random();
        boolean change;
        //cambiar a 11 para que funcion con el hamming, con 7 es para bin ascii
        if (in.length() != 11)
            return "-1";
        for (int i=0; i < in.length(); i++) {
            change = (p < r.nextDouble());
            if(in.substring(i,i+1).equals("0"))
                if (change)
                    out = out+"0";
                else
                    out = out+"1";
            else if(in.substring(i,i+1).equals("1"))
                if (change)
                    out = out+"1";
                else
                    out = out+"0";
            else
                return "-2";
        }
        return out;
    }

//    public static void main(String[] args) {
//
//        String input = new String("1101001");
//
//        System.out.println("Antes:   \t" + input );
//        System.out.println("Despues: \t" + Transporte(input) );
//
//    }
}