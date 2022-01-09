package progGuasti;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Coda interventi = new Coda();
        Intervento lista[] = new Intervento[20];
        Scanner sc = new Scanner(System.in);
        int scelta = 0;
        int numInterventi = 0;
        String richiesta;
        int nInterventi = 19;
        boolean found = false;
        do {
            System.out.print("Premi 1 per aggiungere intervento, 2 per rimuovere intervento, 3 per sapere le richieste in coda e 4 per uscire: ");
            scelta = sc.nextInt();
            switch(scelta) {
                case 1: if(numInterventi >= 19) {
                    System.out.println("Coda piena.");
                    break;
                }
                else {
                    System.out.print("Inserisci richiesta intervento: ");
                    richiesta = sc.next();
                    lista[numInterventi] = new Intervento(richiesta);
                    lista[numInterventi].setNome();
                    interventi.addIntervento(lista[numInterventi]);
                    nInterventi--;
                    numInterventi++;
                }
                    break;
                case 2:
                    if(numInterventi == 0) {
                        System.out.println("Nessun intervento trovato.");
                        break;
                    }
                    else {
                        interventi.removeIntervento();
                        System.out.println(lista[numInterventi-1].stampaDati() + " rimossa.");
                        numInterventi--;
                    }
                    break;
                case 3:
                    System.out.println("Le richieste di intervento sono " + interventi.sizeInterventi() + ".");
            }
        } while(scelta != 4);
    }
}
