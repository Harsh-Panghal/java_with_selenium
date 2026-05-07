package practice.collections;

interface Calc {
    int fun(int a, int b);
}

public class CalculatorUsingLambda {
	public static void main(String[] args) {
	    Calc add = (a, b) -> a + b;

	    Calc sub = (a, b) -> a - b;

	    Calc mul = (a, b) -> a * b;
	    
	    Calc div = (a, b) -> {
            if (b == 0) {
                System.out.println("Cannot divide by zero");
                return 0;
            }
            return a / b;
        };

	    int x = 10, y = 5;

	    System.out.println("add res =  " + add.fun(x, y));
	    System.out.println("sub res =" + sub.fun(x, y));
	    System.out.println("mul res = " + mul.fun(x, y));
	    System.out.println("div res =  " + div.fun(x, y));		
	}
}
