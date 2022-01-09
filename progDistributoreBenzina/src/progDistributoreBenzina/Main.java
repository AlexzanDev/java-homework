package progDistributoreBenzina;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList<Cliente> cassa = new LinkedList<>();
        LinkedList<Cliente> codaD = new LinkedList<>();
        LinkedList<Cliente> codaB = new LinkedList<>();
        LinkedList<Cliente> codaBD = new LinkedList<>();
        LinkedList<Cliente> codaBDM = new LinkedList<>();
        int scelta = 0;
        int contD = 0;
        int contB = 0;
        int contBD = 0;
        int contBDM = 0;
        int qD = 2000;
        int qB = 2000;
        int qBD = 2000;
        int qBDM = 2000;
        int qCarburante = 0;
        boolean contDUnlocked = false;
        boolean contBUnlocked = false;
        String tipoGasolio;
        Scanner in = new Scanner(System.in);
        Cliente cliente = new Cliente();
        do {
            System.out.print("Premi 1 per fare benzina, premi 2 per pagare e 3 per uscire: ");
            scelta = in.nextInt();
            switch (scelta) {
                case 1:
                    System.out.print("Cosa devi prelevare? D per Diesel, B per Benzina, BD per Benzina e Diesel e Benzina e BDM per tutti (solo in maiuscolo): ");
                    tipoGasolio = in.next();
                    switch(tipoGasolio) {
                        case "D":
                            contD++;
                            if(!contDUnlocked) {
                                System.out.println("Erogatore non disponibile.");
                                break;
                            }
                            else {
                                System.out.print("Di quanti litri di carburante hai bisogno? ");
                                qCarburante = in.nextInt();
                                if(qD - qCarburante < 0) {
                                    System.out.println("Impossibile erogare questa quantità di carburante.");
                                    break;
                                }
                                else {
                                    qD = qD - qCarburante;
                                    codaD.add(cliente);
                                    System.out.println("Cliente aggiunto alla coda.");
                                    cassa.add(cliente);
                                    if(codaD.size() == 5 && (codaBD.size() == 5 || codaBDM.size() == 5)) {
                                        contBUnlocked = true;
                                        System.out.println("Erogatore benzina disponibile.");
                                    }
                                }
                            }
                            break;
                        case "B":
                            contB++;
                            if(!contBUnlocked) {
                                System.out.println("Erogatore non disponibile.");
                                break;
                            }
                            else {
                                System.out.print("Di quanti litri di carburante hai bisogno? ");
                                qCarburante = in.nextInt();
                                if(qB - qCarburante < 0) {
                                    System.out.println("Impossibile erogare questa quantità di carburante.");
                                    break;
                                }
                                else {
                                    qB = qB - qCarburante;
                                    codaB.add(cliente);
                                    System.out.println("Cliente aggiunto alla coda.");
                                    cassa.add(cliente);
                                    if(codaB.size() == 5 && (codaBD.size() == 5 || codaBDM.size() == 5)) {
                                        contDUnlocked = true;
                                        System.out.println("Erogatore diesel disponibile.");
                                    }
                                }
                            }
                            break;
                        case "BD":
                            contBD++;
                            System.out.print("Di quanti litri di carburante hai bisogno? ");
                            qCarburante = in.nextInt();
                            if(qBD - qCarburante < 0) {
                                System.out.println("Impossibile erogare questa quantità di carburante.");
                                break;
                            }
                            else {
                                qBD = qBD - qCarburante;
                                codaBD.add(cliente);
                                System.out.println("Cliente aggiunto alla coda.");
                                cassa.add(cliente);
                                if((contD > contB && !contDUnlocked && codaBD.size() == 5) || (contBUnlocked && (codaB.size() == 5) || codaBDM.size() == 5)) {
                                    contDUnlocked = true;
                                    System.out.println("Erogatore diesel disponibile.");
                                }
                                else if((contB > contD && !contBUnlocked && codaBD.size() == 5) || (contDUnlocked && (codaD.size() == 5) || codaBDM.size() == 5)) {
                                    contBUnlocked = true;
                                    System.out.println("Erogatore benzina disponibile.");
                                }
                            }
                            break;
                        case "BDM":
                            contBDM++;
                            System.out.print("Di quanti litri di carburante hai bisogno? ");
                            qCarburante = in.nextInt();
                            if(qBDM - qCarburante < 0) {
                                System.out.println("Impossibile erogare questa quantità di carburante.");
                                break;
                            }
                            else {
                                qBDM = qBDM - qCarburante;
                                codaBDM.add(cliente);
                                System.out.println("Cliente aggiunto alla coda.");
                                cassa.add(cliente);
                                if((contD > contB && !contDUnlocked && codaBDM.size() == 5) || (contBUnlocked && (codaB.size() == 5) || codaBD.size() == 5)) {
                                    contDUnlocked = true;
                                    System.out.println("Erogatore diesel disponibile.");
                                }
                                else if((contB > contD && !contBUnlocked && codaBDM.size() == 5) || (contDUnlocked && (codaD.size() == 5) || codaBD.size() == 5)) {
                                    contBUnlocked = true;
                                    System.out.println("Erogatore benzina disponibile.");
                                }
                            }
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Cosa hai erogato? D per Diesel, B per Benzina, BD per Benzina e Diesel e Benzina e BDM per tutti (solo in maiuscolo): ");
                    tipoGasolio = in.next();
                    switch(tipoGasolio) {
                        case "D":
                        case "BDM":
                        case "B":
                        case "BD":
                            if(cassa.size() == 0) {
                                System.out.println("Nessun cliente è in coda alla cassa.");
                                break;
                            }
                            else {
                                System.out.println("Grazie e arrivederci.");
                                cassa.remove();
                            }
                            break;
                    }
                    break;
                default:
                    if (scelta != 3) {
                        System.out.println("Scelta non valida.");
                    } else {
                        System.out.println("Uscita in corso...");
                    }
                    break;
            }
        } while (scelta != 3);
    }
}
