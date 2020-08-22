package RXTXPrivate;

import java.util.ArrayList;

class RXTX_Run_Thread implements Runnable {
    public static ArrayList<String> portName = null;
    public static ArrayList<byte[]> send = null;
    public static ArrayList<byte[]> recive = null;
    public static String open_port = "null";
    public static int Flags = 1;

    RXTX_Run_Thread() {
    }

    public void run() {
        portName = RXTX.findPort();

        while(Flags >= 0) {
            if (Flags == 2) {
                portName = RXTX.findPort();
            }

            if (!send.isEmpty()) {
            }
        }

    }
}
