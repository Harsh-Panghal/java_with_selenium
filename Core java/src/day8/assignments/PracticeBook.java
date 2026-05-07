package day8.assignments;
import java.util.HashMap;
import java.util.Map;

class Book {
    String name;
    
    Book(String n) {
        name = n;
    }
}

public class PracticeBook {
    public static void main(String[] args) {
        Map<Book, Boolean> map = new HashMap<>();        
        Book b1 = new Book("Java Notes");
        Book b2 = new Book("Harry Poter");        
        map.put(b1, true);
        map.put(b2, true);        
        map.put(b1, false);
        
        for(Book b : map.keySet()) {
            boolean status = map.get(b);
            if(status == true) {
                System.out.println(b.name + " available");
            } else {
                System.out.println(b.name + " not available");
            }
        }
    }
}
