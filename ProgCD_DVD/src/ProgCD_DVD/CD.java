package ProgCD_DVD;

public class CD extends Articolo {
    private int brani;

    CD() {
        super();
        this.brani = brani;
    }

    public void setBrani() {
        System.out.print("Inserisci numero brani: ");
        brani = in.nextInt();
    }

    public int getBrani() {
        return brani;
    }

    public String getCD() {
        return ("L'articolo " + titolo + " con codice identificativo " + codice + " costa " + prezzo + " euro ed include " + brani + " brani.");
    }
}
