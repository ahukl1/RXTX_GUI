package RXTXPrivate;


import java.nio.channels.Pipe;

public class testCode {
    public testCode() {
    }

    public static void main(String[] args) throws Exception {
        Lable_Thread a = new Lable_Thread();
        Pipe pipe=Pipe.open();
        a.ready();
        (new Thread(a)).start();
    }
}
