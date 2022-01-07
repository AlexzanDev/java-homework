package progauto;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Inserisci un nome per la macchina: ");
        String nome = in.nextLine();
        Auto car = new Auto(nome);
        int inp = 0;
        int marcia = 0;
        do {
            System.out.println("Inserisci 1 per aggiungere la marcia, 2 per togliere e 0 per uscire");
            try {
                inp = in.nextInt();
                if (inp == 1) {
                    if (car.getMarcia() == 8) {
                        System.out.println("Impossibile aumentare la marcia");
                    } else {
                        car.addMarcia(marcia);
                        System.out.println("La marcia ora e': " + car.getMarcia());
                    }
                }
                if (inp == 2) {
                    if (car.getMarcia() == 1) {
                        System.out.println("Impossibile diminuire la marcia.");
                    } else {
                        car.subMarcia(marcia);
                        System.out.println("La marcia ora e': " + car.getMarcia());
                    }
                }
                if (inp != 1 && inp != 0 && inp != 2) {
                    System.out.println("Input non valido. Riprova.");
                }
            } catch (Exception e) {
                System.out.println("Input non valido. Riprova.");
            }
        } while (inp != 0);
    }
}