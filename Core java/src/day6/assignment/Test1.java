package day6.assignment;
public class Test1 {
    
    public static void change(int x) {
        x = 50;
    }

    public static void main(String[] args) {
        int a = 10;
        System.out.println("before = " + a);
        change(a);
        System.out.println("after = " + a);
    }
}
