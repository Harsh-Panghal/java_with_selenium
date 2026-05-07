package practice.filehandling;
import java.io.*;
//copy file
public class practice05 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("Text.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("Text1.txt"));
        String li;
        while ((li = br.readLine()) != null) {
            bw.write(li);
            bw.newLine();
        }
        br.close();
        bw.close();
    }

}
