package day6.assignment;
public class PracticeNull {
    public static void main(String[] args) {
        Integer ob = null;
        System.out.println("Wrapper is: " + ob);
        
        try {
            int x = ob;
            System.out.println(x);
        } catch(Exception e) {
            System.out.println("exception occur " + e);
        }
    }
}
