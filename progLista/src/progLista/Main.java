package progLista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Task> Lista = new ArrayList<>();
        int scelta = 0;
        String codice;
        String descrizione;
        String nome;
        int indexList = 0;
        Scanner sc = new Scanner(System.in);
        boolean found = false;
        do {
            System.out.print("Premi 1 per aggiungere attività, 2 per cancellare attività, 3 per visualizzare attività e 4 per uscire: ");
            scelta = sc.nextInt();
            switch(scelta) {
                case 1: System.out.print("Inserisci codice attività: ");
                        codice = sc.next();
                        System.out.print("Inserisci descrizione attività: ");
                        descrizione = sc.next();
                        System.out.print("Inserisci nome impiegato: ");
                        nome = sc.next();
                        Lista.add(new Task(codice, descrizione, nome));
                        break;
                case 2:
                        System.out.print("Inserisci codice attività: ");
                        codice = sc.next();
                        if(Lista.size() <= 0) {
                            System.out.println("Impossibile cancellare attività.");
                            break;
                        }
                        for(int i=0; i<Lista.size(); i++) {
                            if(codice.equals(Lista.get(i).getCodice())) {
                                indexList = i;
                                Lista.remove(indexList);
                                System.out.println("Attività cancellata.");
                                found = true;
                                break;
                            }
                            else if(Lista.get(i).getCodice() == null) {
                                System.out.println("Attività non trovata.");
                                break;
                            }
                        }
                        if(!found) {
                            System.out.println("Attività non trovata.");
                        }
                        break;
                case 3:
                        System.out.print("Inserisci codice attività: ");
                        codice = sc.next();
                        if(Lista.size() <= 0) {
                            System.out.println("Impossibile trovare attività.");
                            break;
                        }
                        for(int i=0; i<Lista.size(); i++) {
                            if(codice.equals(Lista.get(i).getCodice())) {
                                indexList = i;
                                System.out.println(Lista.get(indexList).toString());
                                found = true;
                            }
                            else if(Lista.get(i).getCodice() == null) {
                                System.out.println("Attività non trovata.");
                                break;
                            }
                        }
                        if(!found) {
                            System.out.println("Attività non trovata.");
                        }
                        break;
            }
        } while(scelta != 4);
    }
}