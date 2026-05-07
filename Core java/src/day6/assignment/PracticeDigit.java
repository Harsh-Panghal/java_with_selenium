package day6.assignment;
import java.util.Scanner;

public class PracticeDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("entrer a char");
        char c = sc.next().charAt(0);

        if(c >= '0' && c <= '9') {
            System.out.println("digit");
        } else {
            System.out.println("Not digit");
        }
        sc.close();
    }
}
