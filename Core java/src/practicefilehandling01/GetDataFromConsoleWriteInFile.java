package practicefilehandling01;
import java.io.*;
import java.util.*;

public class GetDataFromConsoleWriteInFile {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		String path = "src/practicefilehandling01/dataFromConsole.txt";
		File file = new File(path);
		
//		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		//if we want to preserve prev data of file and want to append new data then we pass true..
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
		System.out.println("Enter your data that you want to append in a file : " + file.getName());
		String s = sc.nextLine();
		
		bw.write(s);
		bw.close();
		sc.close();		

	}

}
