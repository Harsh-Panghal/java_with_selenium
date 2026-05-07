package day3.assignments;
import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("array size ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        System.out.println("elements ");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }        
        System.out.print("asc order");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] < arr[j]) { 
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        
        System.out.print("desc order");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }        
        sc.close();
    }
}
