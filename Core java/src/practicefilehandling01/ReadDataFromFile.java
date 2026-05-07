package practicefilehandling01;
import java.io.*;

public class ReadDataFromFile {

	public static void main(String[] args) throws IOException {
		File file = new File("src/practicefilehandling01/test.txt");
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		int c;
		while((c = br.read()) != -1) {
			System.out.print((char)c);
		}
		
		br.close();
		System.out.println("done...");

	}

}
