package day2.assignments;
import java.util.Scanner;
public class Digit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("enter number");
        int num = sc.nextInt();         
        int cunt = 0;
        
        while (num > 0) {
            num= num / 10;
            cunt++;
        }
        
        System.out.println("total digits " + cunt);
        sc.close();
	}
}
