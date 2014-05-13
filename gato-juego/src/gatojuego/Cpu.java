package gatojuego;

/**
 *
 * @author Claudio Serrano
 */
public class Cpu {

   String nombre = "cpu";

 //para indicar al ganador
   public String getName(){

    return nombre;
}

   public int jugadaAzar(){

   int azar = (int) (Math.random() * 9) + 1; //un numero al azar

   return azar;
   }

    public void Saludar(){

System.out.println("Hola soy la cpu");

}


//TODO cambiar los metodos de cada clase a su respectiva

}
