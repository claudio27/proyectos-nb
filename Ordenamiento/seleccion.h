/* 
 * File:   seleccion.h
 * Author: claudio
 *
 * Created on 08 de octubre de 2012, 11:23 PM
 */

void seleccion(int  x[], int n)
{
   int min,i,j,aux,ban;

   for(i=0 ; i<n-1 ; i++)
   {
      ban=0;
      min=i;//min es el elemento primero de la sublista
      for(j=i+1 ; j<n ; j++){//Esta es la sublista.
         if (x[min] > x[j]){
            min=j;//min ahora apunta a el elemento menor de la sublista
            ban=1;//seteamos ban a 1 para que efectue el intercambio dentro de la sublista
         }
      }
      if(ban){
      aux=x[min];
      x[min]=x[i];
      x[i]=aux;
      }
   }
}

