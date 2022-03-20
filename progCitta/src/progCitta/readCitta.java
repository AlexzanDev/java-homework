package progCitta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class readCitta {
    LinkedList<String> nomiCitta = new LinkedList<>();
    LinkedList<Integer> abitantiCitta = new LinkedList<>();
    public readCitta() {}

    public void readToken() {
        FileReader fileName = null; // Crea file.
        BufferedReader fileIn = null; // Crea BufferedReader per lavorare con il file.
        Citta citta;
        String str; // Riga file.
        StringTokenizer st; // Crea StringTokenizer.
        try {
            fileName = new FileReader("citta.txt"); // Genera file.
            fileIn = new BufferedReader(fileName); // Prepara file per utilizzo.
        } catch (IOException e) {
            System.out.println("Impossibile utilizzare il file.");
            System.exit(1);
        }
        citta = new Citta();
        try {
            str = fileIn.readLine(); // Leggi riga.
            while (str != null) { // Fino a quando non ha raggiunto ultima riga [...].
                st = new StringTokenizer(str, ";"); // Definisci delimitatore.
                citta.nome = st.nextToken(); // Salva negli attributi il campo della riga.
                nomiCitta.add(citta.nome);
                citta.provincia = st.nextToken();
                citta.numAbitanti = Integer.parseInt(st.nextToken());
                abitantiCitta.add(citta.numAbitanti);
                citta.printInput(); // Stampa contenuto riga (Citta).
                str = fileIn.readLine();
            }
        } catch (IOException e) {
            System.out.println("Impossibile leggere il file.");
            System.exit(1);
        }
        try {
            fileIn.close(); // Chiudi file.
        } catch (IOException e) {
            System.out.println("Impossibile chiudere il file.");
            System.exit(1);
        }
    }
    public void mostPopCitta() {
        int max = 0;
        int posCit = 0;
        for (int i=0;i<abitantiCitta.size();i++) {
            int index = abitantiCitta.get(i);
            if(index > max) {
                max = index;
                posCit = i;
            }
        }
        System.out.println("La città più popolosa è " + nomiCitta.get(posCit) + " con " + max + " abitanti.");
    }
    public void mediaAbitanti() {
        int somma = 0;
        for(int i=0;i<abitantiCitta.size();i++) {
            somma = somma + abitantiCitta.get(i);
        }
        System.out.println("La media di abitanti è " + (somma / abitantiCitta.size()) + ".");
    }
}
