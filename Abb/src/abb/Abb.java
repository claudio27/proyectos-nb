package abb;

/**
 *
 * @author claudio
 */
public class Abb {

    Nodo raiz = null;


     //TODO buscar, insertar, borrar

    String getString(int llave) {
        return buscar(llave, raiz);
}

    public String buscar(int llave, Nodo nodo){

        if(nodo == null){
        System.out.println("La llave no existe");
        System.exit(0);
       }
    else if(llave == nodo.llave){
           return nodo.val;}
    else if (llave<nodo.llave){
    return buscar(llave, nodo.izq);}
    else
    return buscar(llave, nodo.der);
    return null; // Solo para evitar el error en compilacion

    }

    void put(int llave, String val) {
raiz= modificar(llave, val, raiz);
}

    Nodo modificar(int llave, String val, Nodo nodo) {
if (nodo==null)
return new Nodo(llave, val, null, null);
if (llave==nodo.llave)
nodo.val= val;
else if (llave<nodo.llave)
nodo.izq= modificar(llave, val, nodo.izq);
else
nodo.der= modificar(llave, val, nodo.der);
return nodo;
}

public void remove(int llave) {
raiz= eliminar(llave, raiz);
}

public Nodo eliminar(int llave, Nodo nodo) {
if (nodo==null)
return null;
if (nodo.llave==llave)
return unir(nodo.izq, nodo.der);
if (llave<nodo.llave)
nodo.izq= eliminar(llave, nodo.izq);
else
nodo.der= eliminar(llave, nodo.der);
return nodo;
}

//cuando se elimina un nodo con subárboles izq y der
public Nodo unir(Nodo izq, Nodo der) {
if (izq==null)
return der;
if (der==null)
return izq;
Nodo centro= unir(izq.der, der.izq);
izq.der= centro;
der.izq= izq;
return der;
}

public void imprimir(){

System.out.println();




}







}
