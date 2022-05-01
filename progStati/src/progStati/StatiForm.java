/*
 * Copyright (c) 2022. Alessandro Zangrandi.
 * Tutti i diritti riservati.
 */

package progStati;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;

public class StatiForm {
    private JPanel panelStati;
    private JTextField fieldNome;
    private JTextField fieldPopolazione;
    private JTextField fieldPIL;
    private JTextField fieldSuperficie;
    private JButton aggiungiStatoButton;
    private JButton ricercaButton;
    private JTextArea elencoNazioni;
    private JButton mostraListaButton;
    private JButton modificaStatoButton;
    FileWriter fileName = null;
    PrintWriter fileOut = null;

    public StatiForm() {
        // Proprietà textArea che mostra la linea.
        elencoNazioni.setEditable(false);
        elencoNazioni.setLineWrap(true);
        elencoNazioni.setWrapStyleWord(true);
        try {
            fileName = new FileWriter("mondo.txt", true); // Non sovrascrive file precedente.
            fileOut = new PrintWriter(fileName);
        } catch (IOException e) {
            System.out.println("Impossibile aprire il file.");
            System.exit(1);
        }
        ricercaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchStati.genPanel();
            }
        });
        aggiungiStatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Stato> mondo = Mondo.getMondo();
                String nome = fieldNome.getText();
                int popolazione = 0;
                float pil = 0f;
                float superficie = 0f;
                boolean nomeOk = false;
                boolean popolazioneOk = false;
                boolean pilOk = false;
                boolean superficieOk = false;
                boolean statoCheck = true;
                // Primi controlli.
                if(nome.equals("")) {
                    JOptionPane.showMessageDialog(panelStati, "Inserisci il nome dello stato.", "Avviso!", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    nomeOk = true;
                }
                try {
                    popolazione = (Integer.parseInt(fieldPopolazione.getText()));
                    if(popolazione < 0) {
                        JOptionPane.showMessageDialog(panelStati, "Inserisci una popolazione valida.", "Avviso!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        popolazioneOk = true;
                    }
                } catch (NumberFormatException nEX) {
                    JOptionPane.showMessageDialog(panelStati, "Inserisci una popolazione valida.", "Avviso!", JOptionPane.INFORMATION_MESSAGE);
                }
                // Try PIL.
                try {
                    pil = Float.parseFloat(fieldPIL.getText());
                    if(pil < 0) {
                        JOptionPane.showMessageDialog(panelStati, "Inserisci un PIL valido.", "Avviso!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        pilOk = true;
                    }
                } catch (NumberFormatException nEX) {
                    JOptionPane.showMessageDialog(panelStati, "Inserisci un PIL valido.", "Avviso!", JOptionPane.INFORMATION_MESSAGE);
                }
                // Try superficie.
                try {
                    superficie = Float.parseFloat(fieldSuperficie.getText());
                    if(superficie < 0) {
                        JOptionPane.showMessageDialog(panelStati, "Inserisci una superficie valida.", "Avviso!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        superficieOk = true;
                    }
                } catch (NumberFormatException nEX) {
                    JOptionPane.showMessageDialog(panelStati, "Inserisci una superficie valida.", "Avviso!", JOptionPane.INFORMATION_MESSAGE);
                }
                if(nomeOk && popolazioneOk && pilOk && superficieOk) {
                    nome = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
                    // Aggiunta stato. Prima controlla se non esiste già uno con lo stesso nome.
                    for (Stato stato : mondo) {
                        if(nome.equals(stato.getNome())) {
                            JOptionPane.showMessageDialog(panelStati, "Stato già esistente.", "Avviso!", JOptionPane.INFORMATION_MESSAGE);
                            statoCheck = false;
                            break;
                        }
                    }
                    if(statoCheck) {
                        Stato statoObj = new Stato(nome, popolazione, pil, superficie);
                        mondo.add(statoObj);
                        JOptionPane.showMessageDialog(panelStati, "Stato aggiunto alla lista.", "Avviso!", JOptionPane.INFORMATION_MESSAGE);
                        fileOut.println(nome + ";" + popolazione + ";" + pil + ";" + superficie);
                        fileOut.flush();
                    }
                }
                mondo.sort(Comparator.comparing(Stato::getNome)); // Ordina stati per nome.
                String strOutput = "";
                // Crea output per la textArea.
                for (Stato stato : mondo) {
                    strOutput += stato.getNome() + ": " + stato.getPopolazione() + " abitanti, " + stato.getPil() + " euro" +
                            " di PIL, " + stato.getSuperficie() + " km^2 di superficie.";
                    strOutput += "\n";
                }
                elencoNazioni.setText(strOutput);
            }
        });
        mostraListaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Stato> mondo = Mondo.getMondo();
                mondo.sort(Comparator.comparing(Stato::getNome));
                String strOutput = "";
                if(mondo.size() == 0) {
                    JOptionPane.showMessageDialog(panelStati, "La lista è vuota.", "Avviso!", JOptionPane.INFORMATION_MESSAGE);
                    elencoNazioni.setText("");
                }
                else {
                    for (Stato stato : mondo) {
                        strOutput += stato.getNome() + ": " + stato.getPopolazione() + " abitanti, " + stato.getPil() + " euro" +
                                " di PIL, " + stato.getSuperficie() + " km^2 di superficie.";
                        strOutput += "\n";
                    }
                    elencoNazioni.setText(strOutput);
                }
            }
        });
        modificaStatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelEdit.genPanel();
            }
        });
    }

    public static void genPanel() {
        JFrame frame = new JFrame("Gestione stati");
        frame.setContentPane(new StatiForm().panelStati);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
