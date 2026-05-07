package com.math.operations;
import java.util.Scanner;

public class AddSubtraction {
	public void add(int a, int b) {
        int sum = a + b;
        System.out.println("sum = " + sum);
    }

    public void subtract(int a, int b) {
        int diff = a - b;
        System.out.println("subtraction = " + diff);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddSubtraction obj1 = new AddSubtraction();
        
        System.out.print("enter num 1 ");
        int n1 = sc.nextInt();        
        System.out.print("enter num 2 ");
        int n2 = sc.nextInt();
        obj1.add(n1, n2);
        obj1.subtract(n1, n2);
        
        sc.close();
    }

}
