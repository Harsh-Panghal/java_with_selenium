package day3.assignments;
import java.util.Scanner;

public class RowMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = 3;
        int c = 4;
        
        int arr[][] = new int[r][c];
        
        System.out.println("elements:");
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("max elements in row:");
        for(int i = 0; i < r; i++) {
            int max = arr[i][0];
            for(int j = 1; j < c; j++) {
                if(arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
            System.out.println("row" + i + " max =" + max);
        }
        sc.close();
    }
}
