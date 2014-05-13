package abb;

/**
 *
 * @author claudio
 */
public class Nodo {

    int llave;
    String val;
    Nodo izq;
    Nodo der;

    //Constructor
    Nodo(int llave, String val, Nodo izq, Nodo der){

        this.llave = llave;
        this.val = val;
        this.der = der;
        this.izq = izq;

    }


}
