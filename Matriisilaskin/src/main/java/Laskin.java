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

        /**
 * Metodi laskee vakiokertoimen ja matriisin skalaaritulon
 *
 * @param   skalaari    kokonaisluku, jolla kerrotaan
 * @param   matriisi    kaksiulotteinen taulukko, joka tulkitaan matriisiksi
 * 
 * @return  matriisi    tuloksena syntynyt matriisi
 * 
 */ 
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

            /**
 * Metodi laskee kahden matriisin summan
 *
 * @param   matriisi2    summan ensimmäinen matriisi
 * @param   matriisi1    summan toinen matriisi
 * 
 * @return  matriisi1    tuloksena syntynyt matriisi
 * 
 */ 
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

            /**
 * Metodi laskee kahden matriisin tulon
 *
 * @param   matriisi1    tulon ensimmäinen matriisi
 * @param   matriisi2    tulon toinen matriisi
 * 
 * @return  matriisi1    tuloksena syntynyt matriisi
 * 
 */ 
    public int[][] tulo(int[][] matriisi1, int[][] matriisi2) {
        int riveja = matriisi1.length;
        int sarakkeita = matriisi2[0].length;
        int[][] tulos = new int[riveja][sarakkeita];
        int i = 0;
        while (i < tulos.length) {
            int j = 0;
            while (j < tulos[0].length) {
                int pistetulo = 0;
                int i2 = 0;
                while (i2 < matriisi2.length) {
                    System.out.println("M1:" + i + i2 + ", M2:" + i2 + j);    
                    pistetulo = pistetulo + matriisi1[i][i2] * matriisi2[i2][j];                    

                    i2++;
                }
                tulos[i][j] = pistetulo;
                System.out.println("[i][j]:" + i + j);
                j++;
            }
            i++;
        }
        
        return tulos;
    }
    
            /**
 * Metodi laskee rekursiivisesti matriisin determinantin.
 *
 * @param   matriisi    kaksiulotteinen taulukko, joka tulkitaan matriisiksi
 * 
 * @return  palautettava    tuloksena syntynyt matriisi
 * 
 */ 
    public int determinantti(int[][] matriisi) {
        int n = matriisi.length;
        
        if (n == 2) {
            return (matriisi[0][0] * matriisi[1][1] - matriisi[1][0] * matriisi[0][1]);
        } else {
            int palautettava = 0;
            int k = 0;
            while (k < n) {
                int[][] matriisi2 = alamatriisi(matriisi, k);
                if (k%2 == 0) {
                    palautettava = palautettava + matriisi[0][k] * determinantti(matriisi2);
                } else {
                    palautettava = palautettava - matriisi[0][k] * determinantti(matriisi2);
                }
                k++;
            }
            return palautettava;
        }
    }

            /**
 * Metodi muodostaa alamatriisin, josta on poistettu alkuperäisen matriisin ensimmäinen rivi ja k:s sarake.
 *
 * @param   matriisi    kaksiulotteinen taulukko, joka tulkitaan matriisiksi
 * @param   k           kokonaisluku, joka kertoo, monesko sarake poistetaan
 * 
 * @return  alamatriisi    tuloksena syntynyt matriisi
 * 
 */ 
    public int[][] alamatriisi(int[][] matriisi, int k) {
        int[][] alamatriisi = new int[matriisi.length - 1][matriisi.length - 1];
        
        int i = 1;
        while (i < matriisi.length) {
            int j1 = 0;
            int j2 = 0;
            while (j2 < matriisi.length) {
                if (j2 != k) {
                    alamatriisi[i-1][j1] = matriisi[i][j2];
                    j1++;
                }
                j2++;
            }
            i++;
        }
        
        return alamatriisi;
    }
    
                /**
 * Metodi luo matriisin transpoosin.
 *
 * @param   matriisi    kaksiulotteinen taulukko, joka tulkitaan matriisiksi
 * 
 * @return  tulos    matriisin transpoosi
 * 
 */ 
    public int[][] transpoosi(int[][] matriisi) {
        int[][] tulos = new int[matriisi[0].length][matriisi.length];
        
        int i = 0;
        while (i < matriisi[0].length) {
            int k = 0;
            while (k < matriisi.length) {
                tulos[i][k] = matriisi[k][i];
                k++;
            }
            i++;
        }
        
        return tulos;
    }
    
    

                 /**
 * Metodi muuttaa matriisin porrasmatriisiksi.
 *
 * @param   matriisi    kaksiulotteinen taulukko, joka tulkitaan matriisiksi
 * 
 * @return  matriisi    muodostettu porrasmatriisi
 * 
 */    
    public double[][] gaussin_algoritmi(double[][] matriisi) {
        int length = Math.min(matriisi.length, matriisi[0].length);
        int m = matriisi.length;
        int n = matriisi[0].length;
        
        for (int k = 0; k < length; k++) {
            double max_val = matriisi[k][k];
            int max_ind = k;
            for (int i = k; i < m; i++) {
                double val = matriisi[i][k];
                if (Math.abs(val) > Math.abs(max_val)) {
                    max_val = val;
                    max_ind = i;
                }
            }
            
            if (max_val != 0) {
                double[] temp = new double[matriisi.length];
                for (int l = 0; l < matriisi.length; l++) {
                    temp[l] = matriisi[k][l];
                }
                for (int l = 0; l < matriisi.length; l++) {
                    matriisi[k][l] = matriisi[max_ind][l];
                }
                for (int l = 0; l < matriisi.length; l++) {
                    matriisi[max_ind][l] = temp[l];
                }
                
                
                double temp2 = matriisi[k][k];
                for (int l = 0; l < matriisi.length; l++) {
                    matriisi[k][l] = matriisi[k][l]/temp2;
                }


                for (int i = k + 1; i < m; i++) {
                    for (int j = k + 1; j < n; j++) {
                        matriisi[i][j] = matriisi[i][j] - matriisi[k][j] * (matriisi[i][k]/matriisi[k][k]);
                    }
                    matriisi[i][k] = 0;
                }
   
                
            }
        }
        
        return matriisi;
    }
    
    
}
