package RXTXPrivate;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEventListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;

public class RXTX {
    public RXTX() {
    }

    public static ArrayList<String> findPort() {
        Enumeration<CommPortIdentifier> portlist = CommPortIdentifier.getPortIdentifiers();
        ArrayList portNameList = new ArrayList();

        while(portlist.hasMoreElements()) {
            String portName = ((CommPortIdentifier)portlist.nextElement()).getName();
            portNameList.add(portName);
        }

        return portNameList;
    }

    public static final SerialPort openPort(String portName, int baudrate) {
        SerialPort serialPort = null;

        try {
            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
            CommPort commPort = portIdentifier.open(portName, 2000);
            if (commPort instanceof SerialPort) {
                serialPort = (SerialPort)commPort;

                try {
                    serialPort.setSerialPortParams(baudrate, 8, 1, 0);
                } catch (Exception var6) {
                    serialPort = null;
                }

                System.out.println("open" + portName + "successfully!");
            } else {
                serialPort = null;
            }
        } catch (Exception var7) {
            serialPort = null;
        }

        return serialPort;
    }

    public void sendToPort(SerialPort serialPort, byte[] order) {
        try {
            OutputStream out = serialPort.getOutputStream();
            out.write(order);
            out.flush();
            out.close();
        } catch (Exception var4) {
        }

    }

    public byte[] readFromPort(InputStream inStream) {
        byte[] bytes = null;

        try {
            while(true) {
                int bufflength = inStream.available();
                if (0 == bufflength) {
                    break;
                }

                bytes = new byte[bufflength];
                inStream.read(bytes);
            }
        } catch (Exception var4) {
        }

        return bytes;
    }

    public void addListener(SerialPort port, SerialPortEventListener listener) {
        try {
            port.addEventListener(listener);
            port.notifyOnDataAvailable(true);
            port.notifyOnBreakInterrupt(true);
        } catch (Exception var4) {
        }

    }

    public static void main(String[] args) {
        ArrayList port = findPort();

    }
}
