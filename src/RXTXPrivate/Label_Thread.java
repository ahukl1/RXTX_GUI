package RXTXPrivate;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

class Lable_Thread implements Runnable {
    public JFrame jFrame = null;
    public ArrayList<JTextArea> data = new ArrayList();
    public ArrayList<JButton> buttons = new ArrayList();
    public ArrayList<JPanel> panels = new ArrayList();
    public ArrayList<JLabel> labels = new ArrayList();
    public ArrayList<JCheckBox> checkBoxes = new ArrayList();
    public ArrayList<JComboBox> comboBoxes = new ArrayList();
    public ArrayList<JScrollPane> jScrollPanes=new ArrayList<>();
    public ArrayList<JTextField> textFields=new ArrayList<>();
    private ArrayList<String> strs=new ArrayList(){{add("串口:");add("波特率：");add("校验位：");add("停止位：");}};
    private int width=600,height=600;
    public Lable_Thread() {
        this.jFrame = new JFrame("RXTX V1.1");
        this.panels.add(new JPanel());
        this.panels.add(new JPanel());
        this.data.add(new JTextArea());
        this.data.add(new JTextArea());
        this.jFrame.setSize(width, height);
    }
    private  void part_1_rm(){
        this.jFrame.remove(this.jScrollPanes.get(0));
        this.jScrollPanes.remove(0);
    }
    private void part_1(){
        this.data.get(0).setLineWrap(true);
        this.data.get(0).setBackground(Color.LIGHT_GRAY);
        this.data.get(0).setBounds(this.width*5/600,this.height*5/600,this.width*390/600,this.height*390/600);
        this.jScrollPanes.add(new JScrollPane(this.data.get(0)));
        this.jScrollPanes.get(0).setBounds(0,0,this.width*400/600,this.height*400/600);
        this.jFrame.add(this.jScrollPanes.get(0));
    }
    private void part_2(){
       for(int i=0;i<this.strs.size();i++){
           this.labels.add(new JLabel(this.strs.get(i)));
           this.textFields.add(new JTextField(""));
       }

    }
    public void ready() {
        this.jFrame.setLayout(null);
        part_1();
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jFrame.setVisible(true);
    }

    private void GUI_Flash() {
        part_1_rm();
        part_1();
    }

    public void run() {
        while(true) {
            if (this.jFrame.getWidth() != this.width || this.jFrame.getHeight()  != this.height) {
                this.width=this.jFrame.getWidth();
                this.height=this.jFrame.getHeight();
                this.GUI_Flash();
            }

            System.out.println(this.jFrame.getSize());
        }
    }
}