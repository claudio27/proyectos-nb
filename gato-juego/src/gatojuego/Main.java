package gatojuego;
import java.io.*;
/**
 *
 * @author Claudio Serrano
 */
public class Main {

  
    public void printTabla(String [][]tab){

        System.out.println(tab[0][0]+"|"+tab[0][1]+"|"+tab[0][2]);
        System.out.println("-+-+-");
        System.out.println(tab[1][0]+"|"+tab[1][1]+"|"+tab[1][2]);
        System.out.println("-+-+-");
        System.out.println(tab[2][0]+"|"+tab[2][1]+"|"+tab[2][2]);


    }
    
    public String[][] llena(String [][]tablero, int posicion){

       if(posicion == 1){
       tablero[0][0] = "x";}
       else if(posicion == 2){
       tablero[0][1] = "x";}
       else if(posicion == 3){
       tablero[0][2] = "x";}
       else if(posicion == 4){
       tablero[1][0] = "x";}
       else if(posicion == 5){
       tablero[1][1] = "x";}
       else if(posicion == 6){
       tablero[1][2] = "x";}
       else if(posicion == 7){
       tablero[2][0] = "x";}
       else if(posicion == 8){
       tablero[2][1] = "x";}
       else if(posicion == 9){
       tablero[2][2] = "x";}

        return tablero;
    }

     public String[][] llenaCpu(String [][]tablero, int posicion){

       if(posicion == 1){
       tablero[0][0] = "o";}
       else if(posicion == 2){
       tablero[0][1] = "o";}
       else if(posicion == 3){
       tablero[0][2] = "o";}
       else if(posicion == 4){
       tablero[1][0] = "o";}
       else if(posicion == 5){
       tablero[1][1] = "o";}
       else if(posicion == 6){
       tablero[1][2] = "o";}
       else if(posicion == 7){
       tablero[2][0] = "o";}
       else if(posicion == 8){
       tablero[2][1] = "o";}
       else if(posicion == 9){
       tablero[2][2] = "o";}

        return tablero;
    }

    public void inicializa(String [][]tablero){

        for(int i=0; i < 3; i++){
            for(int j=0; j< 3; j++)
            {
                tablero[i][j] = " ";
            }
        }
    }

    public int lecturaDatos(){

        int jugada = 0; //lee los datos que entran de teclado
        try{

        BufferedReader q =  new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese número de jugada: 1 al 9 | 0 para terminar");
        jugada=Integer.parseInt(q.readLine());

           }
        catch(java.io.IOException ioex) {
  System.out.println("se presento el error: "+ioex.toString());
    }

        return jugada;

    }

    public void revisaGanador(String[][] tablero, Jugador j1, Cpu cpu){
    //revisa todas las alternativas
    for(int idx = 1; idx <= 8 ; idx++){

        switch(idx){
            //filas
            case '1': if(tablero[0][0].equals(tablero[0][1]) &&
                    tablero[0][1].equals(tablero[0][2]) && tablero[0][0].equals("x"))
                { System.out.println("ha ganado"+j1.getName()); System.exit(0);  }else{
                System.out.println("ha ganado"+ cpu.getName()); System.exit(0);}

            case '2': if(tablero[1][0].equals(tablero[1][1]) &&
                    tablero[1][1].equals(tablero[1][2]) && tablero[1][0].equals("x"))
                { System.out.println("ha ganado"+j1.getName()); System.exit(0);  }else{
                System.out.println("ha ganado"+ cpu.getName()); System.exit(0);}

            case '3': if(tablero[2][0].equals(tablero[2][1]) &&
                    tablero[2][1].equals(tablero[2][2]) && tablero[2][0].equals("x"))
                { System.out.println("ha ganado"+j1.getName()); System.exit(0);  }else{
                System.out.println("ha ganado"+ cpu.getName()); System.exit(0);}

            //columas
            case '4': if(tablero[0][0].equals(tablero[1][0]) &&
                    tablero[1][0].equals(tablero[2][0]) && tablero[0][0].equals("x"))
                { System.out.println("ha ganado"+j1.getName()); System.exit(0);  }else{
                System.out.println("ha ganado"+ cpu.getName()); System.exit(0);}

            case '5': if(tablero[0][1].equals(tablero[1][1]) &&
                    tablero[1][1].equals(tablero[2][1]) && tablero[0][1].equals("x"))
                { System.out.println("ha ganado"+j1.getName()); System.exit(0);  }else{
                System.out.println("ha ganado"+ cpu.getName()); System.exit(0);}

            case '6': if(tablero[0][2].equals(tablero[1][2]) &&
                    tablero[1][2].equals(tablero[2][2]) && tablero[0][2].equals("x"))
                { System.out.println("ha ganado"+j1.getName()); System.exit(0);  }else{
                System.out.println("ha ganado"+ cpu.getName()); System.exit(0);}
            //diagonales
            case '7': if(tablero[0][0].equals(tablero[1][1]) &&
                    tablero[1][1].equals(tablero[2][2]) && tablero[0][0].equals("x"))
                { System.out.println("ha ganado"+j1.getName()); System.exit(0);  }else{
                System.out.println("ha ganado"+ cpu.getName()); System.exit(0);}

            case '8': if(tablero[0][2].equals(tablero[1][1]) &&
                    tablero[1][1].equals(tablero[2][0]) && tablero[0][2].equals("x"))
                { System.out.println("ha ganado"+j1.getName()); System.exit(0);  }else{
                System.out.println("ha ganado"+ cpu.getName()); System.exit(0);}


        }


    }

    

    }



    public static void main(String[] args) {
        // TODO aquí poner la lógica del juego

        

        System.out.println("***Bienvenido al juego***; Creado por Claudio Serrano.");
        System.out.println("1|2|3\n-+-+-\n4|5|6\n-+-+-\n7|8|9");
        String tablero[][] = new String[3][3];

        Main gato = new Main();
        Cpu cpu = new Cpu();
        Jugador j1 = new Jugador();

        gato.inicializa(tablero);

        //loop del juego
        while(true){

         int jugada; //humano
         int jugadaCpu;
         jugada = gato.lecturaDatos();
         tablero =gato.llena(tablero,jugada);
         gato.printTabla(tablero);
         gato.revisaGanador(tablero, j1, cpu);

         System.out.println("Cpu pensando . . .");
         jugadaCpu = cpu.jugadaAzar();
         tablero =gato.llenaCpu(tablero,jugadaCpu);
         gato.printTabla(tablero);
         gato.revisaGanador(tablero, j1, cpu);

         if(jugada == 0) {
    System.out.println("Se acabo el juego..."); System.exit(0);
 }

        }       
        

    }

}
