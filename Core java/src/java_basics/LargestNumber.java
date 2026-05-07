package java_basics;

public class LargestNumber {

	public static void main(String[] args) {
		int a = 13;
		int b = 12;
		int c = 21;
		
		if(a >= b && a >= c) System.out.println("largest is :" + a);
		else if(b >= c) System.out.println("largest is :" + b);
		else System.out.println("largest is :" + c);

	}

}
