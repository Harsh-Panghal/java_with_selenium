package day9.assignment;
class Print {
    int turn = 1;
    synchronized void printOdd(int n) {
        while(turn == 2) {
            try { wait(); } catch(Exception e) {}
        }
        System.out.println("Odd: " + n);
        turn = 2;
        notify();
    }

    synchronized void printEven(int n) {
        while(turn == 1) {
            try { wait(); } catch(Exception e) {}
        }
        System.out.println("Even: " + n);
        turn = 1;
        notify();
    }
}

public class PracticeEvenOdd {
    public static void main(String[] args) {
        Print p = new Print();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for(int i = 1; i <= 100; i += 2) {
                    p.printOdd(i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for(int i = 2; i <= 100; i += 2) {
                    p.printEven(i);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
