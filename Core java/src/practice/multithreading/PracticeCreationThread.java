package practice.multithreading;

public class PracticeCreationThread {
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.start();
		
		for(int i = 51; i <=100; i++) {
			System.out.println(i + " " + Thread.currentThread().getName());
		}
		
	}
}

class MyThread extends Thread{
	@Override
	public void run() {
		for(int i = 1; i <= 50; i++) {
			System.out.println(i + " " + Thread.currentThread().getName());
		}
	}
}
