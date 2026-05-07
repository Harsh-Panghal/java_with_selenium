package practicefilehandling01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CountLinesFromFile {

	public static void main(String[] args) throws IOException{
		File file = new File("src/practicefilehandling01/test.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		int c;
		int countLines = 0;
		while((c = br.read()) != -1) {
			if((char)c == '\n') {
				countLines++;
			}
		}
		countLines++;
		br.close();
		System.out.println("Lines in a file : " + countLines);

	}

}
