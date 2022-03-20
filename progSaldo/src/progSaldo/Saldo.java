package progSaldo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Saldo {
    private JPanel panelSaldo;
    private JTextField nomeField1;
    private JTextField saldoField1;
    private JTextField nomeField2;
    private JTextField saldoField3;
    private JTextField nomeField3;
    private JTextField saldoField2;
    private JButton visualizzaButton;
    private JButton salvaButton;
    private JTextArea textArea1;
    Persona[] utenti = new Persona[3];
    utenti[0] = new Persona();
    utenti[1] = new Persona();
    utenti[2] = new Persona();

    void saveUsers() {
        String n1 = nomeField1.getText();
        String n2 = nomeField2.getText();
        String n3 = nomeField3.getText();
        int s1 = Integer.parseInt(saldoField1.getText());
        int s2 = Integer.parseInt(saldoField2.getText());
        int s3 = Integer.parseInt(saldoField3.getText());
        utenti[0].setNome(n1);
        utenti[0].setSaldo(s1);
        utenti[1].setNome(n2);
        utenti[1].setSaldo(s2);
        utenti[2].setNome(n3);
        utenti[2].setSaldo(s3);
    }

    void showUsers() {
        textArea1.setText(utenti[0].getNome() + utenti[1].getNome() + utenti[2].getNome());
    }

    public Saldo() {
        salvaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveUsers();
            }
        });
        visualizzaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showUsers();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Saldo");
        frame.setContentPane(new Saldo().panelSaldo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
