package progBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prenotazione {
    private JPanel panel1;
    private JComboBox<String> comboBox1;
    private JRadioButton pizzaMargheritaRadioButton;
    private JRadioButton spezzatinoRadioButton;
    private JCheckBox vuoiCaffeCheckBox;
    private JComboBox<String> comboBox2;
    private JButton ordinaButton;
    private JRadioButton pesceRadioButton;
    private JRadioButton pastaRadioButton;
    private JRadioButton insalataRadioButton;
    private JRadioButton polloRadioButton;
    private JTextArea textArea1;
    private JButton disegnaButton;
    private JPanel panelDisegno;
    String testo = "";
    float prezzoTotale = 0f;

    public Prenotazione() {
        // Add tables numbers
        comboBox1.addItem("1");
        comboBox1.addItem("2");
        comboBox1.addItem("3");
        comboBox1.addItem("4");
        // Add bevande
        comboBox2.addItem("Acqua");
        comboBox2.addItem("Coca-Cola");
        comboBox2.addItem("Sprite");
        comboBox2.addItem("Fanta");
        // Add button groups
        ButtonGroup primi = new ButtonGroup();
        primi.add(pizzaMargheritaRadioButton);
        primi.add(pastaRadioButton);
        primi.add(pesceRadioButton);
        ButtonGroup secondi = new ButtonGroup();
        secondi.add(polloRadioButton);
        secondi.add(spezzatinoRadioButton);
        secondi.add(insalataRadioButton);
        // Variables
        /* Primi action listener */
        pastaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pasta = pastaRadioButton.getText();
                testo = testo + pasta + "\n";
                prezzoTotale = prezzoTotale + 4f;
            }
        });
        pizzaMargheritaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pizza = pizzaMargheritaRadioButton.getText();
                testo = testo + pizza + "\n";
                prezzoTotale = prezzoTotale + 5f;
            }
        });
        pesceRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pesce = pesceRadioButton.getText();
                testo = testo + pesce + "\n";
                prezzoTotale = prezzoTotale + 6f;
            }
        });
        /* Secondi action listener */
        polloRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pollo = polloRadioButton.getText();
                testo = testo + pollo + "\n";
                prezzoTotale = prezzoTotale + 6.50f;
            }
        });
        spezzatinoRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String spezzatino = spezzatinoRadioButton.getText();
                testo = testo + spezzatino + "\n";
                prezzoTotale = prezzoTotale + 8.30f;
            }
        });
        insalataRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String insalata = insalataRadioButton.getText();
                testo = testo + insalata + "\n";
                prezzoTotale = prezzoTotale + 3.60f;
            }
        });
        /* Combobox listener */
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tavoli = String.valueOf(comboBox1.getSelectedItem());
                switch(tavoli) {
                    case "1":
                    case "2":
                    case "3":
                    case "4":
                        testo = testo + "Tavolo " + tavoli + "\n";
                        break;
                    default:
                        break;
                }

            }
        });
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bevanda = String.valueOf(comboBox2.getSelectedItem());
                switch(bevanda) {
                    case "Acqua":
                    case "Fanta":
                    case "Coca-Cola":
                    case "Sprite":
                        testo = testo + bevanda + "\n";
                        break;
                    default:
                        break;
                }
            }
        });
        // Altro
        vuoiCaffeCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testo = testo + "Caffè" + "\n";
                prezzoTotale = prezzoTotale + 1f;
            }
        });
        // onClick bottone
        ordinaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                textArea1.setText(testo);
                JOptionPane.showMessageDialog(panel1, "Ordine completato. Prezzo da pagare: " + prezzoTotale
                + " euro.");
            }
        });
        // onClick disegna
        disegnaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Graphics blue = panelDisegno.getGraphics();
                Graphics green = panelDisegno.getGraphics();
                int larghezza = panelDisegno.getWidth();
                int altezza = panelDisegno.getHeight();
                blue.setColor(new Color(0, 56, 255));
                blue.fillRect(0,0,larghezza / 2, altezza);
                green.setColor(new Color(33, 255, 0));
                green.fillRect(larghezza / 2,0,larghezza / 2, altezza);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Prenotazione");
        frame.setContentPane(new Prenotazione().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
