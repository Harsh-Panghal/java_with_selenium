package day6.assignment;
public class PracticeValueOf {
    public static void main(String[] args) {
        String s = "100";
        Integer i = Integer.valueOf(s);
        System.out.println("string convert to integer= " + i);

        int n = 50;
        String s2 = String.valueOf(n);
        System.out.println("integer convert to string= " + s2);
    }
}
