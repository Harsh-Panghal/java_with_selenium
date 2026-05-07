package day9.assignment;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Order implements Runnable {
    int id;    
    Order(int id) { 
        this.id = id; 
    }
    public void run() {
        System.out.println("agent assign " + id);
        try {
            Thread.sleep(1000);
        } catch(Exception e) {}
        System.out.println("order " + id + " delivered");
    }
}

public class PracticeFood {
    public static void main(String[] args) {
        ExecutorService p = Executors.newFixedThreadPool(3);

        for(int i = 1; i <= 6; i++) {
            Order o = new Order(i);
            p.execute(o);
        }

        p.shutdown();
    }
}
