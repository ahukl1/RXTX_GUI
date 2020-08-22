package RXTXPrivate;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

class Listener implements SerialPortEventListener {
    Listener() {
    }

    public void serialEvent(SerialPortEvent var1) {
        if (var1.getEventType() == 1) {
        }

    }
}
