package progCitta;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class writeCitta {
    public writeCitta() {}

    public void write() {
        Citta citta;
        FileWriter fileName = null; // Definisci nome file.
        PrintWriter fileOut = null; // PrintWriter per scrivere in file.
        try {
            fileName = new FileWriter("citta.txt");
            fileOut = new PrintWriter(fileName);
        } catch (IOException e) {
            System.out.println("Impossibile aprire il file.");
            System.exit(1);
        }
        citta = new Citta();
        while (citta.readInput() != null) {
            // Fino a quando input non finisce, salva in file [...].
            fileOut.println(citta.nome + ";" + citta.provincia + ";" + citta.numAbitanti);
            fileOut.flush();
        }
        fileOut.close();
        /* try {
            fileOut.close();
        } catch (IOException e) {
            System.out.println("Impossibile chiudere il file.");
            System.exit(1);
        } */
    }
}