package practice.filehandling;
import java.io.*;

public class practice01 {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new FileReader("Text.txt"));
	        int cnt = 0;
	        while (br.readLine() != null) {
	            cnt++;
	        }
	        br.close();
	        System.out.println("total lines = " + cnt);
	    }

}
