package com.progAllievi;

public class Allievo {
    /* Init class (Req.) */
    private String nome;
    private String cognome;
    private String luogoNascita;
    private int assenze;

    /* Constructor method (Req.) */
    public Allievo(String nome, String cognome, String luogoNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.luogoNascita = luogoNascita;
        this.assenze = 0;
    }

    /* Set methods (Req.)
       1: Set nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /* Set cognome */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /* Set luogo di nascita */
    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }

    /* Set assenze */
    public void setAssenze(int assenze) {
        this.assenze = assenze;
    }

    /* Get methods (Req.)
    *  1: Get nome
    */
    public String getNome() {
        return nome;
    }

    /* Get cognome */
    public String getCognome() {
        return cognome;
    }

    /* Get luogo di nascita */
    public String getLuogoNascita() {
        return luogoNascita;
    }

    /* Get assenze */
    public int getAssenze() {
        return assenze;
    }

    /* Method for 'assenze' (Req.) */
    public void aggiungiAssenza(int assenze) {
        this.assenze++;
    }
}