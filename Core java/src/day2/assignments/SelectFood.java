package day2.assignments;
import java.util.Scanner;
public class SelectFood {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("menu...");
        System.out.println("1. chapp-roll");
        System.out.println("2. burger");
        System.out.println("3. chilli-patato");
        System.out.println("4. matar-panner");
        System.out.print("enter the item number ");
        
        int it = sc.nextInt();

        switch (it) {
            case 1:
                System.out.println("selected chapp-roll. Price:299");
                break;
            case 2:
                System.out.println("selected burger. Price:149");
                break;
            case 3:
                System.out.println("selected Pasta. Price 199");
                break;
            case 4:
                System.out.println("selected Sandwich. Price: 99");
                break;
            default:
                System.out.println("Invalid selection...");
        }
        sc.close();
    }

}
