/*
 * TresEnRaya.java
 *
 * Created on 28 de septiembre de 2006, 23:20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.tresenraya;

/**
 *
 * @author Administrador
 */
public class TresEnRaya {
    
    private static int TAM=3;
    private int nTablero[][]=new int[TAM][TAM];
    private int nGanador=-1;
    private static int nContar=0;
    
    /** Creates a new instance of TresEnRaya */
    public TresEnRaya() {
        empezarPartida();
        nContar=0;
    }
    
    public int[][] getTablero(){
        return nTablero;
    }
    
    public void empezarPartida(){
        for (int n=0;n<TAM;n++)
            for (int m=0;m<TAM;m++)
                nTablero[n][m]=-1;
        nGanador=-1;
    }
    
    public void pulsaBoton(int n, int m){
        if (n>=0 && m>=0 && n<TAM && m<TAM && nTablero[n][m]==-1){
            if (nGanador==-1){
                nTablero[n][m]=0;
                nGanador = ganaPartida();
                ponerFichaOrdenador();
            }
        }
    }
    
    public int ganaPartida(){
        if (nTablero[0][0] != -1 && nTablero[0][0] == nTablero[1][1]
                && nTablero[0][0] == nTablero[2][2])
            return nTablero[0][0];
        if (nTablero[0][2] != -1 && nTablero[0][2] == nTablero[1][1]
                && nTablero[0][2] == nTablero[2][0])
            return nTablero[0][2];
        for (int n=0;n<TAM;n++){
            if (nTablero[n][0] != -1 && nTablero[n][0] == nTablero[n][1]
                    && nTablero[n][0] == nTablero[n][2])
                return nTablero[n][0];
            if (nTablero[0][n] != -1 && nTablero[0][n] == nTablero[1][n]
                    && nTablero[0][n] == nTablero[2][n])
                return nTablero[0][n];
        }
        return -1;
    }
    
    public int getGanador(){
        return nGanador;
    }
    
    //Algoritmo minimax
    private boolean tableroCompleto(){
        for (int n=0;n<TAM;n++)
            for (int m=0;m<TAM;m++)
                if (nTablero[n][m]==-1)
                    return false;
        return true;
    }
    
    private boolean finPartida(){
        return tableroCompleto() || ganaPartida()!=-1;
    }
    
    private void ponerFichaOrdenador(){
        if (!finPartida()){
            int f=0, c=0;
            int v=Integer.MIN_VALUE;
            int aux;
            for (int n=0;n<TAM;n++){
                for (int m=0;m<TAM;m++){
                    if (nTablero[n][m]==-1){
                        nTablero[n][m]=1;
                        aux=min();
                        if (aux>v) {
                            v=aux;
                            f=n;
                            c=m;
                        }
                        nTablero[n][m]=-1;
                    }
                }
            }
            nTablero[f][c]=1;
        }
        nGanador=ganaPartida();
    }
    
    private int max(){
        if (finPartida()){
            if (ganaPartida()!=-1) return -1;
            else return 0;
        }
        int v=Integer.MIN_VALUE;
        int aux;
        for (int n=0;n<TAM;n++){
            for (int m=0;m<TAM;m++){
                if (nTablero[n][m]==-1){
                    nTablero[n][m]=1;
                    aux=min();
                    if (aux>v) v=aux;
                    nTablero[n][m]=-1;
                    
                }
            }
        }
        return v;
    }
    
    private int min(){
        if (finPartida()){
            if (ganaPartida()!=-1) return 1;
            else return 0;
        }
        int v=Integer.MAX_VALUE;
        int aux;
        for (int n=0;n<TAM;n++){
            for (int m=0;m<TAM;m++){
                if (nTablero[n][m]==-1){
                    nTablero[n][m]=0;
                    aux=max();
                    if (aux<v) v=aux;
                    nTablero[n][m]=-1;
                }
            }
        }
        return v;
    }

    
}
