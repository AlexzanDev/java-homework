package progCirconferenze;

public class Circonferenza {
    public int raggio;
    public int ascissa;
    public int ordinata;

    Circonferenza() {
        this.ascissa = ascissa;
        this.raggio = raggio;
        this.ordinata = ordinata;
    }

    public void generateCir() {
        ascissa = (int) Math.floor(Math.random()*(9-(-9)+1)+(-9));
        ordinata = (int) Math.floor(Math.random()*(9-(-9)+1)+(-9));
        raggio = (int) Math.floor(Math.random()*(3-1+1)+1);
    }

    public String printCir() {
        return ("Il centro della circonferenza ha come ascissa " + ascissa + " e come ordinata " + ordinata + ". Il raggio è di " + raggio + "cm.");
    }

    public void checkCir() {

    }
}
