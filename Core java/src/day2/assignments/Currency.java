package day2.assignments;
import java.util.*;
public class Currency {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("enter amount INR ");
        double inr = sc.nextDouble();
        System.out.println("1. USD");
        System.out.println("2. EUR");
        System.out.println("3. GBP");
        System.out.print("your choice (1-3)");
        int ch = sc.nextInt();

        switch (ch) {
            case 1:
                System.out.println(inr + " INR = " + (inr / 83.50) + " USD");
                break;
            case 2:
                System.out.println(inr + " INR = " + (inr / 89.20) + " EUR");
                break;
            case 3:
                System.out.println(inr + " INR = " + (inr / 104.50) + " GBP");
                break;
            default:
                System.out.println("Invalid...");
        }
        sc.close();
	}
}
