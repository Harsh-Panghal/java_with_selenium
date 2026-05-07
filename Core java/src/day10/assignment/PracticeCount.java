package day10.assignment;
import java.io.*;

public class PracticeCount {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("text1.txt"));
        String s;
        int c = 0;
        while ((s = br.readLine()) != null) {
            String arr[] = s.split(" ");            
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equals("java")) {
                    c++;
                }
            }
        }
        br.close();

        System.out.println("java count = " + c);

	}

}
