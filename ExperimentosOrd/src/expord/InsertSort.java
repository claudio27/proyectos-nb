package expord;

/**
 *
 * @author claudio serrano
 */
public class InsertSort {

    /**
    @param x Arreglo para ser ordenado con inserSort
     */
    public void insertSort(int[] x) {

        for (int i = 2; i < x.length; i++) {

            int j = i;

            while ((j > 1) && (x[j] < x[j - 1])) {

                int aux = x[j];
                x[j] = x[j - 1];
                x[j - 1] = aux;
                j = j - 1;


            }


        }
    }
}
