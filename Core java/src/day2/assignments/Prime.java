package day2.assignments;
import java.util.Scanner;
public class Prime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("enter number ");
        int num = sc.nextInt();        
        boolean prime = true;
        int i = 2;
        
        while (i <= num / 2) {
            if (num % i == 0) {
                prime = false;
                break;
            }
            i++;
        }            
        if (prime) {
            System.out.println(num + " is prime");
        } else {
            System.out.println(num + " not prime");
        }
        sc.close();
	}
}
