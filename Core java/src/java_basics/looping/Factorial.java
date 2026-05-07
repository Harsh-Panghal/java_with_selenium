package java_basics.looping;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter a number");
		int n = sc.nextInt();
		
		int ans = 1;
		
		while(n > 0) {
			ans *= n;
			n--;
		}
		
		System.out.println("Factorial is: " + ans);
		sc.close();

	}

}
