package java_basics;
import java.util.Scanner;

public class SwitchCaseExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		switch(size) {
		case 26 -> System.out.println("XS");
		case 28 -> System.out.println("S");
		case 30 -> System.out.println("M");
		case 32 -> System.out.println("L");
		case 34 -> System.out.println("XL");
		case 36 -> System.out.println("XXL");
		default -> System.out.println("Invalid size");
		
		}
		sc.close();

	}

}
