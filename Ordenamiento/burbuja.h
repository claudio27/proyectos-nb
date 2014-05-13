/* 
 * File:   burbuja.h
 * Author: claudio
 *
 * Created on 08 de octubre de 2012, 11:24 PM
 */

void burbuja(int x[], int n)
{
  int i, j, temp;

  for (i = (n - 1); i > 0; i--)
  {
    for (j = 1; j <= i; j++)
    {
      if (x[j-1] > x[j])
      {
        temp = x[j-1];
        x[j-1] = x[j];
        x[j] = temp;
      }
    }
  }
}