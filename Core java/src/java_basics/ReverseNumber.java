package java_basics;

public class ReverseNumber {

	public static void main(String[] args) {
		int n = 1243;
		int result = 0;
		
		while(n > 0) {
			result = result * 10 + (n % 10);
			n = n / 10;
		}
		System.out.println("reversed number is:" + result);

	}

}
