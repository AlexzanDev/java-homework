package progPubblicazione;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList<Pubblicazione> articleList = new LinkedList<>(); // Crea LinkedList con solo obj Articolo
        int scelta = 0;
        int pubblicazione = 0;
        String nArticolo;
        boolean found = false;
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Premi 1 per inserire una pubblicazione, premi 2 per cercare per titolo, premi 3 per rimuovere una pubblicazione, premi 4 per vendere una pubblicazione, premi 5 per uscire: ");
            scelta = in.nextInt();
            switch(scelta) {
                case 1:
                    System.out.print("Premi 1 per inserire un libro, premi 2 per inserire un periodico: ");
                    pubblicazione = in.nextInt();
                    // Add Libro
                    if(pubblicazione == 1) {
                        Libro libro = new Libro();
                        libro.setPubblicazione();
                        articleList.add(libro);
                        break;
                    }
                    // Add Periodico
                    else if(pubblicazione == 2) {
                        Periodico periodico = new Periodico();
                        periodico.setPubblicazione();
                        periodico.setDirettore();
                        periodico.setPeriodicita();
                        articleList.add(periodico);
                        break;
                    }
                    else {
                        System.out.println("Scelta non valida.");
                    }
                    break;
                case 2:
                    System.out.print("Inserire titolo pubblicazione: ");
                    nArticolo = in.next();
                    for (Pubblicazione publication : articleList) {
                        if (nArticolo.equals(publication.getTitolo())) {
                            if(publication instanceof Libro) { // Compara tipo oggetto
                                System.out.println(((Libro) publication).getLibro());
                            }
                            else if (publication instanceof Periodico) {
                                System.out.println(((Periodico) publication).getPeriodico());
                            }
                            found = true;
                            break;
                        }
                        else {
                            found = false;
                        }
                    }
                    if(!found) {
                        System.out.println("Pubblicazione non trovata.");
                    }
                    break;
                case 3:
                    System.out.print("Inserire titolo pubblicazione: ");
                    nArticolo = in.next();
                    for (Pubblicazione publication : articleList) {
                        if (nArticolo.equals(publication.getTitolo())) {
                            articleList.remove(publication);
                            System.out.println("Pubblicazione rimossa.");
                            found = true;
                        }
                        else {
                            found = false;
                        }
                    }
                    if(!found) {
                        System.out.println("Pubblicazione non trovata.");
                    }
                    break;
                case 4:
                    System.out.print("Inserire titolo pubblicazione: ");
                    nArticolo = in.next();
                    for (Pubblicazione publication : articleList) {
                        if (nArticolo.equals(publication.getTitolo())) {
                            if(publication instanceof Libro) {
                                ((Libro) publication).copiaVenduta();
                                System.out.println("Copia venduta correttamente.");
                            }
                            else {
                                System.out.println("Questa opzione è valida solo per i libri.");
                            }
                            found = true;
                            break;
                        }
                        else {
                            found = false;
                        }
                    }
                    if(!found) {
                        System.out.println("Pubblicazione non trovata.");
                    }
                    break;
                default:
                    if(scelta != 5) {
                        System.out.println("Scelta non valida.");
                    }
                    else {
                        System.out.println("Uscita in corso...");
                    }
                    break;
            }
        } while(scelta != 5);
    }
}
