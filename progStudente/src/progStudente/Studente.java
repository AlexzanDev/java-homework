package progStudente;

import java.util.Scanner;

public class Studente {
    private String nome;
    private int sommaVoti;
    private int numeroVoti;

    Scanner sc = new Scanner(System.in);

    Studente(int sommaVoti, int numeroVoti) {
        System.out.print("Inserisci il nome dello studente: ");
        this.nome = sc.nextLine();
        this.sommaVoti = sommaVoti;
        this.numeroVoti = numeroVoti;
    }

    public void assegnaVoto() {
        System.out.print("Inserisci un voto: ");
        int voto = sc.nextInt();
        this.numeroVoti++;
        this.sommaVoti = this.sommaVoti + voto;
    }

    public int media() {
        int media = (this.sommaVoti / this.numeroVoti);
        return media;
    }

    public void setNome() {
        System.out.print("Inserisci il nome dello studente: ");
        this.nome = sc.next(); // nextLine non funziona (?)
    }

    public String getNome() {
        return this.nome;
    }

    public String toString() {
        return ("Nome: " + this.nome + ", somma dei voti: " + this.sommaVoti + ", numero dei voti: " + this.numeroVoti);
    }
}
