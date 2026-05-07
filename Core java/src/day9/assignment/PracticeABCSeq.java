package day9.assignment;
class PrintABC {
    int state = 1;

    synchronized void printA() {
        while(state != 1) {
            try { wait(); } catch(Exception e) {}
        }
        System.out.print("A ");
        state = 2;
        notifyAll();
    }

    synchronized void printB() {
        while(state != 2) {
            try { wait(); } catch(Exception e) {}
        }
        System.out.print("B ");
        state = 3;
        notifyAll();
    }

    synchronized void printC() {
        while(state != 3) {
            try { wait(); } catch(Exception e) {}
        }
        System.out.print("C ");
        state = 1;
        notifyAll();
    }
}

public class PracticeABCSeq {
    public static void main(String[] args) {
        PrintABC p = new PrintABC();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 5; i++) p.printA();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 5; i++) p.printB();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 5; i++) p.printC();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
