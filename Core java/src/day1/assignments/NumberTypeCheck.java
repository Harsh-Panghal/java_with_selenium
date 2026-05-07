package day1.assignments;
import java.util.Scanner;

public class NumberTypeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        if (num == 0) {
            System.out.println("The number is Zero");
        } else if (num > 0) {
            System.out.println("The number is Positive");
        } else {
            System.out.println("The number is Negative");
        }
        sc.close();
    }
}
