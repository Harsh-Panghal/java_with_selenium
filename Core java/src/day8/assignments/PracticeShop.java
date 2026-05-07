package day8.assignments;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeShop {
    public static void main(String[] args) {
        Map<String, Integer> pri = new HashMap<>();
        pri.put("pen", 20);
        pri.put("book", 150);
        pri.put("bag", 800);
        List<String> cart = new ArrayList<>();
        cart.add("pen");
        cart.add("book");
        cart.add("pen");
        int t = 0;
        System.out.println("cart items ");
        
        for(int i = 0; i < cart.size(); i++) {
            String item = cart.get(i);
            int price = pri.get(item);
            System.out.println(item + " : " + price);
            t += price;
        }

        System.out.println("finl bill" + t);
    }
}
