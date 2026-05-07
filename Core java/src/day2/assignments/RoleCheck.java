package day2.assignments;
import java.util.Scanner;

public class RoleCheck {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("entre role (admin, user, guest) in that formate only");
        String r = sc.next();

        switch (r) {
            case "admin":
                System.out.println("full permission");
                break;
            case "user":
                System.out.println("limited permission..");
                break;
            case "guest":
                System.out.println("Read-only");
                break;
            default:
                System.out.println("Invalid role...");
        }
        sc.close();
	}
}
