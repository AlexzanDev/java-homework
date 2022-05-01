/*
 * Copyright (c) 2022. Alessandro Zangrandi
 * Tutti i diritti riservati.
 */

package progStati;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class panelEdit {
    private JPanel panelEdit;
    private JTextField nomeField;
    private JButton modificaStatoButton;
    private JTextField popolazioneField;
    private JTextField pilField;
    private JTextField superficieField;

    public panelEdit() {
        modificaStatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Stato> mondo = Mondo.getMondo();
                String nome = nomeField.getText();
                nome = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
                boolean checkStato = false;
                for(Stato stato : mondo) {
                    if(nome.equals(stato.getNome())) {
                        int popolazioneNew = 0;
                        float pilNew = 0;
                        float superficieNew = 0;
                        if (!popolazioneField.getText().equals("")) {
                            popolazioneNew = Integer.parseInt(popolazioneField.getText());
                        }
                        if (!pilField.getText().equals("")) {
                            pilNew = Float.parseFloat(pilField.getText());
                        }
                        if (!superficieField.getText().equals("")) {
                            superficieNew = Float.parseFloat(superficieField.getText());
                        }
                        if (popolazioneNew >= 1) {
                            stato.setPopolazione(popolazioneNew);
                        }
                        if (pilNew >= 1) {
                            stato.setPil(pilNew);
                        }
                        if (superficieNew >= 1) {
                            stato.setSuperficie(superficieNew);
                        }
                        JOptionPane.showMessageDialog(panelEdit, "Stato modificato correttamente!", "Avviso!", JOptionPane.INFORMATION_MESSAGE);
                        checkStato = true;
                    }
                }
                if(!checkStato) {
                    JOptionPane.showMessageDialog(panelEdit, "Stato non trovato.", "Avviso!", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    public static void genPanel() {
        JFrame frame = new JFrame("Modifica stato");
        frame.setContentPane(new panelEdit().panelEdit);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}