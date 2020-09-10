package RXTXPrivate;

import javax.swing.*;
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

    public void run() {
        while(Flags >= 0) {
                if(!portName.equals(RXTX.findPort())) {
                    portName = RXTX.findPort();
                    lable.jFrame.remove(lable.comboBoxes.get(0));
                    lable.comboBoxes.get(0).removeAllItems();
                    for (int i = 0; i < portName.size(); i++) {
                        lable.comboBoxes.get(0).addItem(portName.get(i));
                    }
                    lable.jFrame.add(lable.comboBoxes.get(0));
                }


        }

    }
}
