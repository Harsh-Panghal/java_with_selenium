package day2.assignments;
import java.util.Scanner;

public class Armstrong {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("enter number");
        int num = sc.nextInt();        
        int oriNum = num;
        int sum = 0;        
        while (num > 0) {
            int d = num % 10;
            sum = sum + (d * d * d); // Cube of the digit
            num = num / 10;
        }
        
        if (sum == oriNum) {
            System.out.println(oriNum + " armstrong number");
        } else {
            System.out.println(oriNum + "not armstrong number");
        }
        sc.close();
	}
}
