package Matriisilaskin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Matriisilaskin.Laskin;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kkerokos
 */
public class LaskinTest {
    Laskin laskin;
    int[][] matriisi1;
    int[][] matriisi2;
    int[][] matriisi3;
    int[][] matriisi4;
    int[][] ykkosmatriisi;
    int[][] nollamatriisi;
    
    @Before
    public void setUp() {
        laskin = new Laskin();
        
        matriisi1 = new int[2][2];
        matriisi1[0][0] = 1;
        matriisi1[0][1] = 2;
        matriisi1[1][0] = 3;
        matriisi1[1][1] = 4;
        
        ykkosmatriisi = new int[2][2];
        ykkosmatriisi[0][0] = 1;
        ykkosmatriisi[0][1] = 1;
        ykkosmatriisi[1][0] = 1;
        ykkosmatriisi[1][1] = 1;
        
        nollamatriisi = new int[2][2];
        nollamatriisi[0][0] = 0;
        nollamatriisi[0][1] = 0;
        nollamatriisi[1][0] = 0;
        nollamatriisi[1][1] = 0;
        
        matriisi2 = new int[3][2];
        matriisi2[0][0] = 1;
        matriisi2[0][1] = 2;
        matriisi2[1][0] = 3;
        matriisi2[1][1] = 4;
        matriisi2[2][0] = 5;
        matriisi2[2][1] = 6;
        
        matriisi3 = new int[2][3];
        matriisi3[0][0] = 1;
        matriisi3[0][1] = 2;
        matriisi3[0][2] = 3;
        matriisi3[1][0] = 4;
        matriisi3[1][1] = 5;
        matriisi3[1][2] = 6;
        
        matriisi4 = new int[3][3];        
        matriisi4[0][0] = 1;
        matriisi4[1][0] = 6;
        matriisi4[2][0] = 3;
        matriisi4[0][1] = 5;
        matriisi4[1][1] = 0;
        matriisi4[2][1] = 2;
        matriisi4[0][2] = 7;
        matriisi4[1][2] = 1;
        matriisi4[2][2] = 0;
    }
    
    @Test
    public void skalaarituloToimiiPienellaKertoimella() {
        laskin.skalaaritulo(2, matriisi1);
        
        assertEquals(matriisi1[0][0], 2);
        assertEquals(matriisi1[0][1], 4);
        assertEquals(matriisi1[1][0], 6);
        assertEquals(matriisi1[1][1], 8);
    }
    
    @Test
    public void skalaarituloToimiiNollalla() {
        laskin.skalaaritulo(0, matriisi1);
        
        assertEquals(matriisi1[0][0], 0);
        assertEquals(matriisi1[0][1], 0);
        assertEquals(matriisi1[1][0], 0);
        assertEquals(matriisi1[1][1], 0);       
    }
    
    @Test
    public void summaToimiiYkkosmatriisilla() {
        laskin.summa(matriisi1, ykkosmatriisi);
        
        assertEquals(matriisi1[0][0], 2);
        assertEquals(matriisi1[0][1], 3);
        assertEquals(matriisi1[1][0], 4);
        assertEquals(matriisi1[1][1], 5); 
    }
    
    @Test
    public void summaToimiiKunSummataanItse() {
        laskin.summa(matriisi1, matriisi1);
        
        assertEquals(matriisi1[0][0], 2);
        assertEquals(matriisi1[0][1], 4);
        assertEquals(matriisi1[1][0], 6);
        assertEquals(matriisi1[1][1], 8);
    }
    
    @Test
    public void summaToimiiNollamatriisilla() {
        laskin.summa(matriisi1, nollamatriisi);
        
        assertEquals(matriisi1[0][0], 1);
        assertEquals(matriisi1[0][1], 2);
        assertEquals(matriisi1[1][0], 3);
        assertEquals(matriisi1[1][1], 4);
    }
    
    @Test
    public void summaToimiiEiNeliolla() {
        laskin.summa(matriisi2, matriisi2);
        
        assertEquals(matriisi2[0][0], 2);
        assertEquals(matriisi2[2][0], 10);
        assertEquals(matriisi2[2][1], 12);
    }
    
    @Test
    public void ykkosmatriisienTuloToimii() {
        int[][] tulos = laskin.tulo(ykkosmatriisi, ykkosmatriisi);
        
        assertEquals(tulos[0][0], 2);
        assertEquals(tulos[0][1], 2);
        assertEquals(tulos[1][0], 2);
        assertEquals(tulos[1][1], 2);
    }
    
    @Test
    public void tuloYkkosmatriisillaToimii() {
        int[][] tulos = laskin.tulo(matriisi1, ykkosmatriisi);
        int[][] tulos2 = laskin.tulo(ykkosmatriisi, matriisi1);
        
        assertEquals(tulos[0][0], 3);
        assertEquals(tulos[0][1], 3);
        assertEquals(tulos[1][0], 7);
        assertEquals(tulos[1][1], 7);
        assertEquals(tulos2[0][0], 4);
        assertEquals(tulos2[0][1], 6);
        assertEquals(tulos2[1][0], 4);
        assertEquals(tulos2[1][1], 6);
    }
            
    
    @Test
    public void tuloToimiiPienellaNeliomatriisilla() {
        int[][] tulos = laskin.tulo(matriisi1, matriisi1);
        
        assertEquals(tulos[0][0], 7);
        assertEquals(tulos[0][1], 10);
        assertEquals(tulos[1][0], 15);
        assertEquals(tulos[1][1], 22);
    }
    
