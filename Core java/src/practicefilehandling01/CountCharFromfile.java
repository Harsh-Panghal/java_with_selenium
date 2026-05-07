package practicefilehandling01;
import java.io.*;

public class CountCharFromfile {

	public static void main(String[] args) throws IOException {
        File file = new File("src/practicefilehandling01/test.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		int c;
		int countWords = 0;
		while((c = br.read()) != -1) {
			countWords++;
		}
		
		br.close();
		System.out.println("char countis: " + countWords);

	}

}
