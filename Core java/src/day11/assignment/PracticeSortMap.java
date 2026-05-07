package day11.assignment;
import java.util.*;

public class PracticeSortMap {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
        map.put(50, "Harsh");
        map.put(10, "anu");
        map.put(40, "Neha");
        map.put(20, "Pooja");
        
        System.out.println("before sorting:");
        System.out.println(map);        
        TreeMap<Integer, String> tm = new TreeMap<>(map);
        
        System.out.println("After sorting by keys:");
        System.out.println(tm);

	}

}
