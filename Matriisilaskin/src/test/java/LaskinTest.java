/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
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
    
    
    
}
