package progGuasti;

import java.util.Scanner;

public class Intervento {
    private String richiesta;
    private String nome;
    Scanner in = new Scanner(System.in);

    Intervento(String richiesta) {
        this.richiesta = richiesta;
    }

    public void setNome() {
        System.out.print("Nome e cognome: ");
        nome = in.next();
    }

    public String stampaDati() {
        return ("Richiesta di " + nome + ", " + richiesta);
    }
}
