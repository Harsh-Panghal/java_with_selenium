package day6.assignment;
class Box {
    int len;
}

public class PracticeBox{    
    public static void change(Box a) {
        a.len = 100;
    }

    public static void main(String[] args) {
        Box b = new Box();
        b.len = 20;
        
        System.out.println("before = " + b.len);
        change(b);
        System.out.println("after = " + b.len);
    }
}
