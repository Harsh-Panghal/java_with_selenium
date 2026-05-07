package practice.filehandling;
import java.io.*;

public class practice03 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("Text.txt"));
        String l;
        int w = 0;

        while ((l = br.readLine()) != null) {
            String[] arr = l.trim().split(" ");
            w += arr.length;
        }
        br.close();
        System.out.println("Total Words: " + w);
}
}
