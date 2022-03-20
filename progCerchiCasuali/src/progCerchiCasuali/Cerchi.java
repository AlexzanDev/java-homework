package progCerchiCasuali;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cerchi {
    private JPanel panelCerchi;
    private JPanel panelMain;
    private JTextField textScelta;
    private JTextField textCerchi;
    private JTextField textRaggio;
    private JComboBox<String> comboBoxColors;
    private JButton cancellaButton;
    private JButton creaButton;
    private JButton esciButton;

    public Cerchi() {
        // Init components
        comboBoxColors.addItem("Rosso");
        comboBoxColors.addItem("Giallo");
        comboBoxColors.addItem("Verde");
        comboBoxColors.addItem("Casuale");
        // Action listeners
        cancellaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear panel
                panelCerchi.removeAll();
                panelCerchi.repaint();
            }
        });
        creaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Init panel's graphics
                Graphics g = panelCerchi.getGraphics();
                int gWidth = panelCerchi.getWidth();
                int gHeight = panelCerchi.getHeight();
                // Get items
                int nCerchi = (Integer.parseInt(textCerchi.getText()));
                int raggio = (Integer.parseInt(textRaggio.getText()));
                String colore = (String.valueOf(comboBoxColors.getSelectedItem()));
                Color coloreSet = null;
                switch (colore) {
                    case "Rosso":
                        coloreSet = Color.RED;
                        colore = "Rosso";
                        break;
                    case "Giallo":
                        coloreSet = Color.YELLOW;
                        colore = "Giallo";
                        break;
                    case "Verde":
                        coloreSet = Color.GREEN;
                        colore = "Verde";
                        break;
                    case "Casuale":
                        double tmpNum = Math.random() * 3;
                        switch ((int) tmpNum) {
                            case 0:
                                coloreSet = Color.RED;
                                colore = "Rosso";
                                break;
                            case 1:
                                coloreSet = Color.YELLOW;
                                colore = "Giallo";
                                break;
                            case 2:
                                coloreSet = Color.GREEN;
                                colore = "Verde";
                                break;
                        }
                }
                textScelta.setText(colore);
                for(int i=0;i<nCerchi;i++) {
                    int xCerchio = (int) (Math.random() * (gWidth - raggio));
                    int yCerchio = (int) (Math.random() * (gHeight - raggio));
                    g.setColor(coloreSet);
                    g.drawOval(xCerchio, yCerchio, raggio, raggio);
                }
            }
        });
        esciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cerchi");
        frame.setContentPane(new Cerchi().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
