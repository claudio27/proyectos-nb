package expord;

/**
 *
 * @author claudio serrano
 */
public class BubbleSort {

    /**
     *@param x Arreglo desordenado de números enteros
     *@return x Arreglo de enteros ordenados
     */
    public int[] bubbleSort(int[] x) {
        int n = x.length;
        for (int pass = 1; pass < n; pass++) {  // cuenta cuantas veces
            // Este loop es más pequeño cada vez
            for (int i = 0; i < n - pass; i++) {
                if (x[i] > x[i + 1]) {
                    // intercambia los elementos
                    int temp = x[i];
                    x[i] = x[i + 1];
                    x[i + 1] = temp;
                }
            }
        }

        return x;
    }
}
