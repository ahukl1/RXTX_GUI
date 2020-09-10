package RXTXPrivate;


import java.nio.channels.Pipe;

public class testCode {
    public testCode() {
    }

    public static void main(String[] args) throws Exception {
        Lable_Thread a = new Lable_Thread();
        RXTX_Run_Thread r=new RXTX_Run_Thread(a);
        a.ready();
        (new Thread(a)).start();
        (new Thread(r)).start();
    }
}
