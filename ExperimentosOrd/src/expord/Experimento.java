package expord;

import java.text.DecimalFormat;

/**
 * Experimento de ordenamiento:
 *
 * Corre los algoritmos sobre arrays de diferentes tamaños
 * y cantidades en tiempo de ejecución.
 *
 * <h3>Algoritmos</h3>
 *
 * mergesort <br>
 * bubblesort <br>
 * insertsort <br>
 * quicksort <br>
 * @author Claudio Serrano
 *
 */

public class Experimento {

    private static int[] SIZES = {1000, 2500, 5000, 7500, 10000, 15000, 20000, 30000, 40000, 100000, 500000, 1000000};
    private static int TRIALS = 10;

    /**
     * Aqui se crean los objetos de cada clase de algoritmo de ordenamiento
     * y tambien se toma el tiempo que se demora cada algoritmo en terminar
     * su proceso, se debe descomentar la linea de codigo del algoritmo que se
     * desee ejecutar.

     */

    public static void main(String[] args) {

        //creacion de los objetos
        QuickSort qs = new QuickSort();
        InsertSort is = new InsertSort();
        BubbleSort bs = new BubbleSort();

        System.out.println("Size\tTime (s)");

        for (int size : SIZES) {
            System.out.print(size + "\t");

            long totalNanos = 0;

            for (int t = 0; t < TRIALS; t++) {
                int[] arr = ArrayTools.getRandomIntArray(0, size, size);

                long startNanos = System.nanoTime();
                // recibir un arreglo y ordenarlo
                
                //MergeSort.sort(arr);

                //qs.sort(arr);
                //is.insertSort(arr);
                bs.bubbleSort(arr);




                long endNanos = System.nanoTime();
                totalNanos = totalNanos + (endNanos - startNanos);
            }

            DecimalFormat df = new DecimalFormat("0.00000");
            System.out.println(df.format(totalNanos / 1e9 / TRIALS));
        }
    }
}
