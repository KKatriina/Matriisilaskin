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
public class LaskinTestSuorituskyky {
    Laskin laskin;
    
//    long aikaAlussa = System.currentTimeMillis();  
//< kutsu tässä testattavaa operaatiota >  
//long aikaLopussa = System.currentTimeMillis();  
//System.out.println("Operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms."); 
    
    public LaskinTestSuorituskyky() {
        laskin = new Laskin();
    }
    
    
   
    @Before
    public void setUp() {
    }
    
    //matriisitulon aikavaativuus nxm- ja mxp-matriiseille O(nmp)
    
    @Test
    public void matriisituloNeliomatriisillaIsollaSyotteella() {
        int isoLuku = 5000;
        int tavoiteaika = 5000;
        
        int[][] matriisi = new int[isoLuku][isoLuku];
        
        for (int i = 0; i < isoLuku; i++) {            
            for (int j = 0; j < isoLuku; j++) {
                matriisi[i][j] = 1;
            }
        }
        
        long aika = 0;
        
//        for (int i = 0; i < 10; i++) {
            long aikaAlussa = System.currentTimeMillis();
            laskin.tulo(matriisi, matriisi);
            long aikaLopussa = System.currentTimeMillis();
            aika = aika + (aikaLopussa - aikaAlussa);
//        }
//        
//        aika = aika / 10;
               
        System.out.println("Neliömatriisin tuloon kului aikaa: " + aika + "ms.");
        
//        boolean vertailu = aika < tavoiteaika;
//        
//        assertEquals(vertailu, true);
    }
    
    @Test
    public void matriisituloEiNeliomatriisillaIsollaSyotteella() {
        int n = 50000;
        int m = 500;
        int p = 5000;
        int tavoiteaika = 5000;
        
        int[][] matriisi1 = new int[n][m];
        int[][] matriisi2 = new int[m][p];
        
        for (int i = 0; i < n; i++) {            
            for (int j = 0; j < m; j++) {
                matriisi1[i][j] = 1;
            }
        }
                
        for (int i = 0; i < m; i++) {            
            for (int j = 0; j < p; j++) {
                matriisi2[i][j] = 1;
            }
        }
        
        long aika = 0;
        
//        for (int i = 0; i < 10; i++) {
            long aikaAlussa = System.currentTimeMillis();
            laskin.tulo(matriisi1, matriisi2);
            long aikaLopussa = System.currentTimeMillis();
            aika = aika + (aikaLopussa - aikaAlussa);
//        }
//        
//        aika = aika / 10;
               
        System.out.println("Matriisituloon kului aikaa: " + aika + "ms.");
//        
//        boolean vertailu = aika < tavoiteaika;
//        
//        assertEquals(vertailu, true);
    }
    
    //Gaussin-Jordanin eliminoinnin aikavaativuus O(n³)
    
    @Test
    public void gaussinAlgoritmiIsollaSyotteella() {
        int isoLuku = 5000;
        int tavoiteaika = 5000;
        
        double[][] matriisi = new double[isoLuku][isoLuku];
        
        for (int i = 0; i < isoLuku; i++) {            
            for (int j = 0; j < isoLuku; j++) {
                matriisi[i][j] = 1;
            }
        }
        
        long aika = 0;

        long aikaAlussa = System.currentTimeMillis();
        laskin.gaussin_algoritmi(matriisi);
        long aikaLopussa = System.currentTimeMillis();
            aika = aikaLopussa - aikaAlussa;
               
        System.out.println("Gaussin algoritmiin kului aikaa: " + aika + "ms.");
//        
//        boolean vertailu = aika < tavoiteaika;
//        
//        assertEquals(vertailu, true);
    }
    
    //determinantin aikavaativuus O(n!)
//    @Test
    public void determinanttiIsollaSyotteella() {
        int isoLuku = 13;
        int tavoiteaika = 5000;
        
        int[][] matriisi = new int[isoLuku][isoLuku];
        
        for (int i = 0; i < isoLuku; i++) {            
            for (int j = 0; j < isoLuku; j++) {
                matriisi[i][j] = 1;
            }
        }
        
        long aika = 0;

        long aikaAlussa = System.currentTimeMillis();
        laskin.determinantti(matriisi);
        long aikaLopussa = System.currentTimeMillis();
        aika = aikaLopussa - aikaAlussa;
               
        System.out.println("Determinantin laskemiseen kului aikaa: " + aika + "ms.");
//        
//        boolean vertailu = aika < tavoiteaika;
//        
//        assertEquals(vertailu, true);
    }
    

}
