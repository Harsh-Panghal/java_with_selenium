package practicefilehandling01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Creation {

	public static void main(String[] args) throws IOException {
		String path = "src/practicefilehandling01/test.txt";
		File file = new File(path);
		
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Hello world, how are you!");
		bw.close();
		fw.close();
		System.out.println("done");

	}

}
