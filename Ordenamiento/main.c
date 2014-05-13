/* 
 * File:   main.c
 * Author: claudio
 *
 * Created on 08 de octubre de 2012, 11:20 PM
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "burbuja.h"
#include "insercion.h"
#include "seleccion.h"

/*
 *  Laboratorio 2, Diseño y Análisis de Algoritmos
 *
 *  Algoritmos de Ordenamiento
 *
 *  Seleccion, Insercion, Burbuja
 *
 *
 */
int main(int argc, char* argv) {


    // para que no tenga la misma semilla siempre la
    // funcion rand()
    srand(time(NULL));
    clock_t t_inicial, t_final;
    double t = 0.0; //tiempo en segundos
    int iteraciones = 0;
    int i;
    int j;
    // tamaños de los arreglos
    int tam[] = {10, 100, 200, 500, 1000, 1500, 2000, 5000, 10000, 20000, 100000, 200000};

    // setea la cantidad de elementos
    for (i = 0; i < 12; i++) {
        // 10, 100, 200, ...
        int arr[tam[i]];
        // llena el arreglo con elementos al azar 1 al 1000
        for (j = 0; j < tam[i]; j++) {
            arr[j] = rand() % 1000;
        }
        do {

            t_inicial = clock();


                //seleccion(arr, tam[i]);
          
                //burbuja(arr, tam[i]);
            
                insercion(arr, tam[i]);
           





            t_final = clock();

            t += (t_final - t_inicial) / (double) CLOCKS_PER_SEC;
            iteraciones++;
        } while (t < 0.05);

        t /= iteraciones;

        printf("%f\t%d \n", t, tam[i]);


    }




    return (EXIT_SUCCESS);
}

