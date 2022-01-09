package progCassaSupermercato;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList<Cliente> cassa1 = new LinkedList<>();
        LinkedList<Cliente> cassa2 = new LinkedList<>();
        LinkedList<Cliente> cassa3 = new LinkedList<>();
        boolean c2Unlocked = false;
        boolean c3Unlocked = false;
        int scelta = 0;
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Premi 1 per inserire un cliente in cassa, premi 2 per rimuovere un cliente dalla cassa, premi 3 per uscire: ");
            scelta = in.nextInt();
            switch(scelta) {
                case 1:
                    Cliente cliente = new Cliente();
                    cliente.setEta();
                    int eta = cliente.getEta();
                    if(eta < 15 || eta > 80) {
                        System.out.println("Età non valida.");
                        break;
                    }
                    if(cassa1.size() == 15 && cassa2.size() == 15 && cassa3.size() == 15) {
                        System.out.println("Le casse sono piene.");
                        break;
                    }
                    else if(cassa1.size() < 15 && !c2Unlocked && !c3Unlocked) {
                        cassa1.add(cliente);
                        System.out.println("Cliente in coda.");
                    }
                    else if((cassa1.size() < 15 || cassa2.size() < 15) && c2Unlocked) {
                        if((cassa3.size() < 15 && c3Unlocked) && cliente.getEta() > 60) {
                            cassa3.add(cliente);
                            System.out.println("Cliente in coda.");
                        }
                        else if(cassa1.size() > cassa2.size()) {
                            cassa2.add(cliente);
                            System.out.println("Cliente in coda.");
                        }
                        else {
                            cassa1.add(cliente);
                            System.out.println("Cliente in coda.");
                        }
                    }
                    if(cassa1.size() == 15 && !c2Unlocked) {
                        c2Unlocked = true;
                        System.out.println("Cassa 2 aperta.");
                        for(int i=0; i<cassa1.size(); i++) {
                            if(i % 2 == 0) {
                                cassa2.add(cassa1.get(i));
                                System.out.println("Cliente in coda alla cassa 2.");
                                cassa1.remove();
                            }
                        }
                        break;
                    }
                    else if((cassa1.size() == 15 || cassa2.size() == 15) && c2Unlocked) {
                        c3Unlocked = true;
                        System.out.println("Cassa 3 aperta.");
                        for(int i=0; i<cassa1.size(); i++) {
                            Cliente temp = cassa1.get(i);
                            if(temp.getEta() > 60) {
                                cassa3.add(temp);
                                System.out.println("Cliente in coda.");
                                cassa1.remove();
                            }
                        }
                        for(int i=0; i<cassa2.size(); i++) {
                            Cliente temp = cassa2.get(i);
                            if(temp.getEta() > 60) {
                                cassa3.add(temp);
                                System.out.println("Cliente in coda.");
                                cassa2.remove();
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.print("In che cassa si trova? ");
                    scelta = in.nextInt();
                    switch (scelta) {
                        case 1:
                            if(cassa1.size() == 0) {
                                System.out.println("La cassa è vuota.");
                                break;
                            }
                            else {
                                cassa1.remove();
                                System.out.println("Il cliente ha lasciato la coda.");
                            }
                            break;
                        case 2:
                            if(cassa2.size() == 0) {
                                System.out.println("La cassa è vuota.");
                                break;
                            }
                            else {
                                cassa2.remove();
                                System.out.println("Il cliente ha lasciato la coda.");
                            }
                        case 3:
                            if(cassa3.size() == 0) {
                                System.out.println("La cassa è vuota.");
                                break;
                            }
                            else {
                                cassa3.remove();
                                System.out.println("Il cliente ha lasciato la coda.");
                            }
                        default:
                            if(scelta != 3) {
                                System.out.println("Scelta non valida.");
                            }
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
