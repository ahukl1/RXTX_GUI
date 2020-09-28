package RXTXPrivate;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class RXTX_Run_Thread implements Runnable {
    public static ArrayList<String> portName = new ArrayList<>();
    public static ArrayList<byte[]> send = null;
    public static ArrayList<byte[]> recive = null;
    public static String open_port = "null";
    public static int Flags = 1;
    public Lable_Thread lable;
    RXTX_Run_Thread(Lable_Thread lable) {
        this.lable=lable;
    }
    int i=0;
    long time=System.currentTimeMillis();
    public void run() {
        while(Flags >= 0) {
                if(!portName.equals(RXTX.findPort())) {
                    portName = RXTX.findPort();
                    //lable.jFrame.remove(lable.comboBoxes.get(0));
                    lable.comboBoxes.get(0).removeAllItems();
                    for (int i = 0; i < portName.size(); i++) {
                        lable.comboBoxes.get(0).addItem(portName.get(i));
                    }
                    //lable.jFrame.add(lable.comboBoxes.get(0));
                }
            this.lable.buttons.get(0).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(System.currentTimeMillis()-time>=3) {
                        time=System.currentTimeMillis();
                        lable.data.get(0).setText(String.valueOf(i++)+' '+String.valueOf(time)+'\n');
                        lable.data.get(0).append(lable.comboBoxes.get(1).getSelectedItem().toString());
                    }
                }
            });

        }

    }
}
