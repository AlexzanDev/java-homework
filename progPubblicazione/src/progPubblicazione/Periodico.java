package progPubblicazione;

public class Periodico extends Pubblicazione {
    private String direttore;
    private String periodicita;

    Periodico() {
        super();
        this.direttore = direttore;
        this.periodicita = periodicita;
    }

    public void setDirettore() {
        System.out.print("Inserisci direttore pubblicazione: ");
        direttore = in.next();
    }

    public void setPeriodicita() {
        System.out.print("Inserisci periodicità pubblicazione: ");
        periodicita = in.next();
    }

    public String getPeriodico() {
        return ("Il periodico " + titolo + " di " + direttore + " è " + periodicita + ".");
    }
}
