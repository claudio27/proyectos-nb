/*
 * Pasar argumentos por la línea de comandos una forma es des este estilo
 * 
 */

package argumentoslineacomandos;

/**
 *
 * @author claudio
 */
public class Main {

    /**
     * @param args voy a probar poner un documento como un .txt y ver el arreglo
     */

    //no funciono la idea de pasarle el archivo sólo lee el comando que se
    //se le entrega, así que voy a usar flex y no jodo más por aquí.
    public static void main(String[] args) {



        for(int i = 0; i < args.length; i++){


        System.out.println("["+i+"] = "+ args[i]);

        }
    }

}
