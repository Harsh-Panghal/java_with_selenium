package practice.filehandling;
import java.io.*;
import java.util.*;

public class practice08 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("Text.txt"));
        ArrayList<String> li = new ArrayList<>();
        String l;
        while ((l = br.readLine()) != null) {
            li.add(l);
        }
        br.close();

        for (int i = li.size() - 1; i >= 0; i--) {
            System.out.println(li.get(i));
        }
    }

}
