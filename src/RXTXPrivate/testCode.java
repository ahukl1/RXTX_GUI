package RXTXPrivate;


public class testCode {
    public testCode() {
    }

    public static void main(String[] args) {
        Lable_Thread a = new Lable_Thread();
        a.ready();
        (new Thread(a)).start();
    }
}
