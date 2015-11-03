
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
       
//       tervetuloa(lukija, laskin);
       int[][] matriisi = tallennaMatriisi(lukija);
       tulosta(matriisi);
       int tulostettava = laskin.determinantti(matriisi);
        System.out.println(tulostettava);
    }
    
    /**
 * Metodi ohjaa käyttäjän oikeaan toimintoon
 *
 * @param   lukija  käyttäjän syötteen lukija
 * @param   laskin  toimintoja toteuttava laskin
 * 
 */
    public static void tervetuloa(Scanner lukija, Laskin laskin) {
        System.out.println("Tervetuloa käyttämään matriisilaskinta! \n Valitse haluamasi toiminto: \n skalaarilla kertominen: valitse 1 \n matriisien yhteenlasku: valitse 2 \n matriisien tulo: valitse 3 \n lopetus: valitse x");
        
        String syote = lukija.nextLine();
        
        if (syote.equals("1")) {
            skalaaritulo(lukija, laskin);
        } else if (syote.equals("2")) {
            summa(lukija, laskin);
        } else if (syote.equals("3")) {
            tulo(lukija, laskin);
        } else if (syote.equals("x")) {
            System.out.println("Kiitos!");
        } else {
            System.out.println("Virheellinen syöte!");
            tervetuloa(lukija, laskin);
        }
    }
    
    /**
 * Metodi hoitaa skalaaritulon alkioiden kyselyn käyttäjätlä ja tuloksen kertomisen käyttäjälle
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
 * Metodi hoitaa summan alkioiden kyselyn käyttäjätlä ja tuloksen kertomisen käyttäjälle
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
        
        //tarvitaanko tähän jotakin virheellisten tsekkausta?
        
        int[][] tulos = laskin.summa(matriisi1, matriisi2);
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
 * Metodi hoitaa matriisitulon alkioiden kyselyn käyttäjätlä ja tuloksen kertomisen käyttäjälle
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
        
        //tarvitaanko tähän jotakin virheellisten tsekkausta?
        
        int[][] tulos = laskin.tulo(matriisi1, matriisi2);
        tulosta(tulos);
    }
    
}
