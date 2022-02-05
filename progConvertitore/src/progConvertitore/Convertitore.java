package progConvertitore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Convertitore {
    private JPanel panel1;
    private JLabel askNumber;
    private JTextField askNumberForm;
    private JLabel askBase;
    private JComboBox askBaseForm;
    private JLabel getNumber;
    private JTextField getNumberForm;

    public Convertitore() {
        askBaseForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String conversione = String.valueOf(askBaseForm.getSelectedItem());
                String number = askNumberForm.getText();
                String risultato;
                switch(conversione) {
                    case "Binaria":
                        risultato = Integer.toBinaryString(Integer.parseInt(number));
                        getNumberForm.setText(risultato);
                        break;
                    case "Ottale":
                        risultato = Integer.toOctalString(Integer.parseInt(number));
                        getNumberForm.setText(risultato);
                        break;
                    case "Esadecimale":
                        risultato = Integer.toHexString(Integer.parseInt(number));
                        getNumberForm.setText(risultato);
                        break;
                    case "Vigesimale":
                        risultato = Integer.toString(Integer.parseInt(number), 20);
                        getNumberForm.setText(risultato);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Convertitore");
        frame.setContentPane(new Convertitore().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
