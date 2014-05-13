package mergesort;

/**
 *
 * @author claudio serrano
 */
public class Mergesort {

   // private int a[];

    public  int[] OrdenaMerge(int [] l){

    int n = l.length;

    if(n > 1){

        int m = (int) (Math.ceil(n/2.0));
        int []l1 = new int[m];
        int []l2 = new int[n-m];

        for(int i = 0; i < m; i++){

            l1[i] = l[i];
        }
        for(int i = m; i < n; i++){

            l2[i-m] = l[i];

        }
        // ????
     l = merge(OrdenaMerge(l1), OrdenaMerge(l2));
    }
    return l;
    }

    public int [] eliminar(int [] l){

        int []L = new int[l.length-1];
        for(int i = 1; i < l.length; i++){

            L[i-1] = l[i];

        }
        return L;

    }


    public int []merge(int []L1, int []L2){

        int []L = new int[L1.length + L2.length];
        int i = 0;

        while((L1.length !=0 ) && (L2.length !=0)){

            if(L1[0] < L2[0]){
                L[i++] = L1[0];
                L1 = eliminar(L1);
                if( L1.length == 0){
                    while(L2.length != 0){

                        L[i++] = L2[0];
                        L2 = eliminar(L2);
                        }
                }

            }
 else{

    L[i++] = L2[0];
    L2 = eliminar(L2);
    if(L2.length == 0){
        while(L1.length != 0){
            L[i++] = L1[0];
            L1 = eliminar(L1);

        }


    }



 }

        }

        return L;



    


    }

        public void llenar(int []a, int seed){


        for(int i=0; i < a.length; i++){

            //llena el arreglo con datos aleatorios de 0 a seed, que se pasa
            //como parametro
            a[i] = (int)(Math.random() * seed);

        }




    }

}
