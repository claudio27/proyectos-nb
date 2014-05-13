package genardortrafico;
import java.io.IOException;
import java.net.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author claudio
 */
public class Conector implements Runnable{

    String direccion = "http://";
    URL url;
    BufferedReader in;
    String inputLine;
    public static int numConexiones= 0;

    public Conector(String dir) throws MalformedURLException, IOException {

     this.direccion += dir;
     this.url = new URL(direccion);
     this.in = new BufferedReader(new InputStreamReader(url.openStream()));
     this.inputLine = "";
     numConexiones++;
    }

public static int getConexiones(){

        return numConexiones;

}

    public void run(){

        try{
        if((this.inputLine = this.in.readLine()) != null)
        {
            System.out.println("conexion OK "+getConexiones());
            //Thread.sleep(5000);
            this.in.close();

        }
        }catch(IOException ioe){

            System.err.println(ioe);
        }

    }



}
