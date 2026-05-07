package day6.assignment;
import java.util.Scanner;

public class PracticeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        System.out.print("enter 1st string ");
        String s1 = sc.next();        
        System.out.print("enter 2nd string ");
        String s2 = sc.next();

        if(s1.equals(s2)) {
            System.out.println("Strings are equal");
        } else {
            System.out.println("Strings are not equal");
        }
        sc.close();
    }
}
