package practice.filehandling;
import java.io.*;

public class practice06 {
	 public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new FileReader("Text.txt"));
	        String li;
	        String maxi = "";

	        while ((li = br.readLine()) != null) {
	            String[] words = li.split("\\s+");
	            for (String w : words) {
	                if (w.length() > maxi.length()) {
	                    maxi = w;
	                }
	            }
	        }

	        br.close();
	        System.out.println("Largest Word: " + maxi);
	    }
}
