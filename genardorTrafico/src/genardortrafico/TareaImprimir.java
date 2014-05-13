package genardortrafico;
import java.util.Random;

/**
 *
 * @author claudio
 */
public class TareaImprimir implements Runnable {

    // tiempo inactividad aleatorio para el subproceso
    private final int tiempoInactividad;
    private final String nombreTarea; // nombre de la tarea
    private final static Random generador = new Random();

    public TareaImprimir(String nombre)
    {

        nombreTarea = nombre; // establece el nombre de la tarea

        // elige un tiempo de inactividad aleatorio entre 0 y 5 segundos
        tiempoInactividad = generador.nextInt( 5000 ); // milisegundos

    } // fin constructor de TareaImprimir

    // el metodo run contiene el codigo que ejecutura un subproceso
    public void run()
    {
        // deja el subproceso inactivo durante tiempoInactividad segundos
    try
    {
     System.out.printf("%s va a estar inactivo durante %d milisegundos\n", nombreTarea, tiempoInactividad);

     Thread.sleep(tiempoInactividad); // deja el subproceso inactivo

    }// fin try
    catch(InterruptedException exception)
    {

           System.out.printf("%s %s \n", nombreTarea,
                   "termino en forma prematura, debido a la interrupcion");

    }// fin del catch

    //imprime el nombre de la tarea
    System.out.printf("%s termino su inactividad \n", nombreTarea);
    }// fin run
}
