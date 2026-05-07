package day2.assignments;
import java.util.Scanner;

public class Table {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("enter a number ");
        int num = sc.nextInt();        
        int i = 1;
        
        while (i <= 10) {
            System.out.println(num + " x " + i + " = " + (num * i));
            i++;
        }
        sc.close();
	}
}
