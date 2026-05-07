package day2.assignments;
import java.util.Scanner;
public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("enter n terms ");
        int n = sc.nextInt();
        
        int a = 0;
        int b = 1;
        int j = 1;
        
        while (j <= n) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
            
            j++;
        }
        sc.close();
	}
}
