package day11.assignment;
import java.util.*;

public class PracticeFirstNonRepChar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("enter string: ");
        String s = sc.next();        
        int flag = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cunt = 0;            
            for(int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == c) {
                    cunt++;
                }
            }            
            if(cunt == 1) {
                System.out.println("first non-repeating char: " + c);
                flag = 1;
                break;
            }
        }
        
        if(flag == 0) {
            System.out.println("no unique char");
        }
        sc.close();

	}

}
