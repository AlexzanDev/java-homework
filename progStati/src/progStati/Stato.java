/*
 * Copyright (c) 2022. Alessandro Zangrandi.
 * Tutti i diritti riservati.
 */

package progStati;

public class Stato {
    // Proprietà stato.
    private String nome;
    private int popolazione;
    private float pil;
    private float superficie;

    public Stato(String nome, int popolazione, float pil, float superficie) {
        this.nome = nome;
        this.popolazione = popolazione;
        this.pil = pil;
        this.superficie = superficie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPopolazione() {
        return popolazione;
    }

    public void setPopolazione(int popolazione) {
        this.popolazione = popolazione;
    }

    public float getPil() {
        return pil;
    }

    public void setPil(float pil) {
        this.pil = pil;
    }

    public float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }
}
