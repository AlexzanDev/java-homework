package ProgCD_DVD;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList<Articolo> articleList = new LinkedList<>(); // Crea LinkedList con solo obj Articolo
        int scelta = 0;
        int CDorDVD = 0;
        String nArticolo;
        boolean found = false;
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Premi 1 per inserire un articolo, premi 2 per cercare per titolo, premi 3 per rimuovere un articolo, premi 4 per uscire: ");
            scelta = in.nextInt();
            switch(scelta) {
                case 1:
                    System.out.print("Premi 1 per inserire un CD, premi 2 per inserire un DVD: ");
                    CDorDVD = in.nextInt();
                    // Add CD
                    if(CDorDVD == 1) {
                        CD cd = new CD();
                        cd.setTitolo();
                        cd.setCodice();
                        cd.setPrezzo();
                        cd.setBrani();
                        articleList.add(cd);
                        break;
                    }
                    // Add DVD
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
                    // Article search by title
                    for (Articolo article : articleList) {
                        if (nArticolo.equals(article.getTitolo())) {
                            if(article instanceof CD) { // Compara tipo oggetto
                                System.out.println(((CD) article).getCD());
                                break;
                            }
                            else if (article instanceof DVD) {
                                System.out.println(((DVD) article).getDVD());
                                break;
                            }
                            found = true;
                            break;
                        }
                        else {
                            found = false;
                        }
                    }
                    if(!found) {
                        System.out.println("Articolo non trovato.");
                    }
                    break;
                case 3:
                    System.out.print("Inserire codice articolo: ");
                    nArticolo = in.next();
                    // Article search by codice
                    for (Articolo article : articleList) {
                        if (nArticolo.equals(article.getCodice())) {
                            articleList.remove(article);
                            System.out.println("Articolo rimosso.");
                            found = true;
                        }
                        else {
                            found = false;
                        }
                    }
                    if(!found) {
                        System.out.println("Articolo non trovato.");
                    }
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
