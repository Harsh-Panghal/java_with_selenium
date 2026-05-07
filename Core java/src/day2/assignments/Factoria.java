package day2.assignments;
import java.util.Scanner;
public class Factoria {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("enter num ");
        int num = sc.nextInt();        
        int f = 1;
        int i = 1;
        
        while (i <= num) {
            f = f* i;
            i++;
        }
        
        System.out.println("Factorial is" + f);
        sc.close();
	}
}
