package day10.assignment;
import java.io.*;

public class PracticePrintJava {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("text1.txt"));
        String s;

        while ((s = br.readLine()) != null) {
            if (s.contains("java")) {
                System.out.println(s);
            }
        }
        br.close();
	}
}
