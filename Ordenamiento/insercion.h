/* 
 * File:   insercion.h
 * Author: claudio
 *
 * Created on 08 de octubre de 2012, 11:25 PM
 */

void insercion(int vector[], int n)
{
   int i, j, indice;
 
   for (i=1; i < n; i++)
   {
      indice = vector[i];

      for (j=i-1;j >= 0 && vector[j] > indice;j--)
      {
         vector[j + 1] = vector[j];
      }
      vector[j+1] = indice;

   }
}