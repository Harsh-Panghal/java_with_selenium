package day2.assignments;
import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("enter number");
        int num = sc.nextInt();
        
        int oriNum = num;
        int rev = 0;
        
        while (num > 0) {
            int d = num % 10;
            rev = (rev * 10) + d;
            num = num / 10;
        }
        
        if (oriNum == rev) {
            System.out.println(oriNum + " is Palindrome");
        } else {
            System.out.println(oriNum + " is NOT Palindrome");
        }
        sc.close();
	}
}
