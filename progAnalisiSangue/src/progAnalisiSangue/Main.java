package progAnalisiSangue;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList<Paziente> codaA = new LinkedList<Paziente>();
        LinkedList<Paziente> codaB = new LinkedList<Paziente>();
        LinkedList<Paziente> codaC = new LinkedList<Paziente>();
        LinkedList<Paziente> codaD = new LinkedList<Paziente>();
        LinkedList<Paziente> codaE = new LinkedList<Paziente>();
        int PS = 0;
        int AD = 0;
        int BA = 0;
        int AL = 0;
        int lCoda = 0;
        String codice = null;
        int scelta = 0;
        int tipoPaziente = 0;
        String selCoda;
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Premi 1 per inserire un paziente in coda, premi 2 per rimuovere un paziente o premi 3 per uscire: ");
            scelta = in.nextInt();
            switch(scelta) {
                case 1:
                    System.out.print("1 pronto soccorso, 2 anziani e donne incinte, 3 bambini e 4 altri: ");
                    tipoPaziente = in.nextInt();
                    lCoda = (int)((Math.random() * (5 - 1)) + 1);
                    switch (tipoPaziente) {
                        case 1:
                            PS++;
                            codice = "PS" + PS;
                            break;
                        case 2:
                            AD++;
                            codice = "AD" + AD;
                            break;
                        case 3:
                            BA++;
                            codice = "BA" + BA;
                            break;
                        case 4:
                            AL++;
                            codice = "AL" + AL;
                            break;
                        default:
                            if(tipoPaziente != 5) {
                                System.out.println("Scelta non valida.");
                            }
                            break;
                    }
                    Paziente paziente = new Paziente(codice);
                    switch (lCoda) {
                        case 1:
                            System.out.println("Sei stato assegnato alla coda A.");
                            codaA.add(paziente);
                            System.out.println("In coda ci sono " + codaA.size() + " persone e dovrai attendere " + (codaA.size() * 5) + " minuti per passare.");
                            break;
                        case 2:
                            System.out.println("Sei stato assegnato alla coda B.");
                            codaB.add(paziente);
                            System.out.println("In coda ci sono " + codaB.size() + " persone e dovrai attendere " + (codaB.size() * 5) + " minuti per passare.");
                            break;
                        case 3:
                            System.out.println("Sei stato assegnato alla coda C.");
                            codaC.add(paziente);
                            System.out.println("In coda ci sono " + codaC.size() + " persone e dovrai attendere " + (codaC.size() * 5) + " minuti per passare.");
                            break;
                        case 4:
                            System.out.println("Sei stato assegnato alla coda D.");
                            codaD.add(paziente);
                            System.out.println("In coda ci sono " + codaD.size() + " persone e dovrai attendere " + (codaD.size() * 5) + " minuti per passare.");
                            break;
                        case 5:
                            System.out.println("Sei stato assegnato alla coda E.");
                            codaE.add(paziente);
                            System.out.println("In coda ci sono " + codaE.size() + " persone e dovrai attendere " + (codaE.size() * 5) + " minuti per passare.");
                            break;
                        default:
                            if(tipoPaziente != 5) {
                                System.out.println("Scelta non valida.");
                            }
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Da quale coda rimuovere paziente: A, B, C, D o E (scrivere in maiuscolo): ");
                    selCoda = in.next();
                    switch (selCoda) {
                        case "A":
                            int cAs = codaA.size();
                            if(cAs == 0) {
                                System.out.println("Coda vuota.");
                                break;
                            }
                            else {
                                Paziente tmp = codaA.get(cAs);
                                codaA.remove(cAs);
                                System.out.println("Paziente " + tmp.getCodice() + " rimosso dalla coda.");
                                if(cAs == 0) {
                                    System.out.println("Coda vuota.");
                                    break;
                                }
                                else {
                                    tmp = codaA.get(cAs);
                                    System.out.println("Passa " + tmp.getCodice());
                                }
                            }
                            break;
                        case "B":
                            int cBs = codaB.size();
                            if(cBs == 0) {
                                System.out.println("Coda vuota.");
                                break;
                            }
                            else {
                                Paziente tmp = codaB.get(cBs);
                                codaB.remove(cBs);
                                System.out.println("Paziente " + tmp.getCodice() + " rimosso dalla coda.");
                                if(cBs == 0) {
                                    System.out.println("Coda vuota.");
                                    break;
                                }
                                else {
                                    tmp = codaB.get(cBs);
                                    System.out.println("Passa " + tmp.getCodice());
                                }
                            }
                            break;
                        case "C":
                            int cCs = codaC.size();
                            if(cCs == 0) {
                                System.out.println("Coda vuota.");
                                break;
                            }
                            else {
                                Paziente tmp = codaC.get(cCs);
                                codaC.remove(cCs);
                                System.out.println("Paziente " + tmp.getCodice() + " rimosso dalla coda.");
                                if(cCs == 0) {
                                    System.out.println("Coda vuota.");
                                    break;
                                }
                                else {
                                    tmp = codaC.get(cCs);
                                    System.out.println("Passa " + tmp.getCodice());
                                }
                            }
                            break;
                        case "D":
                            int cDs = codaD.size();
                            if(cDs == 0) {
                                System.out.println("Coda vuota.");
                                break;
                            }
                            else {
                                Paziente tmp = codaD.get(cDs);
                                codaD.remove(cDs);
                                System.out.println("Paziente " + tmp.getCodice() + " rimosso dalla coda.");
                                if(cDs == 0) {
                                    System.out.println("Coda vuota.");
                                    break;
                                }
                                else {
                                    tmp = codaD.get(cDs);
                                    System.out.println("Passa " + tmp.getCodice());
                                }
                            }
                            break;
                        case "E":
                            int cEs = codaE.size();
                            if(cEs == 0) {
                                System.out.println("Coda vuota.");
                                break;
                            }
                            else {
                                Paziente tmp = codaE.get(cEs);
                                codaE.remove(cEs);
                                System.out.println("Paziente " + tmp.getCodice() + " rimosso dalla coda.");
                                if(cEs == 0) {
                                    System.out.println("Coda vuota.");
                                    break;
                                }
                                else {
                                    tmp = codaE.get(cEs);
                                    System.out.println("Passa " + tmp.getCodice());
                                }
                            }
                            break;
                        default:
                            System.out.println("Scelta non valida.");
                            break;
                    }
                    break;
                default:
                    if(scelta != 3) {
                        System.out.println("Scelta non valida.");
                    }
                    else {
                        System.out.println("Uscita in corso...");
                    }
                    break;
            }
        } while(scelta != 3);
    }
}
