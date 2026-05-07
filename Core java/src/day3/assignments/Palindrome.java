package day3.assignments;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("size ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        System.out.println("element");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        boolean flag = false;
        int i = 0;
        int j = n-1;
        while(i > j) {
        	if(arr[i] != arr[j]) {
        		flag = true;
        		break;
        	}
        }
        
        if(flag == false) {
            System.out.println("is palindrome");
        } else {
            System.out.println("is notpalindrome");
        }
        sc.close();
    }
}
