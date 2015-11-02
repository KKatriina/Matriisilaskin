/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kkerokos
 */
public class Laskin {
    
    public Laskin() {
        
    }

    public int[][] skalaaritulo(int skalaari, int[][] matriisi) {
        int i = 0;
        while (i < matriisi.length) {
            int j = 0;
            while (j < matriisi[0].length) {
                int uusiLuku = skalaari * matriisi[i][j];
                matriisi[i][j] = uusiLuku;
                j++;
            }
            i++;
        }
        return matriisi;
    }

    public int[][] summa(int[][] matriisi1, int[][] matriisi2) {
        int i = 0;
        while (i < matriisi1.length) {
            int j = 0;
            while (j < matriisi1[0].length) {
                int uusiLuku = matriisi1[i][j] + matriisi2[i][j];
                matriisi1[i][j] = uusiLuku;
                j++;
            }
            i++;
        }
        return matriisi1;
    }

    public int[][] tulo(int[][] matriisi1, int[][] matriisi2) {
        int riveja = matriisi1.length;
        int sarakkeita = matriisi2.length;
        int[][] tulos = new int[riveja][sarakkeita];
        int i = 0;
        while (i < matriisi1.length) {
            int j = 0;
            while (j < matriisi1[0].length) {
                int pistetulo = 0;
                int i2 = 0;
                while (i2 < matriisi1.length) {
                    pistetulo = pistetulo + matriisi1[i2][i] * matriisi2[i2][j];
                    i2++;
                }
                tulos[i][j] = pistetulo;
                j++;
            }
            i++;
        }
        
        return tulos;
    }
    
    
}
