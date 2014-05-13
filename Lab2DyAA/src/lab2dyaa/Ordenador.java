package lab2dyaa;

/**
 *
 * @author Claudio Serrano Peña y Lillo
 * Esta clase ordena un arreglo con números enteros aplicando diferentes algoritmos
 * de ordenamiento como insertsort, mergesort, bublesort, quicksort
 */
public class Ordenador {

    /**
    Constructor de la clase vacío, no tiene variables
     */
    public Ordenador() {
    }

    /**
    Este método llena el arreglo con enteros al azar
     */
    public int[] llenaAleatorio(int[] arr) {

        for (int j = 0; j < arr.length; j++) {

            arr[j] = (int) (Math.random() * 10000);

        }
        return arr;

    }

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

    /**
    @param x Arreglo desordenado de números enteros
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


   
/**
 @param x Lista de enteros
 @param p Pivote*/
    public int pivotear(int[] x, int p) {

        int aux = x[p];
        x[p] = x[1];
        x[1] = aux;
        int min = 2;
        int max = x.length;

        while (min <= max) {

            if (x[min] <= x[1]) {
                min = min - 1;
            } else {
                aux = x[min];
                x[min] = x[max];
                x[max] = aux;
                max = max + 1;
            }


        }
        aux = x[max];
        x[max] = x[1];
        x[1] = aux;
        return max;

    }
    /**
     @param x Lista de enteros
     */
    public void quickSort(int[] x){

        if(x.length <= 1){
        
        }else{
        int p = (int) (Math.random()*x.length);
        p = pivotear(x, p);
        int []quick1 = new int[p];
        int []quick2= new int[x.length - p];
          for (int i = 0; i < p; i++) {

                quick1[i] = x[i];
            }
            for (int i = p; i < x.length; i++) {
                quick2[i - p] = x[i];
            }
        quickSort(quick1);
        quickSort(quick2);


        }
    }


    /**
    @param l Es el arreglo desordenado
     * @return l Arreglo ordenado después de usar mergeSort
     */
    public int[] mergeSort(int[] l) {

        int n = l.length;

        if (n > 1) {
            // mitad
            int m = (int) (Math.ceil(n / 2.0));
            int[] l1 = new int[m];
            int[] l2 = new int[n - m];

            //copia el array l[] a las 2 nuevas copias
            for (int i = 0; i < m; i++) {

                l1[i] = l[i];
            }
            for (int i = m; i < n; i++) {
                l2[i - m] = l[i];
            }
            l = merge(mergeSort(l1), mergeSort(l2));


        }
        return l;


    }

    /**
    Esta función elimina el primer elemento del arreglo, se llama dentro de mergeSort
     *
     * @param l Lista a la que quita el primer elemento
     * @return  L lista sin primer elemento
     */
    public int[] eliminar(int[] l) {

        int[] L = new int[l.length - 1];
        for (int i = 1; i < l.length; i++) {
            L[i - 1] = l[i];
        }
        return L;

    }

    /**
    Función para mezclar dos listas distintas en una
     * @param l1 primera lista
     * @param l2 segunda lista
     * @return L es l1 + l2  en una sola lista
     */
    public int[] merge(int[] l1, int[] l2) {

        int[] L = new int[l1.length + l2.length];
        int i = 0;
        while ((l1.length != 0) && (l2.length != 0)) {

            if (l1[0] < l2[0]) {

                L[i++] = l1[0];
                l1 = eliminar(l1);
                if (l1.length == 0) {
                    while (l2.length != 0) {

                        L[i++] = l2[0];
                        l2 = eliminar(l2);
                    }

                }
            } else {
                L[i++] = l2[0];
                l2 = eliminar(l2);
                if (l2.length == 0) {
                    while (l1.length != 0) {

                        L[i++] = l1[0];
                        l1 = eliminar(l1);
                    }


                }
            }



        }
        return L;


    }

    /**
    @param arr arreglo a imprimir hacia abajo
     */
    public void imprimir(int[] arr) {


        for (int p = 0; p < arr.length; p++) {


            System.out.println("[" + arr[p] + "]");
        }

        System.out.println("----------------------------------------");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] lista = new int[10];
        Ordenador ord = new Ordenador();
        lista = ord.llenaAleatorio(lista);
        System.out.println("Lista Desordenada---------------");
        ord.imprimir(lista);
        //ordenada con mergesort
        int[] merlist = ord.mergeSort(lista);
        System.out.println("Ordenada con MergeSort---------------");
        ord.imprimir(merlist);
        //ordenada con bublesort
        int[] bublesort = ord.bubbleSort(lista);
        System.out.println("Ordenada con BubleSort---------------");
        ord.imprimir(bublesort);
        //ordenada con insertsort
        System.out.println("Ordenada con InsertSort---------------");
        ord.insertSort(lista);
        ord.imprimir(lista);
    }
}