    @Test
    public void tuloToimiiNollamatriisilla() {
        int[][] tulos = laskin.tulo(matriisi1, nollamatriisi);
        
        assertEquals(tulos[0][0], 0);
        assertEquals(tulos[0][1], 0);
        assertEquals(tulos[1][0], 0);
        assertEquals(tulos[1][1], 0);
    }
    
    @Test
    public void tuloToimiiEiNeliolla() {
        int[][] tulos = laskin.tulo(matriisi2, matriisi3);
        
        assertEquals(tulos[0][0], 9);
        assertEquals(tulos[0][1], 12);
        assertEquals(tulos[0][2], 15);
        assertEquals(tulos[1][0], 19);
        assertEquals(tulos[1][1], 26);
        assertEquals(tulos[1][2], 33);
        assertEquals(tulos[2][0], 29);
        assertEquals(tulos[2][1], 40);
        assertEquals(tulos[2][2], 51);
    }
    
    @Test
    public void alamatriisinMuodostaminenToimii() {
        int[][] alamatriisi0 = laskin.alamatriisi(matriisi4, 0);
        int[][] alamatriisi1 = laskin.alamatriisi(matriisi4, 1);
        int[][] alamatriisi2 = laskin.alamatriisi(matriisi4, 2);
        
        assertEquals(alamatriisi0.length, 2);
        assertEquals(alamatriisi0[0].length, 2);
        assertEquals(alamatriisi0[0][0], 0);
        assertEquals(alamatriisi0[1][1], 0);
        assertEquals(alamatriisi1[0][0], 6);
        assertEquals(alamatriisi1[1][1], 0);
        assertEquals(alamatriisi2[0][0], 6);
        assertEquals(alamatriisi2[1][1], 2);
    }
    
    @Test
    public void determinanttiToimiiPienellaMatriisilla() {
        int tulos = laskin.determinantti(matriisi1);
        
        assertEquals(tulos, -2);
    }
    
    @Test
    public void determinanttiToimiiIsommallaMatriisilla() {
        int tulos = laskin.determinantti(matriisi4);
        
        assertEquals(tulos, 97);
    }
    
    @Test
    public void transpoosiToimiiNeliomatriisilla() {
        int[][] transpoosi = laskin.transpoosi(matriisi1);
        
        assertEquals(transpoosi[0][0], 1);
        assertEquals(transpoosi[0][1], 3);
        assertEquals(transpoosi[1][0], 2);
        assertEquals(transpoosi[1][1], 4);
    }
    
    @Test
    public void transpoosiToimiiEiNeliolla() {
        int[][] transpoosi = laskin.transpoosi(matriisi2);
        
        int[][] matriisiT = new int[2][3];
        matriisiT[0][0] = 1;
        matriisiT[1][0] = 2;
        matriisiT[0][1] = 3;
        matriisiT[1][1] = 4;
        matriisiT[0][2] = 5;
        matriisiT[1][2] = 6;
        
        Assert.assertArrayEquals(transpoosi, matriisiT);
    }
    
    @Test
    public void GaussinAlgoritmiToimiiPienellaMatriisilla() {
        double[] d1 = {1.0, 2.0};
        double[] d2 = {3.0, 4.0};
        double[][] dmatriisi = {d1, d2};
        
        double[][] porrasmatriisi = laskin.gaussin_algoritmi(dmatriisi);
        
        assertEquals(1.333333, porrasmatriisi[0][1], 0.1);
        assertEquals(1, porrasmatriisi[0][0], 0.1);
        assertEquals(0, porrasmatriisi[1][0], 0.1);
        assertEquals(1, porrasmatriisi[1][1], 0.1);
        
    }
    
    @Test
    public void GaussinalgoritmiToimiiEiNeliolla() {
        double[] d1 = {1.0, 4.0, 9.0, 8.0};
        double[] d2 = {8.0, 4.0, 5.0, 3.0};
        double[][] dmatriisi = {d1, d2};
        
        double[][] porrasmatriisi = laskin.gaussin_algoritmi(dmatriisi);
        
        double[] d3 = {1.0, 0.5, 9.0, 8.0};
        double[] d4 = {0.0, 1.0, -4.0, -5.0};
        
        for (int i = 0; i < 4; i++) {
            assertEquals(d3[i], porrasmatriisi[0][i], 0.1);
            assertEquals(d4[i], porrasmatriisi[1][i], 0.1);
        }
    }
    
    @Test
    public void GaussinAlgoritmiToimiiIsommallaNeliomatriisilla() {
        double[] d1 = {2.0, 3.0, 5.0};
        double[] d2 = {4.0, 6.0, 8.0};
        double[] d3 = {1.0, 7.0, 3.0};
        double[][] dmatriisi = {d1, d2, d3};
        
        double[][] porrasmatriisi = laskin.gaussin_algoritmi(dmatriisi);
        
        double[] d4 = {1.0, 1.5, 2.0};
        double[] d5 = {0.0, 1.0, 0.181818};
        double[] d6 = {0.0, 0.0, 1.0};
        
        for (int i = 0; i < 3; i++) {
            assertEquals(d4[i], porrasmatriisi[0][i], 0.1);
            assertEquals(d5[i], porrasmatriisi[1][i], 0.1);
            assertEquals(d6[i], porrasmatriisi[2][i], 0.1);
        }
    }
    
    
    
    
}
