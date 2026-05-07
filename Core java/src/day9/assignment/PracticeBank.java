package day9.assignment;
class Account {
    int bal = 1000;

    synchronized void deposit(int amt) {
        bal = bal + amt;
        System.out.println("Deposited: " + amt + ", Bal: " + bal);
    }

    synchronized void withdraw(int amt) {
        if(bal >= amt) {
            bal = bal - amt;
            System.out.println("Withdrawn: " + amt + ", Bal: " + bal);
        } else {
            System.out.println("No balance for: " + amt);
        }
    }
}

public class PracticeBank {
    public static void main(String[] args) {
        Account acc = new Account();

        Thread t1 = new Thread(new Runnable() {
            public void run() { acc.deposit(500); }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() { acc.withdraw(700); }
        });

        Thread t3 = new Thread(new Runnable() {
            public void run() { acc.withdraw(1000); }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
