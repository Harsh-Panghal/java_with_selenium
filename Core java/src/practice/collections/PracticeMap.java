package practice.collections;
//elements store on the basis of Key
//does not follow insertion order
//single null allowed
//duplicate not allowed

import java.util.*;

public class PracticeMap {

	public static void main(String[] args) {
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("One", 1);
		map.put("Ten", 10);
		map.put("Nine", 9);
		map.put("Two", 2);
		map.put("Three", 3);
		map.put("Three", 8);
		map.put("Other", 10);
		map.put(null,null);
		map.put(null, 3);
		System.out.println(map);
		System.out.println(map.containsKey("nine"));
		System.out.println(map.containsValue(9));
		map.replace("Other", 10, 11);
		map.replace("Nine",90);
		System.out.println(map);
		System.out.println(map.get("Nine"));
		System.out.println();

	}

}
