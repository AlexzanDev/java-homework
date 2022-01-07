package com.progAllievi;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* Allievo info */
        System.out.print("Inserisci nome allievo: ");
        String nome = sc.nextLine();
        System.out.print("Inserisci cognome allievo: ");
        String cognome = sc.nextLine();
        System.out.print("Inserisci luogo nascita allievo: ");
        String luogoNascita = sc.nextLine();
	    Allievo alunno = new Allievo(nome, cognome, luogoNascita); // Create alunno obj
        System.out.println("L'alunno " + alunno.getNome() + " " + alunno.getCognome() + " è nato a " + alunno.getLuogoNascita()); // Output alunno
        System.out.print("Premi 1 per aggiungere un'assenza: ");
        /* Add assenza */
        try {
            int confAssenza = sc.nextInt();
            int assenze = 0;
            if(confAssenza == 1) {
                alunno.aggiungiAssenza(assenze);
                System.out.println("L'alunno ha " + alunno.getAssenze() + " assenze");
            }
            else {
                System.out.println("Nessuna assenza aggiunta.");
            }
        }
        catch (Exception e) {
            System.out.println("Nessuna assenza aggiunta.");
        }
    }
}