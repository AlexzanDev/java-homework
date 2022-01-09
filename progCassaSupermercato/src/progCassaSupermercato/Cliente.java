package progCassaSupermercato;

import java.util.Scanner;

public class Cliente {
    private int eta = 0;
    Scanner in = new Scanner(System.in);

    Cliente() { }

    public void setEta() {
        System.out.print("Età cliente: ");
        eta = in.nextInt();
    }

    public int getEta() {
        return eta;
    }
}
