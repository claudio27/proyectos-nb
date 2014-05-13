/* 
 * File:   main.c
 * Author: claudio
 *
 * Created on 19 de septiembre de 2012, 09:48 PM
 */

#include <stdio.h>
#include <stdlib.h>

typedef struct nodo {
    int valor;
    struct nodo *arriba;
    struct nodo *siguiente;
    struct nodo *abajo;
    struct nodo *anterior;
} Nodo;
//acuerdate qlo nodo a primer nodo

int enlazar(Nodo *primero, int columna, int fila) {
    int i = 0;
    int j = 0;
    Nodo *nodo_temporal = (Nodo *) malloc(sizeof (Nodo));

    nodo_temporal = primero;

    while (i < fila - 1) {

        while (j < columna - 1)



            nodo_temporal = primero->abajo;
    }



}

int pabajo(Nodo *primero, int fila) {
    int i = 1;

    Nodo *anterior = primero;

    while (i < fila - 1) {
        Nodo *nodo_temporal = (Nodo *) malloc(sizeof (Nodo));

        // setea posición anterior
        nodo_temporal->arriba = anterior;
        anterior->abajo = nodo_temporal;

        // cambia el nodo anterior al actual
        anterior = nodo_temporal;
        // avanza al siguiente nodo
        i++;
    }


}

int main(int argc, char *argv[]) {
    if (argc < 4) {
        perror("Faltan parámetros");
    }

    int fila = atoi(argv[1]);
    int columna = atoi(argv[2]);
    int k = atoi(argv[3]);

    int i = 0;

    Nodo *primer_nodo = NULL;
    Nodo *nodo_anterior = NULL;

    // creando una lista doble enlazada
    while (i < columna) {
        Nodo *nodo_temporal = (Nodo *) malloc(sizeof (Nodo));
        //pabajo(primer_nodo,fila);
        if (!primer_nodo) {
            primer_nodo = nodo_temporal;
        }

        // setea posición anterior
        nodo_temporal->anterior = nodo_anterior;
        // si el nodo anterior no es nulo
        if (nodo_anterior) {
            // seta el nodo siguiente del anterior al actual
            nodo_anterior->siguiente = nodo_temporal;
        }

        // cambia el nodo anterior al actual
        nodo_anterior = nodo_temporal;
        // avanza al siguiente nodo
        i++;
    }

    // agrega valor inicial al primer nodo
    primer_nodo->valor = k;

    // cada elemento incrementa el nodo en 1
    Nodo *actual = primer_nodo;
    while (actual != NULL) {
        if (actual->anterior != NULL) {
            actual->valor = actual->anterior->valor + 1;
        }
        actual = actual->siguiente;
    }

    // imprime los valores
    actual = primer_nodo;
    i = 0;
    while (actual != NULL) {
        printf("Nodo %i = %i\n", i++, actual->valor);
        actual = actual->siguiente;
    }
}
