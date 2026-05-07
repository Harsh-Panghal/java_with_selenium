package day1.assignments;
import java.util.Scanner;

public class LoanEligibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        System.out.print("Enter your monthly salary: ");
        double salary = sc.nextInt();
        
        if (age >= 21 && salary >= 25000.00) {
            System.out.println("Congratulations! You are eligible for the loan.");
        } else {
            System.out.println("Sorry, you do not meet the eligibility criteria for the loan.");
        }
        sc.close();
    }
}