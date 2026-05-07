package day2.assignments;
import java.util.Scanner;

public class Grade{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter grade in uppercase only (A, B, C, D, F): ");
        char grade = sc.next().charAt(0);
        switch (grade) {
            case 'A':
                System.out.println("excellent (-_-)");
                break;
            case 'B':
                System.out.println("good job...");
                break;
            case 'C':
                System.out.println("average.");
                break;
            case 'D':
                System.out.println("needs improvement");
                break;
            case 'F':
                System.out.println("fail please try again.(*_*");
                break;
            default:
                System.out.println("Invalid one.");
        }
        sc.close();
    }
}
