package redesservidor;

import java.io.*;
import java.net.*;

/***
 * /
 * @author Claudio Serrano
 */




/**
 
  * Descripcion de puertos: <br>
  1-1024; estan permitidos abrirlos<br>
 * 21 : ftp<br>
 * 22 : ssh<br>
 * 23 : telnet<br>
 * 24 : MTA<br>
 * 80 : web<br>
 * 110 pop3<br>
 * puerto 7777 no esta habilitado para clientes comunes<br>
 * 443 : https<br>
 * 995 : ssl<br>
 * Crea un servidor TCP por medio de sockets, permite la conección de multiples usuarios
 * el servidor esta escuchando por medio del puerto 1024, lo que hace es recibir un String
 * de datos del Cliente y reenviar un nuevo mensaje con el texto Cliente envia más el mensaje
 * que envio el cliente
 
 
 */

public class ServidorTCP {
/**
     @param args Se le pueden pasar argumentos por linea de comandos, pero en este caso no se usa
     
     */
    
    public static void main(String[] args) {
        try {
            // puerto por el cual el servidor empieza a escuchar
            //172.20.101.61
            ServerSocket sSrv = new ServerSocket(1024);
            while (true) {
                Socket sCli = sSrv.accept();
                System.out.println("Cliente ha conectado");
                BufferedReader ent;
                ent = new BufferedReader(new InputStreamReader(sCli.getInputStream()));
                PrintStream sal = new PrintStream(sCli.getOutputStream(), true);
                String linea = ent.readLine();
                System.out.println("Cliente envia= " + linea);
                linea = linea.toUpperCase();
                sal.println(linea);
                sCli.close();
                System.out.println("Cliente ha desconectado");
            }
        } catch (IOException e) {
            System.out.println("Error en servidor");
        }
    }
}