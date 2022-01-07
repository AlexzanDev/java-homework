package progCodaPaziente;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Coda pazienti = new Coda();
        Paziente lista[] = new Paziente[20];
        Scanner sc = new Scanner(System.in);
        int scelta = 0;
        int numPazienti = 0;
        String codice;
        String nome;
        int nPaziente = 19;
        boolean found = false;
        do {
            System.out.print("Premi 1 per aggiungere paziente, 2 per rimuovere paziente, 3 per visualizzare tutti i pazienti, 4 per visualizzare un paziente e 5 per uscire: ");
            scelta = sc.nextInt();
            switch(scelta) {
                case 1: if(nPaziente <= 0) {
                            System.out.println("Coda piena.");
                            break;
                        }
                        else {
                            System.out.print("Inserisci nome paziente: ");
                            nome = sc.next();
                            lista[nPaziente] = new Paziente(nome);
                            lista[nPaziente].setNumeroLibretto();
                            pazienti.addPaziente(lista[nPaziente]);
                            nPaziente--;
                            numPazienti++;
                        }
                        break;
                case 2:
                        pazienti.removePaziente();
                        System.out.println("Paziente rimosso.");
                        break;
                case 3:
                        for(int i=numPazienti; i>pazienti.sizePazienti(); i--) {
                            System.out.println(lista[i].stampaDati());
                        }
                        break;
                case 4:
                        System.out.print("Inserisci codice paziente: ");
                        codice = sc.next();
                        for(int i=0; i<pazienti.sizePazienti(); i++) {
                            if(codice.equals(lista[i].getCodice())) {
                                System.out.println(lista[i].stampaDati());
                                found = true;
                            }
                        }
                        if(!found) {
                            System.out.println("Paziente non trovato.");
                        }
                        break;
            }
        } while(scelta != 5);
    }
}
