package java_basics.looping;

import java.util.Scanner;

public class SumOfFirstNNaturalNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number: ");
		int n = sc.nextInt();		
		int res = 0;
		while(n > 0) {
			res += n;
			n--;
		}
		System.out.println("Sum of first n natural number is: "+ res);
		sc.close();
		

	}

}
