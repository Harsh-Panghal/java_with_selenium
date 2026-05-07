package management.library;
import java.util.Scanner;

public class LibraryMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("===================================");
        System.out.println("    LIBRARY MANAGEMENT LOGIN       ");
        System.out.println("===================================");
        System.out.print("Admin Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        if (!LoginService.authenticate(username, password)) {
            System.out.println("Login failed. Exiting...");
            return;
        }

        System.out.println("✅ Login Successful!");

        while (true) {
            System.out.println("\n📚 Library Management Menu");
            System.out.println("1. Add New Book");
            System.out.println("2. View All Books");
            System.out.println("3. Register New Member");
            System.out.println("4. View Members");
            System.out.println("5. Issue Book to Member");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Choose option (1-7): ");
            
            int choice = sc.nextInt();
            sc.nextLine(); 
            
            switch (choice) {
                case 1 -> BookService.addBook(sc);
                case 2 -> BookService.viewBooks();
                case 3 -> MemberService.registerMember(sc);
                case 4 -> MemberService.viewMembers();
                case 5 -> IssueReturnService.issueBook(sc);
                case 6 -> IssueReturnService.returnBook(sc);
                case 7 -> {
                    System.out.println("🔚 Exiting Library System. Goodbye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("❓ Invalid option, please try again.");
            }
        }
    }
}
