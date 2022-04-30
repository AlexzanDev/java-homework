/*
 * Copyright (c) 2022. Alessandro Zangrandi
 * Tutti i diritti riservati.
 */

package progStati;

import javax.swing.*;

public class panelEdit {
    private JPanel panelEdit;
    private JTextField textField1;
    private JButton modificaStatoButton;

    public static void genPanel() {
        JFrame frame = new JFrame("Modifica stato");
        frame.setContentPane(new panelEdit().panelEdit);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}