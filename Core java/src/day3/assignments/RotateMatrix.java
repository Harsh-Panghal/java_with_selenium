package day3.assignments;
import java.util.Scanner;

public class RotateMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("size of matix ");
        int n = sc.nextInt();
        
        int a[][] = new int[n][n];
        int b[][] = new int[n][n]; 
        
        System.out.println("elements");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int c = n - 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
            	b[j][c] = a[i][j];
            }
            c--;
        }
        
        System.out.println("rotation done");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
