package practice.filehandling;
import java.io.*;

public class practice02 {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new FileReader("Text.txt"));
	        String l;
	        StringBuilder sb = new StringBuilder();
	        while ((l = br.readLine()) != null) {
	            l = l.replaceAll("java", "py");
	            sb.append(l +"\n");
	        }
	        br.close();

	        BufferedWriter bw = new BufferedWriter(new FileWriter("Text.txt"));
	        bw.write(sb.toString());
	        bw.close();
	        
	    }

}
