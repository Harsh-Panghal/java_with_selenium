package practice.filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
public class BufReader {
 
	public static void main(String[] args) throws IOException {
		// create file
		File f1=new File("Text.txt");
		f1.createNewFile();
//		// write file
//		BufferedWriter bw=new BufferedWriter(new FileWriter("Text.txt"));
//		bw.write("Hello Welcome to javaLearning ");
//		bw.close();
//		//read file
//		BufferedReader br=new BufferedReader(new FileReader("Text.txt"));
//        String l1;
//        while((l1=br.readLine())!=null)
//        {
//        	System.out.println(l1);
//        }
//        br.close();
		
		 BufferedWriter bw = new BufferedWriter(new FileWriter("Text.txt"));
	        bw.write("hey you want to learn python course. then tell me why python not java. \nokh, hey welcome in python batch is easy (-_-).");
	        bw.close();

	        BufferedReader br = new BufferedReader(new FileReader("Text.txt"));
	        String l2;
	        StringBuilder update = new StringBuilder();

	        while ((l2 = br.readLine()) != null) {
	            l2= l2.replace("python", "java");
	            update.append(l2 + "\n");
	        }
	        br.close();

	        BufferedWriter bw2 = new BufferedWriter(new FileWriter("Text.txt"));
	        bw2.write(update.toString());
	        bw2.close();

	        BufferedReader br2 = new BufferedReader(new FileReader("Text.txt"));
	        while ((l2 = br2.readLine()) != null) {
	            System.out.println(l2);
	        }
	        br2.close();
	}
 
}
// Write a program to replace words(Python==>JAva)
