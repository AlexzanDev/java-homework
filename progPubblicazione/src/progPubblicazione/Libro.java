package progPubblicazione;

public class Libro extends Pubblicazione {
    private int copieVendute;

    Libro() {
        super();
        this.copieVendute = 0;
    }

    public void copiaVenduta() {
        copieVendute++;
    }

    public String getLibro() {
        return ("Il libro " + titolo + " ha venduto " + copieVendute + " copie.");
    }
}
