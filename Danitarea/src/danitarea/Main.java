package danitarea;





public class Main {


    
    public static void main(String[] args) {



   Caja obj = new Caja();

  
   System.out.println(" ** Bienvenido ** \n primero cree un arreglo para trabajar");
   int number = obj.ingresoDatos(); //datos numericos de entrada

   //TODO CREAR LA LOGICA PONIENDO LOS COMANDOS POR TECLADO
   int caja[] = new int[number];
   int []b = obj.llenar(caja);
   obj.mostrar(b);
   String lectu = obj.lecturaComandos();
   System.out.println(lectu);
    }

}
