/* 
 * File:   main.c
 * Author: claudio
 *
 * Created on 20 de septiembre de 2012, 10:20 AM
 */

#include <stdio.h>
#include <stdlib.h>
#include "lista_doble.h"

TipoDLista inserta_por_cabeza(TipoDLista lista, int valor) {

    struct DNodo * nuevo;

    nuevo = malloc(sizeof (struct DNodo));
    nuevo->info = valor;
    nuevo->ant = NULL;
    nuevo->sig = lista;

    if (lista != NULL)
        lista->ant = nuevo;

    lista = nuevo;
    return lista;

}

TipoDLista inserta_primer(TipoDLista lista, int valor) {
    struct DNodo *nuevo;

    nuevo = malloc(sizeof (struct DNodo));
    nuevo->info = valor;
    nuevo->ant = NULL;
    nuevo->sig = NULL;

    lista = nuevo;
    return lista;
}

TipoDLista borra_por_cola(TipoDLista lista) {
    struct DNodo *aux, *atras;

    //lista vacia
    if (lista == NULL)
        return lista;

    //lista con un nodo
    if (lista->sig == NULL) {
        free(lista);
        lista = NULL;
        return lista;
    }

    //caso general
    for (aux = lista; aux->sig != NULL; aux = aux->sig);
    atras = aux->ant;
    free(aux);
    atras->sig = NULL;
    return lista;

}

void imprimir(TipoDLista lista) {

    struct DNodo *aux;

    for (aux = lista; aux->sig != NULL; aux = aux->sig)
        fprintf("%d, ", aux->info);


}

int main(int argc, char** argv) {

    TipoDLista lista;

    lista = inserta_primer(lista,4);
    lista = inserta_por_cabeza(lista, 3);


    imprimir(lista);

    return (EXIT_SUCCESS);
}

