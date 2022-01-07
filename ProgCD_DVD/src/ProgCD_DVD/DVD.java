package ProgCD_DVD;

public class DVD extends Articolo {
    private int durata;

    DVD() {
        super();
        this.durata = durata;
    }

    public void setDurata() {
        System.out.print("Inserisci durata film: ");
        durata = in.nextInt();
    }

    public int getDurata() {
        return durata;
    }

    public String getDVD() {
        return ("L'articolo " + titolo + " con codice identificativo " + codice + " costa " + prezzo + " euro ed ha una durata di " + durata + " minuti.");
    }
}
