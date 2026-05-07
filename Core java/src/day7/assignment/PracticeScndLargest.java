package day7.assignment;
import java.util.ArrayList;
import java.util.List;

public class PracticeScndLargest {
    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        li.add(10);
        li.add(50);
        li.add(20);
        li.add(40);
        li.add(30);

        int max = li.get(0);
        int scndMax = li.get(0);

        for(int i = 0; i < li.size(); i++) {
            int x = li.get(i);
            if(x > max) {
                scndMax = max;
                max = x;
            } else if(x > scndMax && x != max) {
                scndMax = x;
            }
        }
        
        System.out.println("scnd large ele = " + scndMax);
    }
}
