package progPubblicazione;

import java.util.Scanner;

public class Pubblicazione {
    protected String titolo;
    protected float prezzo;
    Scanner in = new Scanner(System.in);

    Pubblicazione() {
        this.titolo = titolo;
        this.prezzo = prezzo;
    }

    public void setPubblicazione() {
        System.out.print("Inserisci titolo pubblicazione: ");
        titolo = in.next();
        System.out.print("Inserisci prezzo pubblicazione: ");
        prezzo = in.nextFloat();
    }

    public float aumentoPrezzo() {
        System.out.print("Di quanto deve essere aumentato il prezzo? ");
        int aumento = in.nextInt();
        prezzo = (prezzo + aumento);
        return prezzo;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public String getTitolo() {
        return titolo;
    }
}
