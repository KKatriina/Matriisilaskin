package Matriisilaskin;


import Matriisilaskin.Laskin;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kkerokos
 */
public class Main {

    public static void main(String[] args) {
       Scanner lukija = new Scanner(System.in); 
       Laskin laskin = new Laskin();
       
       tervetuloa(lukija, laskin);
       
//       double[][] matriisi = tallennaMatriisiDouble(lukija);
//       tulostaDouble(matriisi);
//       double[][] tulostettava = laskin.gaussin_algoritmi(matriisi);
//       tulostaDouble(tulostettava);
    }
    
    /**
 * Metodi ohjaa käyttäjän oikeaan toimintoon
 *
 * @param   lukija  käyttäjän syötteen lukija
 * @param   laskin  toimintoja toteuttava laskin
 * 
 */
    public static void tervetuloa(Scanner lukija, Laskin laskin) {
        System.out.println("Tervetuloa käyttämään matriisilaskinta! \n Valitse haluamasi toiminto: \n skalaarilla kertominen: valitse 1 \n matriisien yhteenlasku: valitse 2 \n matriisien tulo: valitse 3 \n determinantin laskeminen: valitse 4 \n transpoosin muodostaminen: valitse 5 \n porrasmatriisin muodostaminen: valitse 6 \n lopetus: valitse x");
        
        String syote = lukija.nextLine();
          
        if (syote.equals("x")) {
            System.out.println("Kiitos!");
        } else {
            if (syote.equals("2")) {
                summa(lukija, laskin);
            } else if (syote.equals("3")) {
                tulo(lukija, laskin);
            } else if (syote.equals("1")) {
                skalaaritulo(lukija, laskin);
            } else if (syote.equals("4")) {
                determinantti(lukija, laskin);
            } else if (syote.equals("5")) {
                transpoosi(lukija, laskin);
            } else if (syote.equals("6")) {
                gaussin_algoritmi(lukija, laskin);
            }
            tervetuloa(lukija, laskin);
        }
    }
    
    /**
 * Metodi hoitaa skalaaritulon alkioiden kyselyn käyttäjältä ja tuloksen kertomisen käyttäjälle
 *
 * @param   lukija  käyttäjän syötteen lukija
 * @param   laskin  toimintoja toteuttava laskin
 * 
 */    
    public static void skalaaritulo(Scanner lukija, Laskin laskin) {
        System.out.println("Anna kokonaisluku, jolla kerrotaan:");
        int skalaari = lukija.nextInt();
        int[][] matriisi = tallennaMatriisi(lukija);
        
        int[][] tulos = laskin.skalaaritulo(skalaari, matriisi);
        tulosta(tulos);
    }
    
        /**
 * Metodi hoitaa summan alkioiden kyselyn käyttäjältä ja tuloksen kertomisen käyttäjälle
 *
 * @param   lukija  käyttäjän syötteen lukija
 * @param   laskin  toimintoja toteuttava laskin
 * 
 */ 
    public static void summa(Scanner lukija, Laskin laskin) {
        System.out.println("Ensimmäinen matriisi:");
        int[][] matriisi1 = tallennaMatriisi(lukija);
        System.out.println("Toinen matriisi:");
        int[][] matriisi2 = tallennaMatriisi(lukija);
        
        if (matriisi1.length != matriisi2.length || matriisi1[0].length != matriisi2[0].length) {
            System.out.println("Summaa ei voi laskea, sillä matriisit ovat erimuotoisia");
        } else {
            int[][] tulos = laskin.summa(matriisi1, matriisi2);
            tulosta(tulos);
        }
    }
    
        /**
 * Metodi tallentaa käyttäjän syötteen kaksiulotteiseksi taulukoksi
 *
 * @param   lukija  käyttäjän syötteen lukija
 * 
 * @return  matriisi    kaksiulotteinen taulukko
 * 
 */ 
    public static int[][] tallennaMatriisi(Scanner lukija) {
        System.out.println("Matriisin rivien määrä:");
        int riveja = lukija.nextInt();
        System.out.println("Matriisin sarakkeiden määrä:");
        int sarakkeita = lukija.nextInt();       
        int[][] matriisi = new int[riveja][sarakkeita];
        
        System.out.println("Syötä sarakkeen rivit yksi kerrallaan, lukujen välissä tyhjä välilyönti");
        
        int i = 0;       
        while (i < riveja) {
            int j = 0;
            while (j < sarakkeita) {
                matriisi[i][j] = lukija.nextInt();
                j++;
            }
            i++;
        }
        
        return matriisi;
    }

