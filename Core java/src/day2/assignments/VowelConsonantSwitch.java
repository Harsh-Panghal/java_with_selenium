package day2.assignments;
import java.util.Scanner;

public class VowelConsonantSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter only lowercase alphabet (a-z): ");
        char c = sc.next().charAt(0);

            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.println(c+ " is a vowel.");
                    break;
                default:
                    System.out.println(c + " is a consonant.");
            }
        sc.close();
    }
}
