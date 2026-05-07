package day3.assignments;
import java.util.Scanner;
import java.util.Arrays;

public class RemoveDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("size");
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        System.out.println("elements ");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        //first asc order sorting done
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        } 
        
        int temp[] = new int[n];
        int j = 0;
        
        for(int i = 0; i < n - 1; i++) {
            if(arr[i] != arr[i+1]) {
                temp[j] = arr[i];
                j++;
            }
        }
        temp[j] = arr[n-1];
        
        System.out.print("without duplicate ");
        for(int i = 0; i <= j; i++) {
            System.out.print(temp[i] + " ");
        }
        
        sc.close();
    }
}
