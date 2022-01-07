package progauto;

public class Auto {
    private int velocita;
    private int marcia;
    private int marciaMax;
    private String nome;

    public Auto(String nome) {
        this.velocita = 0;
        this.marcia = 1;
        this.marciaMax = 8;
        this.nome = nome;
    }

    public void setVelocita(int velocita) {
        this.velocita = velocita;
    }

    public void setMarcia(int marcia) {
        this.marcia = marcia;
    }

    public void setMarciaMax(int marciaMax) {
        this.marciaMax = marciaMax;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVelocita() {
        return velocita;
    }

    public int getMarcia() {
        return marcia;
    }

    public int getMarciaMax() {
        return marciaMax;
    }

    public String getNome() {
        return nome;
    }

    public void addMarcia (int marcia) {
        this.marcia++;
    }

    public void subMarcia (int marcia) {
        this.marcia--;
    }
}