package com.math.operations;
import java.util.Scanner;


interface Calculator{
    void divide(int a, int b);
}
class AbcCalc implements Calculator {
    public void divide(int a, int b) {
        try {
            int res = a / b;
            System.out.println("result =  " + res);
            
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
    }
}
public class PracticeInterfaceException {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        AbcCalc t1 = new AbcCalc();
        
        System.out.print("enter num 1");
        int num1 = sc.nextInt();
        
        System.out.print("enter num 2 ");
        int num2 = sc.nextInt();
        t1.divide(num1, num2);
        
        sc.close();

	}

}
