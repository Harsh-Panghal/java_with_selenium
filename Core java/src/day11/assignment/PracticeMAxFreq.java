package day11.assignment;
import java.util.*;
public class PracticeMAxFreq {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("enter size: ");
        int n = sc.nextInt();
        int arr[] = new int[n];        
        System.out.println("Enter element:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }        
        int maxEle = arr[0];
        int maxCount = 0;
        
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(arr[i] == arr[j]) {
                    count++;
                }
            }            
            if(count > maxCount) {
                maxCount = count;
                maxEle = arr[i];
            }
        }
        
        System.out.println("element with max freq: " + maxEle);
        sc.close();

	}

}
