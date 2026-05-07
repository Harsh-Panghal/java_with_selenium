package management.library;

import java.sql.*;
import java.util.Scanner;

public class BookService {

    // 1. Add New Book Method
    public static void addBook(Scanner sc) {
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();        
        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();
        
        // Default status 'Available'..
        String query = "INSERT INTO books (title, author) VALUES (?, ?)";
        
        try {
        	Connection con = DBConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Success: '" + title + "' added to the library.");
            }
            
            pstmt.close();
            con.close();
            
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }

    // 2. View All Books Method
    public static void viewBooks() {
        String query = "SELECT * FROM books";
        
        try {
        	Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            System.out.println("\n--- 📚 Library Book List ---");
            System.out.println("ID\tTitle\t\t\tAuthor\t\t\tStatus");
            System.out.println("-------------------------------------------------------------------------");
            boolean hasBooks = false;
            
            while (rs.next()) {
                hasBooks = true;
                int id = rs.getInt("book_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String status = rs.getString("status");
                
                System.out.println(id + "\t" + title + "\t\t" + author + "\t\t" + status);
            }
            
            if (!hasBooks) {
                System.out.println("Koi books nahi hain library mein! Pehle kuch add karo.");
            }
            
            System.out.println("-------------------------------------------------------------------------\n");
            
            rs.close();
            stmt.close();
            con.close();
            
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}
