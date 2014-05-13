/*
 * 
 * @author Claudio Serrano
 */
package redescliente;

import java.io.*;
import java.net.*;

/**
Esta clase ClienteTCP se comunica con un servidor a traves del protocolo 
 * TCP, por medio de sockets

 */
public class ClienteTCP {

    /**
    @param InputStreamReader Se le pasa al Buffer lo que se va a escribir por teclado
     * @see El Constructor de BufferedReader
     * @param localhost La maquina local, tambien podria ser una ip de un equipo diferente entre comillas porque es String
       @param 1024 Puerto a traves del cual se conecta, el servidor esta escuchando en ese puerto 
     * @see el Constructor del Socket
     * @param sCli.getOutputStream Es la salida del flujo de datos de este socket cliente en este caso
       @param true
     * @see el Constructor del PrinWriter
     * @param sCli.getInputStream entrega un flujo de entrada para el socket
     * @param linea Imprime lo que leyo del teclado
     * @throws uhe Lanza una error del tipo UnknownHostException
     * @throws e Lanza una error de IOException
     * 
     */
    public static void main(String[] args) {
        try {


            BufferedReader std = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escribe una linea");
            String linea = std.readLine();
            /**
            
             */
            Socket sCli = new Socket("localhost", 1024);
            System.out.println("Cliente ha conectado");
            /**
            
             
             */
            PrintWriter sal = new PrintWriter(sCli.getOutputStream(), true);

            BufferedReader ent;
            /**
            
             */
            ent = new BufferedReader(new InputStreamReader(sCli.getInputStream()));
            /**
            
             */
            sal.println(linea);

            /**
            Imprime lo que le envio el servidor remoto
             */
            String lineaM = ent.readLine();
            System.out.println("Recibido del SERVIDOR= " + lineaM);
            /**
            
            Cierra la comunicacion con el socket y libera los recursos
            
             */
            sCli.close();
            /**
            
            
            
             */
        } catch (UnknownHostException uhe) {
            System.out.println("Host desconocido");

        } /**
        
        
         */
        catch (IOException e) {
            System.out.println("Error en cliente");
        }

    }
}