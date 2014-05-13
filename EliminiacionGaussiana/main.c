/* 
 * File:   main.c
 * Author: claudio
 *
 * Created on 11 de octubre de 2012, 01:45 PM
 */

#include <stdio.h>
#include <stdlib.h>



int main(int argc, char** argv) {



    FILE *buff; /*area de buffer*/
    char ch;
    char *nombreArchivo;
    int cont = 0;
    int i, j;
    int datos[12];
    int m[3][4];
    int idx = 0;



    nombreArchivo = argv[1];

    if (argv[1] == NULL) {
        printf("Debe ingresar el nombre del archivo\n");
        exit(0);
    }

    buff = fopen(nombreArchivo, "r");

    if (buff == NULL)
        printf("Error al abrir archivo \n");

    else {
        //TODO:la matriz final es de double

           // Empieza a leer el archivo
        while (ch != EOF) {



            ch = getc(buff);



            if (ch != ' ' && isdigit(ch) && ch != '\n') {
                datos[cont] = atoi(&ch);
                cont++;// cuenta el numero de datos
            }




        }fclose(buff);
        printf("%d\n", cont);

        printf("imprimiento arreglo \n\n\n");


        for (i = 0; i < 12; i++) {
            printf("%d, ", datos[i]);
        }

        // llenar la matriz
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 4 && idx < 12; j++, idx++) {
                m[i][j] = datos[idx];

            }
        }

 printf("imprimiento Matriz \n");

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 4; j++) {
                printf("m[%d][%d]=%d\n", i, j,m[i][j]);

            }
        }
       


        
    }

    return (EXIT_SUCCESS);
}

