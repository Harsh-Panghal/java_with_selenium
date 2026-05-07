package practice.packages;

import java.util.Scanner;
 
public class PracticeException {
 
	public static void main(String[] args) {
//		String str="Hello";
//		System.out.println(1);
//		System.out.println(1);
//		System.out.println(1);
//		//System.out.println(1/0);
//		try {
//			System.out.println(1/0);
//		}
//		catch(Exception e)
//		{
//			System.out.println(e);
//		}
//		System.out.println(1);
//		System.out.println(1);
//		System.out.println(1);
//		//System.out.println(2/0);// infinity
//		//File file="C:\\Users\\dell\\Desktop\\SDET April B3 -";//
//		Test t=new Test();// declaration and initialization of an object
//		Test t1;// declaration
//		t1=new Test();// initialization of an object
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter any number");//120
		int a=sc.nextInt();
		int b=88;
		try {
		int c=b/a;
		System.out.println("Division ="+ c);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		System.out.println("End");
		
		
 
	}
 
}