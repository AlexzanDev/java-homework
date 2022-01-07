package com.progetto1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	    Scanner tastiera = new Scanner(System.in);
        System.out.print("Scrivi qualcosa: ");
        String tes = tastiera.nextLine();
        System.out.println(tes);
    }
}