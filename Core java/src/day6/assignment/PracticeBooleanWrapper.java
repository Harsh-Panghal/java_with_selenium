package day6.assignment;
public class PracticeBooleanWrapper {
    public static void main(String[] args) {
        Boolean b1 = Boolean.valueOf(true);
        Boolean b2 = Boolean.valueOf("false");
        
        System.out.println(b1);
        System.out.println(b2);
        boolean ans = b1.booleanValue();
        System.out.println("Unboxed: " + ans);
    }
}
