package RXTXPrivate;

import java.awt.Color;
import java.awt.Component;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class Lable_Thread implements Runnable {
    public JFrame jFrame = null;
    public ArrayList<JTextArea> data = new ArrayList();
    public ArrayList<JButton> buttons = new ArrayList();
    public ArrayList<JPanel> panels = new ArrayList();
    public ArrayList<JLabel> labels = new ArrayList();
    public ArrayList<JCheckBox> checkBoxes = new ArrayList();
    public ArrayList<JComboBox> comboBoxes = new ArrayList();

    public Lable_Thread() {
        this.jFrame = new JFrame("RXTX V1.1");
        this.panels.add(new JPanel());
        this.panels.add(new JPanel());
    }

    public void ready() {
        this.jFrame.setSize(600, 600);
        this.jFrame.setLocation(300, 300);
        this.jFrame.setLayout((LayoutManager)null);
        this.jFrame.setBackground(Color.WHITE);
        ((JPanel)this.panels.get(0)).setBounds(0, 0, 600, 350);
        ((JPanel)this.panels.get(1)).setBounds(0, 350, 600, 250);
        ((JPanel)this.panels.get(0)).setBackground(Color.WHITE);
        ((JPanel)this.panels.get(1)).setBackground(Color.LIGHT_GRAY);
        this.jFrame.add((Component)this.panels.get(0));
        this.jFrame.add((Component)this.panels.get(1));
        this.jFrame.setDefaultCloseOperation(3);
        this.jFrame.setVisible(true);
    }

    private void GUI_Flash() {
        ((JPanel)this.panels.get(0)).setBounds(0, 0, this.jFrame.getWidth(), this.jFrame.getHeight() * 7 / 12);
        ((JPanel)this.panels.get(1)).setBounds(0, this.jFrame.getHeight() * 7 / 12, this.jFrame.getWidth(), this.jFrame.getHeight() * 5 / 12);
        this.jFrame.remove((Component)this.panels.get(0));
        this.jFrame.remove((Component)this.panels.get(1));
        this.jFrame.add((Component)this.panels.get(0));
        this.jFrame.add((Component)this.panels.get(1));
    }

    public void run() {
        while(true) {
            if (this.jFrame.getWidth() != ((JPanel)this.panels.get(0)).getWidth() || this.jFrame.getHeight() * 7 / 12 != ((JPanel)this.panels.get(0)).getHeight()) {
                this.GUI_Flash();
            }

            System.out.println(this.jFrame.getSize());
        }
    }
}