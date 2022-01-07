package ProgCD_DVD;

import java.util.Scanner;

public class Articolo {
    protected String codice;
    protected String titolo;
    protected float prezzo;
    Scanner in = new Scanner(System.in);

    // Init "Articolo"
    Articolo() {
        this.codice = codice;
        this.titolo = titolo;
        this.prezzo = prezzo;
    }

    public void setCodice() {
        System.out.print("Inserisci codice articolo: ");
        codice = in.next();
    }

    public void setTitolo() {
        System.out.print("Inserisci titolo articolo: ");
        titolo = in.next();
    }

    public void setPrezzo() {
        System.out.print("Inserisci prezzo articolo: ");
        prezzo = in.nextFloat();
    }

    public String getCodice() {
        return codice;
    }

    public String getTitolo() {
        return titolo;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public float aumentoPrezzo() {
        System.out.print("Di quanto deve essere aumentato il prezzo? ");
        int aumento = in.nextInt();
        prezzo = (prezzo + aumento);
        return prezzo;
    }

    public String getArticolo() {
        return ("L'articolo " + titolo + " con codice identificativo " + codice + " costa " + prezzo + " euro.");
    }
}
