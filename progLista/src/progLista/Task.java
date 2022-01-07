package progLista;

public class Task {
    private String codice;
    private String descrizione;
    private String nome;

    Task(String codice, String descrizione, String nome) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.nome = nome;
    }

    public String getCodice() {
        return codice;
    }

    public String toString() {
        return ("L'attività " + codice + " con descrizione " + descrizione + " è di " + nome + ".");
    }
}
