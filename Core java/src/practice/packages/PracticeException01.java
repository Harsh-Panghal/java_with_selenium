package practice.packages;

import java.util.Scanner;
 
public class PracticeException01 {
	// throw =is used to create an exception
	// throws = is used to declare exception
	//try -catch = is used to handle an exception
 
	public static void main(String[] args) throws InterruptedException   {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter divident");//120
		int a=sc.nextInt();
		System.out.println("Enter divisor");//120
		int b=sc.nextInt();
	    Thread.sleep(100);
		try
		{
			int c=a/b;//10/0
			System.out.println("Division is="+c);
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			System.out.println("pass the level");
		}
System.out.println("End");
	}
 
}
