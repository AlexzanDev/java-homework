/*
 * Copyright (c) 2022. Alessandro Zangrandi.
 * Tutti i diritti riservati.
 */

package progStati;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class searchStati {
    // Pannello per cercare uno stato.
    private JPanel panelCerca;
    private JTextField fieldNome;
    private JButton cercaStatoButton;
    private JPanel bandiera;
    private JButton modificaStatoButton;
    private JButton rimuoviStatoButton;

    public searchStati() {
        cercaStatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Stato> mondo = Mondo.getMondo();
                String nome = fieldNome.getText();
                BufferedImage image;
                boolean hasFoundCountry = false;
                if(nome.equals("")) {
                    JOptionPane.showMessageDialog(panelCerca, "Inserisci il nome dello stato.", "Avviso!", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    int mondoSize = mondo.size();
                    if(mondoSize == 0) {
                        JOptionPane.showMessageDialog(panelCerca, "La lista è vuota.", "Avviso!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        // Aggiunta stato.
                        for (Stato stato : mondo) {
                            String nomeStato = stato.getNome();
                            String nomeEdit;
                            nome = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
                            nomeEdit = nome.replace(" ", "_").replace("d'", "");
                            if(nomeStato.equals(nome)) {
                                String popolazioneStato = String.valueOf(stato.getPopolazione());
                                String pilStato = String.valueOf(stato.getPil());
                                String superficieStato = String.valueOf(stato.getSuperficie());
                                try {
                                    // Creazione immagine e messaggio delle proprietà dello stato.
                                    image = ImageIO.read(new File("src/images/" + nomeEdit + ".jpg"));
                                    ImageIcon icon = new ImageIcon(image);
                                    JOptionPane.showMessageDialog(panelCerca, new JLabel("<html><body>Stato: " +
                                            nomeStato + "<br>Abitanti: " + popolazioneStato + "<br>PIL: " + pilStato +
                                            " euro.<br>Superficie: " + superficieStato + "km^2.</body></html>", icon, JLabel.LEFT),
                                            "Informazioni su" + " " + nome, JOptionPane.PLAIN_MESSAGE);
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                                hasFoundCountry = true;
                                // Software politico?
                                if(nome.equals("Ucraina") || nome.equals("Russia") || nome.equals("Bielorussia")) {
                                    JOptionPane.showMessageDialog(panelCerca, "Слава Україні!", "Interruzione politica", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        }
                        if(!hasFoundCountry) {
                            JOptionPane.showMessageDialog(panelCerca, "Stato non trovato.", "Avviso!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
        });
        rimuoviStatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Stato> mondo = Mondo.getMondo();
                String nome = fieldNome.getText();
                boolean statoFound = false;
                if(nome.equals("")) {
                    JOptionPane.showMessageDialog(panelCerca, "Inserisci il nome dello stato.", "Avviso!", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    int mondoSize = mondo.size();
                    if (mondoSize == 0) {
                        JOptionPane.showMessageDialog(panelCerca, "La lista è vuota.", "Avviso!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        for (Stato stato : mondo) {
                            nome = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
                            String nomeStato = stato.getNome();
                            // Rimuovi uno stato dalla lista.
                            if(nome.equals(nomeStato)) {
                                mondo.remove(stato);
                                JOptionPane.showMessageDialog(panelCerca, "Stato rimosso dalla lista.", "Avviso!", JOptionPane.INFORMATION_MESSAGE);
                                statoFound = true;
                                break;
                            }
                        }
                        if(!statoFound) {
                            JOptionPane.showMessageDialog(panelCerca, "Stato non trovato.", "Avviso!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
        });
        modificaStatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Stato> mondo = Mondo.getMondo();
                String nome = fieldNome.getText();
                boolean statoFound = false;
                if(nome.equals("")) {
                    JOptionPane.showMessageDialog(panelCerca, "Inserisci il nome dello stato.", "Avviso!", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    int mondoSize = mondo.size();
                    if (mondoSize == 0) {
                        JOptionPane.showMessageDialog(panelCerca, "La lista è vuota.", "Avviso!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        for (Stato stato : mondo) {
                            nome = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
                            String nomeStato = stato.getNome();
                            // Apri il pannello della modifica stato.
                            if(nome.equals(nomeStato)) {
                                // TODO: Sistemare la modifica dello stato.
                                panelEdit.genPanel();
                                statoFound = true;
                                break;
                            }
                        }
                        if(!statoFound) {
                            JOptionPane.showMessageDialog(panelCerca, "Stato non trovato.", "Avviso!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
        });
    }

    public static void genPanel() {
        JFrame frame = new JFrame("Ricerca stato");
        frame.setContentPane(new searchStati().panelCerca);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

