/* 
 * File:   lista_doble.h
 * Author: claudio
 *
 * Created on 20 de septiembre de 2012, 02:44 PM
 */

struct DNodo{
    int info; // valor del nodo
    struct DNodo * ant; // puntero al anterior
    struct DNodo * sig; // puntero al siguiente
};

typedef struct DNodo * TipoDLista;

