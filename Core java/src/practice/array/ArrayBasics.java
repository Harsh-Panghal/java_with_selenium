package practice.array;

import java.util.Scanner;

public class ArrayBasics {

	public static void main(String[] args) {
//		-------------1d------------------
		//Initialisation - 1st way
		/*
		 * int[] arr = {1,2,3,4,5}; //2nd way int[] arr1 = new int[10];
		 * 
		 * System.out.println(arr[4]); arr[4]=6; System.out.println(arr[4]);
		 * 
		 * //iteration for(int i = 0; i < arr.length; i++) { System.out.println(arr[i]);
		 * }
		 */
		
//		-----------------------2d---------------
//		int[][] arr2 = {{1,2,3}, {4,5,6}, {7,8,9,10}};
//		
//		
//		for(int i = 0; i < arr2.length; i++) {
//			for(int j = 0; j < arr2[i].length; j++) {
//				System.out.print(arr2[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		int[][] arr3 = new int[4][]; //row-size is mandatory
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < arr3.length; i++) {
			arr3[i] = new int[i+1];
			int k = 1;
			for(int j = 0; j < arr3[i].length; j++) {
				arr3[i][j] = k;
				k++;
			}
			
		}
		
		for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                System.out.print(arr3[i][j] + " ");
            }
            System.out.println();
        }
		
		sc.close();

	}

}
