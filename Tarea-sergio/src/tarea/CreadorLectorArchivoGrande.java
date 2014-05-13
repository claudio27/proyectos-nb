package tarea;
import java.io.*;
import java.util.StringTokenizer;

class CreadorLectorDeArchivoGrande
{
 public void crea()
{
	int i,j,k=0;
        System.out.println("Creando archivo\n espere ...");
	try  {
	   File f = new File("ArchivoConNumeros");
	   FileWriter fw = new FileWriter(f);
	   PrintWriter pw = new  PrintWriter(fw);

	   java.util.Random r = new java.util.Random();

	   for ( j=1;j<5;j++)
	   for(i=0;i<999912349;i++)
	   {
	   	 String str=String.valueOf(r.nextInt()+" ");
	   	 pw.print(str);
	   	 if ( k%10==0)
	   	   pw.println();
	   	   k++;

	   }
	  } catch (Exception e){ System.out.println(" no se puede tener acceso al archivo"+e);}

}

 //@todo llamar a quicksort mientras esta leyendo el archivo
 //@todo volcar el arreglo con los números ordenados en otro archivo
public void lee()
{
     System.out.println("Leyendo archivo\n espere ...");
	try{

	   File f = new File("ArchivoConNumeros");
	   FileReader fr = new FileReader(f);
	   BufferedReader buf = new BufferedReader(fr);
	   while ( buf.ready())
	   {
	   	 String reglon = buf.readLine();
	   	 StringTokenizer stk = new StringTokenizer(reglon);
	   	 while ( stk.hasMoreTokens())
	   	 {
	   	 	System.out.print(stk.nextToken()+"  ");
	   	 }
	   	 System.out.println("...........");

	   }
	     } catch (Exception e){ System.out.println(" no se puede tener acceso al archivo"+e);}


}


   public static String[] Quicksort(String[] vector, int primero, int ultimo){
        int i= primero, j= ultimo;
        String pivote = vector[((primero + ultimo) / 2)];
        String pivote2[] = pivote.trim().split("\\s+");
        pivote = pivote2[0];
        int pivote3 = Integer.parseInt(pivote);


        String auxiliar;
//split divide el string segun la expresion regular y lo guarda en un arreglo
//trim--devuelve una copia del string sin espacios en blanco
        do{

                while( (Integer.parseInt(vector[i].trim().split("\\s+")[0])) < pivote3) i++;
                while( (Integer.parseInt(vector[j].trim().split("\\s+")[0])) > pivote3) j--;

                if (i<=j){
                        auxiliar = vector[j];
                        vector[j]= vector[i];
                        vector[i]= auxiliar;
                        i++;
                        j--;
                }
 
        } while (i<=j);

        if(primero<j) Quicksort(vector,primero, j);
        if(ultimo>i)  Quicksort(vector,i, ultimo);

        return vector;
   }
}