package progCitta;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int scelta = 0;
        Scanner sc = new Scanner(System.in);
        do {
            readCitta citN = new readCitta();
            System.out.print("Inserisci scelta: ");
            scelta = sc.nextInt();
            switch(scelta) {
                case 1:
                    writeCitta wrCit = new writeCitta(); // Crea oggetto per scrivere in file.
                    wrCit.write(); // Scrivi.
                    System.out.println("File creato.");
                    break;
                case 2:
                    citN.readToken();
                    citN.mostPopCitta();
                    break;
                case 3:
                    citN.readToken();
                    citN.mediaAbitanti();
                    break;
                case 4:
                    citN.readToken(); // Leggi file.
                    break;
                default:
                    System.out.print("Uscita...");
                    break;
            }
        } while (scelta != 5);
    }
}