        /**
 * Metodi tulostaa kaksiulotteisen taulukon rivi kerrallaan
 *
 * @param   matriisi    kaksiulotteinen taulukko, joka tulostetaan
 * 
 */ 
    public static void tulosta(int[][] matriisi) {
        System.out.println("Tulos:");
        int i = 0;
        while (i < matriisi.length) {
            int j = 0;
            while (j < matriisi[0].length) {
                System.out.print(matriisi[i][j] + " ");
                j++;
            }
            System.out.println("");
            i++;
        }
    }

        /**
 * Metodi hoitaa matriisitulon alkioiden kyselyn käyttäjältä ja tuloksen kertomisen käyttäjälle
 *
 * @param   lukija  käyttäjän syötteen lukija
 * @param   laskin  toimintoja toteuttava laskin
 * 
 */ 
    public static void tulo(Scanner lukija, Laskin laskin) {
        System.out.println("Ensimmäinen matriisi:");
        int[][] matriisi1 = tallennaMatriisi(lukija);
        System.out.println("Toinen matriisi:");
        int[][] matriisi2 = tallennaMatriisi(lukija);
        
        if (matriisi1[0].length != matriisi2.length) {
            System.out.println("Matriisituloa ei voi laskea, sillä ensimmäisen matriisin sarakkeiden määrä ei ole sama kuin toisen matriisin rivien määrä");
        } else {
            int[][] tulos = laskin.tulo(matriisi1, matriisi2);
            tulosta(tulos);
        }
    }

            /**
 * Metodi hoitaa matriisin kysymisen käyttäjältä ja determinantin kertomisen käyttäjälle
 *
 * @param   lukija  käyttäjän syötteen lukija
 * @param   laskin  toimintoja toteuttava laskin
 * 
 */ 
    public static void determinantti(Scanner lukija, Laskin laskin) {
        int[][] matriisi = tallennaMatriisi(lukija);
        if (matriisi.length != matriisi[0].length) {
            System.out.println("Determinanttia ei voi määrittää, sillä matriisi ei ole neliömatriisi");
        } else {
            int tulos = laskin.determinantti(matriisi);
            System.out.println("Matriisin determinantti on " + tulos);
        }
    }

                /**
 * Metodi hoitaa matriisin kysymisen käyttäjältä ja transpoosin kertomisen käyttäjälle
 *
 * @param   lukija  käyttäjän syötteen lukija
 * @param   laskin  toimintoja toteuttava laskin
 * 
 */ 
    public static void transpoosi(Scanner lukija, Laskin laskin) {
        int[][] matriisi = tallennaMatriisi(lukija);
        int[][] tulos = laskin.transpoosi(matriisi);
        tulosta(tulos);
    }
    
    
    
            /**
 * Metodi tallentaa käyttäjän syötteen kaksiulotteiseksi taulukoksi
 *
 * @param   lukija  käyttäjän syötteen lukija
 * 
 * @return  matriisi    kaksiulotteinen taulukko
 * 
 */ 
    public static double[][] tallennaMatriisiDouble(Scanner lukija) {
        System.out.println("Matriisin rivien määrä:");
        int riveja = lukija.nextInt();
        System.out.println("Matriisin sarakkeiden määrä:");
        int sarakkeita = lukija.nextInt();       
        double[][] matriisi = new double[riveja][sarakkeita];
        
        System.out.println("Syötä sarakkeen rivit yksi kerrallaan, lukujen välissä tyhjä välilyönti");
        
        int i = 0;       
        while (i < riveja) {
            int j = 0;
            while (j < sarakkeita) {
                matriisi[i][j] = lukija.nextInt();
                j++;
            }
            i++;
        }
        
        return matriisi;
    }
    
    
            /**
 * Metodi tulostaa kaksiulotteisen taulukon, jonka alkiot ovat liukulukuja, rivi kerrallaan
 *
 * @param   matriisi    kaksiulotteinen taulukko, joka tulostetaan
 * 
 */ 
    public static void tulostaDouble(double[][] matriisi) {
        System.out.println("Tulos:");
        int i = 0;
        while (i < matriisi.length) {
            int j = 0;
            while (j < matriisi[0].length) {
                System.out.print(matriisi[i][j] + " ");
                j++;
            }
            System.out.println("");
            i++;
        }
    }

                /**
 * Metodi hoitaa matriisin kysymisen käyttäjältä ja porrasmatriisin kertomisen käyttäjälle
 *
 * @param   lukija  käyttäjän syötteen lukija
 * @param   laskin  toimintoja toteuttava laskin
 * 
 */
    private static void gaussin_algoritmi(Scanner lukija, Laskin laskin) {
       double[][] tulos = laskin.gaussin_algoritmi(tallennaMatriisiDouble(lukija));
       
       tulostaDouble(tulos);
    }
    
}
