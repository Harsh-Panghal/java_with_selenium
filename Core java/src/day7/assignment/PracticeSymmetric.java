package day7.assignment;
import java.util.HashSet;

public class PracticeSymmetric {
    public static void main(String[] args) {
        HashSet<Integer> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        HashSet<Integer> s2 = new HashSet<>();
        s2.add(3);
        s2.add(4);
        s2.add(5);
        HashSet<Integer> ans = new HashSet<>();
        for(int x : s1) {
            if(!s2.contains(x)) {
                ans.add(x);
            }
        }
        for(int x : s2) {
            if(!s1.contains(x)) {
                ans.add(x);
            }
        }

        System.out.println("difference is= " + ans);
    }
}
