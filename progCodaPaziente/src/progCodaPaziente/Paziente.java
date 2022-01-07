package progCodaPaziente;

import java.util.Scanner;

public class Paziente {
    private String codice;
    private String nome;

    Paziente(String nome) {
        this.nome = nome;
    }

    public void setNumeroLibretto() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Inserisci numero libretto: ");
        codice = sc.next();
    }

    public String stampaDati() {
        return ("Il paziente " + nome + " ha come codice libretto " + codice + ".");
    }

    public String getCodice() {
        return codice;
    }
}
