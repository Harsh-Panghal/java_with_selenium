package day2.assignments;
import java.util.Scanner;

public class EvenOddSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter number: ");
        int num = sc.nextInt();
        int rem = num % 2; 

        switch (rem) {
            case 0:
                System.out.println("it is even.");
                break;
            case 1:
                System.out.println("it is odd.");
                break;
            default:
                System.out.println("Invalid input.");
        }
        sc.close();
    }
}
