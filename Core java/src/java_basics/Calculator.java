package java_basics;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        System.out.print("Enter operator (+, -, *, /): ");
        char oper = sc.next().charAt(0);

        switch(oper) {
            case '+'->
                System.out.println("Result: " + (num1 + num2));
            case '-'->
                System.out.println("Result: " + (num1 - num2));
            case '*'->
                System.out.println("Result: " + (num1 * num2));
            case '/'->{
                if(num2 != 0) {
                    System.out.println("Result: " + (num1 / num2));
                }else {
                    System.out.println("Division by zero not allowed");
                }
            } 
            default->
                System.out.println("Invalid operator -_-");
        }

        sc.close();

	}

}
