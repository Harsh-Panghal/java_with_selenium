package java_basics;

public class CheckDivisibility {

	public static void main(String[] args) {
		int num = 35;
		
		if((num % 5 == 0) && (num % 11 == 0)) {
			System.out.println("number is divisible with 5 and 11");
		}else  System.out.println("not divisible");

	}

}
