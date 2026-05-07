package practice.filehandling;
import java.io.*;
public class practice04 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("Text.txt"));
        String l;
        int ch = 0;
        while ((l = br.readLine()) != null) {
            ch += l.length();
        }
        br.close();
        System.out.println("Total Characters: " + ch);
    }

}
