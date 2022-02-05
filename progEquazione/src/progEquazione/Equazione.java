package progEquazione;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Equazione {
    private JPanel panel1;
    private JLabel exTitle;
    private JLabel operazione;
    private JTextField aField;
    private JLabel aText;
    private JTextField bField;
    private JLabel bText;
    private JLabel cText;
    private JTextField cField;
    private JButton solveBtn;
    private JLabel solText;
    private JLabel x1Text;
    private JLabel x2Text;
    private JTextField x1Field;
    private JTextField x2Field;
    private JLabel tipoText;
    private JTextField typeField;

    private Float aValue;
    private Float bValue;
    private Float cValue;
    private Float delta;
    private Double sol1;
    private Double sol2;

    public Equazione() {
        solveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aValue = new Float(aField.getText());
                bValue = new Float(bField.getText());
                cValue = new Float(cField.getText());
                delta = (bValue * bValue) - (4 * (aValue * cValue));

                if(delta == 0) {
                    sol1 = (-bValue - Math.sqrt(bValue * bValue - 4 * aValue * cValue)) / (2 * aValue);
                    sol2 = sol1;
                    x1Field.setText(sol1.toString());
                    x2Field.setText(sol2.toString());
                    typeField.setText("Soluzioni coincidenti.");
                }
                if(delta > 0) {
                    sol1 = (-bValue - Math.sqrt(bValue * bValue - 4 * aValue * cValue)) / (2 * aValue);
                    sol2 = (-bValue + Math.sqrt(bValue * bValue - 4 * aValue * cValue)) / (2 * aValue);
                    x1Field.setText(sol1.toString());
                    x2Field.setText(sol2.toString());
                    typeField.setText("Soluzioni reali.");
                }
                if(delta < 0) {
                    x1Field.setText("Impossibile.");
                    x2Field.setText("Impossibile.");
                    typeField.setText("Soluzione non reale.");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Equazione");
        frame.setContentPane(new Equazione().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
