package progCitta;

import java.util.Scanner;

public class Citta {
    public String nome;
    public String provincia;
    public int numAbitanti;

    public Citta() {
    }

    public Citta readInput() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Inserisci nome città (scrivi * per chiudere il programma): ");
        nome = sc.next();
        if(nome.equals("*")) {
            return null; // Ferma input.
        }
        System.out.printf("Inserisci provincia: ");
        provincia = sc.next();
        System.out.printf("Inserisci numero abitanti: ");
        numAbitanti = sc.nextInt();
        return this; // Return oggetto.
    }
    public void printInput() {
        // Output finale in console.
        System.out.println(nome + " " + "in provincia di " + provincia + " " + "con " + numAbitanti + " abitanti.");
    }
}
