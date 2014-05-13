package flujos;

// Configuraciones típicas de flujos de E/S .
import java.io.*;



public class DemoFlujoES {

    // Lanzar excepciones a la consola:
public static void main (String [ ] args) throws IOException {

    // 1. Leyendo de la entrada línea a línea:
BufferedReader entrada = new BufferedReader(new FileReader ("DemoflujoES.java") ) ;
String S, S2 = new String();
while ( (S = entrada. readLine ( ) ) != null)
S2 += S + "\n";
entrada.close() ;


// lb. Leyendo de la entrada estándar:
BufferedReader entradaEstandar = new BufferedReader(new InputStreamReader(System.in));
System.out.print("Introduce una linea:");
System.out.println(entradaEstandar.readLine());


//2.Entrada desde m e m o r i a
StringReader entrada2 = new StringReader(S2);
int c;
while ( (c = entrada2.read() ) != -1)
System.out .print ( (char)c) ;



// 3. Entada con formato desde memoria
try {
DataInputStream entrada3 =new DataInputStream (new ByteArrayInputStream(S2.getBytes()));
while (true)
System.out.print((char)entrada3.readByte());
} catch(EOFException e) {
System.err.println ("Fin del flujo") ;
    }


// 4. Salida de archivo
try {
BufferedReader entrada4 = new BufferedReader(new StringReader (S2)) ;
PrintWriter salida1 =new PrintWriter (new BufferedWriter(new FileWriter ("DemoES.out")));

int contadorLineas = 1;
while((S = entrada4.readLine()) != null )
        salida1.println (contadorLineas++ + " : " + S) ;
salida1.close() ;
} catch (EOFException e) {
System.err .println ("E'in del flujo") ;
    }


// 5. Almacenando & recuperando datos

try {
DataOutputStream salida2 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Datos.txt")));
salida2.writeDouble(3.14159);
salida2.writeChars ("Eso era pi\n");
salida2.writeBytes ("Eso era pi\n");
salida2. close ( ) ;
DataInputStream entrada5 = new DataInputStream (new BufferedInputStream(new FileInputStream("Datos.txt")));
BufferedReader entrada5br = new BufferedReader(new InputStreamReader(entrada5));
// Hay que usar DataInputStream para datos:
System.out.println(entrada5.readDouble());
// Ahora s e p i i e d e i i s a r e1 r e a d T , i n e 0 " a p r o p i a d o " :
System.out.println(entrada5br.readLine());
// Pero la línea resulta divertida.
// La creada con writeBytes es correcta:
System.out.println(entrada5br.readLine());
} catch (EOFException e) {
System.err.println("Fin del flujo");
    }

 // 6. Leyendo/escribiendo archivos de acceso directo
RandomAccessFile rf = new RandomAccessFile("rprueba.dat", "rw");
for(int i = 0; i < 10; i++)
rf.writeDouble(i*1.414);
rf.close() ;
rf=new RandomAccessFile("rprueba.dat", "rw");
rf.seek (5*8);
rf.writeDouble (47.0001);
rf.close ( ) ;
rf = new RandomAccessFile ("rprueba.dat", "r" );

for(int i = 0 ; i < 10; i++)
System.out.println("Valor " + i + ": " +rf.readDouble());
rf.close();
    }
}


