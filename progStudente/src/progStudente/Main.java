package progStudente;

public class Main {
    public static void main(String[] args) {
        Studente st1 = new Studente(17, 2);
        st1.assegnaVoto();
        st1.setNome();
        System.out.println(st1.getNome());
        System.out.println(st1.media());
        System.out.println(st1.toString());
    }
}
