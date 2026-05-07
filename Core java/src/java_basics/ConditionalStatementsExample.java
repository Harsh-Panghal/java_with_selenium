package java_basics;

import java.util.Scanner;

public class ConditionalStatementsExample {

	public static void main(String[] args) {
		/*
		 * int age = 13; int weight = 50;
		 */

		/*
		 * if(age > 18) { System.out.println("eligible to enter in a club"); }
		 * System.out.println("Sorry buddy");
		 */

		/*
		 * if(age > 18) { System.out.println("eligible to vote"); }else {
		 * System.out.println("can't "); }
		 */

		/*
		 * if(age > 18 && weight >= 50)
		 * System.out.println("Eligible to blood donation"); else
		 * System.out.println("Not Eligible to blood donation");
		 */

		 Scanner sc = new Scanner(System.in);
		 System.out.println("enter the day");
		  String day = sc.next(); 
		  if(day == "Monday" || day == "Tuesday" || day == "Wednesday" || day == "Thursday" || day == "Friday") System.out.println("Working day!");
		  else System.out.println("day off...");
		 

//		float percentage = 75f;
//		//edge case
//		if(percentage > 100 || percentage < 0) {
//			System.err.println("Invalid output");
//			return; 
//		}
//		
//		if(percentage >= 75) {
//			if(percentage >= 85) {
//				if(percentage >= 95) System.out.println(" dist A++");
//				else System.out.println("dist A+");
//			}else System.out.println("dist");
//			
//		}
//		else if(percentage >= 60 && percentage < 75) System.out.println("first class");
//		else if (percentage >= 50 && percentage < 60) System.out.println("second class");
//		else if (percentage >= 40 && percentage < 50) System.out.println("third class");
//		else System.out.println("fail");
	}

}
