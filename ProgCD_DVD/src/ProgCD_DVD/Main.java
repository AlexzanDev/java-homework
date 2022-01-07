package ProgCD_DVD;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList articleList = new LinkedList();
        Articolo a1 = new Articolo();
        CD c1 = new CD();
        DVD d1 = new DVD();
        int scelta = 0;
        int CDorDVD = 0;
        String nArticolo;
        boolean found;
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Premi 1 per inserire un articolo, premi 2 per cercare per titolo, premi 3 per rimuovere un articolo, premi 4 per uscire: ");
            scelta = in.nextInt();
            switch(scelta) {
                case 1:
                    System.out.print("Premi 1 per inserire un CD, premi 2 per inserire un DVD: ");
                    CDorDVD = in.nextInt();
                    if(CDorDVD == 1) {
                        CD cd = new CD();
                        cd.setTitolo();
                        cd.setCodice();
                        cd.setPrezzo();
                        cd.setBrani();
                        articleList.add(cd);
                        break;
                    }
                    else if(CDorDVD == 2) {
                        DVD dvd = new DVD();
                        dvd.setTitolo();
                        dvd.setCodice();
                        dvd.setPrezzo();
                        dvd.setDurata();
                        articleList.add(dvd);
                        break;
                    }
                    else {
                        System.out.println("Scelta non valida.");
                    }
                    break;
                case 2:
                    System.out.print("Inserire titolo articolo: ");
                    nArticolo = in.next();
                    /* for(int i = 0; i<articleList.size(); i++) {
                        if() {
                            System.out.println();
                            found = true;
                        }
                    }
                    if(!found) {
                        System.out.println("Articolo non trovato.");
                    } */
                    break;
                case 3:
                    System.out.print("Inserire codice articolo: ");
                    nArticolo = in.next();
                    /* for(int i = 0; i<articleList.size(); i++) {
                        if() {
                            articleList[i].remove();
                            found = true;
                        }
                    }
                    if(!found) {
                        System.out.println("Articolo non trovato.");
                    } */
                    break;
                default:
                    if(scelta != 4) {
                        System.out.println("Scelta non valida.");
                    }
                    else {
                        System.out.println("Uscita in corso...");
                    }
                    break;
            }
        } while(scelta != 4);
    }
}
