package day11.assignment;
import java.util.*;

public class PracticeRemDup {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter string: ");
        String s = sc.next();        
        String ans = "";        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String t = String.valueOf(c);
            
            if(!ans.contains(t)) {
                ans = ans + c;
            }
        }
        
        System.out.println(" without duplicate: " + ans);
        sc.close();
    }
}
