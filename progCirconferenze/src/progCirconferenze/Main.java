package progCirconferenze;

public class Main {

    public static void main(String[] args) {
	    Circonferenza pianoC[] = new Circonferenza[10];
        int i = 0;
        int somma = 0;
        int distanzaA = 0;
        int distanzaO = 0;
        for(i=0;i<10;i++) {
            pianoC[i] = new Circonferenza();
        }
        for(i=0;i<10;i++) {
            pianoC[i].generateCir();
            System.out.println(pianoC[i].printCir());
        }
        for(i=0;i<10;i++) {
            for(int j=0;j<10;j++) {
                somma = pianoC[i].raggio + pianoC[j].raggio;
                distanzaA = pianoC[i].ascissa - pianoC[j].ascissa;
                distanzaO = pianoC[i].ordinata - pianoC[j].ordinata;
                if (distanzaA == somma && distanzaO == somma) {
                    System.out.println(i + " e " + j + " si intersecano.");
                }
                else {
                    System.out.println(i + " e " + j + " non si intersecano.");
                }
            }
        }
    }
}
