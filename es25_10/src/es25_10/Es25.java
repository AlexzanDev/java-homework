package es25_10;

import java.util.Locale;

public class Es25 {
    private String testo;
    private int i = 0;

    Es25(String testo) {
        this.testo = testo;
    }

    public boolean maiuscolo() {
        int lunghezza = this.testo.length();
        for(i=0; i<lunghezza; i++){
            if(Character.isUpperCase(this.testo.charAt(i))){ // Utilizza la classe Character che contiene la funzione che controlla se è presente una maiuscola
                return true;
            }
        }
        return false;
    }

    public boolean isDouble() {
        int lunghezza = this.testo.length();
        for(i=0;i<lunghezza-1;i++) {
            if(this.testo.charAt(i) == this.testo.charAt(i+1)) {
                return true;
            }
        }
        return false;
    }

    public String toString(String testo) {
        String maiuscolo = testo.toUpperCase();
        testo = testo.concat(", domani sarà bel tempo");
        int lunghezza = testo.length();
        String newTesto = testo;
        for(i=0;i<lunghezza;i++) {
            newTesto = testo.replaceAll("[aeiou]", "i"); // Cerca tutte le vocali con una regex e le rimpiazza con i
        }
        return (maiuscolo + " " + lunghezza + " " + testo + " " + newTesto);
    }
}
