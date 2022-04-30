package progUICoda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Coda {
    private JPanel panel;
    private JTextField askNome;
    private JTextField askEta;
    private JTextArea outputArea;
    private JButton inserisciInCodaButton;
    private JButton estraiDallaCodaButton;
    private String[] nomeInput = new String[5];
    private Integer[] etaInput = new Integer[5];
    private String testoArea;
    private int cont = 0;
    LinkedList<Persona> elenco = new LinkedList<Persona>();

    public Coda() {
        Persona newPersona = new Persona();
        inserisciInCodaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cont == 5) {
                    JOptionPane.showMessageDialog(panel, "Impossibile aggiungere nuovi elementi alla coda.");
                }
                else {
                    testoArea = outputArea.getText();
                    nomeInput[cont] = askNome.getText();
                    etaInput[cont] = Integer.parseInt(askEta.getText());
                    newPersona.setNome(nomeInput[cont]);
                    newPersona.setEta(etaInput[cont]);
                    elenco.add(newPersona);
                    outputArea.setText(testoArea + nomeInput[cont] + " " + etaInput[cont] + " anni" + " - Persona " + (cont+1) + " aggiunta alla coda.\n");
                    cont++;
                }
            }
        });
        estraiDallaCodaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cont == 0) {
                    JOptionPane.showMessageDialog(panel, "La coda è vuota.");
                }
                else {
                    testoArea = outputArea.getText();
                    elenco.remove(newPersona);
                    outputArea.setText(testoArea + nomeInput[cont-1] + " " + etaInput[cont-1] + " anni" + " - Persona " + cont + " rimossa dalla coda.\n");
                    cont--;
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Coda");
        frame.setContentPane(new Coda().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
