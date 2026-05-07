package day10.assignment;
import java.io.*;

public class CountWordLineChar {

	public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new FileReader("text.txt"));
            String s;
            int l = 0, w = 0, c = 0;

            while ((s = br.readLine()) != null) {
                l++;
                c = c + s.length();
                String arr[] = s.split(" ");
                w = w + arr.length;
            }
            br.close();

            System.out.println("lines = " + l);
            System.out.println("words = " + w);
            System.out.println("Characters= " + c);     
       
	}

}
