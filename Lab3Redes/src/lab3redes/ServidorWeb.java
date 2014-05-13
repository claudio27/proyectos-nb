/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3redes;

/**
 *
 * @author Claudio Serrano
 */
import java.io.*;
import java.net.*;

public class ServidorWeb {

    protected void start() {
        ServerSocket s;
        System.out.println("Servidor web iniciado en el puerto 81");
        System.out.println("presione ctrl-c to exit");
        try {
            s = new ServerSocket(8080);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return;
        }
        System.out.println("Esperando Conexiones");
        for (;;) {
            try {
                Socket remote = s.accept();
                System.out.println("Conexion, Enviando datos.");
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(remote.getInputStream()));
                PrintWriter out = new PrintWriter(remote.getOutputStream());
                String str = ".";
                while (!str.equals("")) {
                    str = in.readLine();
                }
// Manda la respuesta
// Manda las cabeceras
                out.println("HTTP/1.0 200 OK");
                out.println("Content-Type: text/html");
                out.println("Servidor: Bot");
// esta linea en blanco indica el final de las cabeceras
                out.println("");
// Mandamos la pagina HTML
                out.println("<H1>Bienvenidos al servidor Web</H2>");
                out.println("<p>Esta es una pagina html de prueba.</p>");
                out.flush();
                remote.close();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }

    public static void main(String args[]) {
        ServidorWeb ws = new ServidorWeb();
        ws.start();
    }
}