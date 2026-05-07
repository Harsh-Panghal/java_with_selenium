package day2.assignments;
import java.util.Scanner;

public class ATMOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 5000.00; 
        boolean flag = true;

        System.out.println("welcome to atm (^_^)...");

        while (flag) {
            System.out.println("\n1 -> check balance");
            System.out.println("2 -> deposit");
            System.out.println("3 -> withdraw");
            System.out.println("4 -> exit");
            System.out.print("select option: ");
            
            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    System.out.println("Current balance:" + balance);
                    break;
                case 2:
                    System.out.print("Enter amount ");
                    double amtd = sc.nextDouble();
                    balance += amtd;
                    System.out.println("deposited" + balance);
                    break;
                case 3:
                    System.out.print("amount withdraw:");
                    double amtw = sc.nextDouble();
                    if (amtw <= balance) {
                        balance -= amtw;
                        System.out.println("remaining Balance:" + balance);
                    } else {
                        System.out.println("low balance!");
                    }
                    break;
                case 4:
                    System.out.println("Thank you....");
                    flag = false;
                    break;
                default:
                    System.out.println("please select 1-4.");
            }
        }
        sc.close();
    }
}
