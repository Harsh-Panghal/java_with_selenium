package practice.filehandling;
import java.io.*;
//combine two files

public class practice07 {
	public static void main(String[] args) throws Exception {
        BufferedReader br1 = new BufferedReader(new FileReader("Text.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("Text1.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("Merge.txt"));
        String l;

        while ((l = br1.readLine()) != null) {
            bw.write(l);
            bw.newLine();
        }

        while ((l = br2.readLine()) != null) {
            bw.write(l);
            bw.newLine();
        }

        br1.close();
        br2.close();
        bw.close();
    }
}
