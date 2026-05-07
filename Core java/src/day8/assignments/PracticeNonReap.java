package day8.assignments;
import java.util.HashMap;
import java.util.Scanner;

public class PracticeNonReap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter string ");
        String s = sc.next();        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }        
        int flag = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.get(c) == 1) {
                System.out.println("first non-repeating " + c);
                flag = 1;
                break;
            }
        }        
        if(flag == 0) {
            System.out.println("no non-repeating char..");
        }
        
        sc.close();
    }
}
