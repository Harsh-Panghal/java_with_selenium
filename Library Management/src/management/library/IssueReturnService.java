package management.library;

import java.sql.*;
import java.util.Scanner;

public class IssueReturnService {

    public static void issueBook(Scanner sc) {
        System.out.print("Enter Book ID to Issue: ");
        int bookId = sc.nextInt();
        
        System.out.print("Enter Member ID who is borrowing: ");
        int memberId = sc.nextInt();
        
        // 
        String query = "UPDATE books SET status = 'Issued', issued_to = ? WHERE book_id = ? AND status = 'Available'";
        
        try {
        	Connection con = DBConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            
            pstmt.setInt(1, memberId);
            pstmt.setInt(2, bookId);
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("✅ Success: Book ID " + bookId + " has been issued to Member ID " + memberId);
            } else {
                System.out.println("❌ Failed: Either the Book ID is wrong, or the book is already issued to someone else.");
            }
            
            pstmt.close();
            con.close();
            
        } catch (SQLException e) {
            System.out.println("❌ Database Error: Please check if Member ID exists. Details: " + e.getMessage());
        }
    }

    public static void returnBook(Scanner sc) {
        System.out.print("Enter Book ID to Return: ");
        String input = sc.nextLine();
        int bookId = 0;
        
        try {
            bookId = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input! Kripya sirf number enter karein.");
            return; 
        }
        
        try {
            Connection con = DBConnection.getConnection();
            
            String checkQuery = "SELECT issued_to FROM books WHERE book_id = ? AND status = 'Issued'";
            PreparedStatement checkStmt = con.prepareStatement(checkQuery);
            checkStmt.setInt(1, bookId);
            ResultSet rs = checkStmt.executeQuery();
            
            if (rs.next()) {
                int memberId = rs.getInt("issued_to");
                
                System.out.println("Book Found! Member ID " + memberId + " is returning it.");
                System.out.println("How is the condition of the book?");
                System.out.println("1. Good (No Fine)");
                System.out.println("2. Bad / Damaged (Apply Fine)");
                System.out.print("Choose condition (1/2): ");
                
                String conditionInput = sc.nextLine();
                
                if (conditionInput.equals("2")) {
                    System.out.print("Enter Fine Amount (in Rs): ");
                    int fine = Integer.parseInt(sc.nextLine()); 
                    String fineQuery = "UPDATE members SET total_fine = total_fine + ? WHERE member_id = ?";
                    PreparedStatement fineStmt = con.prepareStatement(fineQuery);
                    fineStmt.setInt(1, fine);
                    fineStmt.setInt(2, memberId);
                    fineStmt.executeUpdate();
                    System.out.println("⚠️ Rs " + fine + " fine has been added to Member ID " + memberId + "'s account.");
                    fineStmt.close();
                } else if (!conditionInput.equals("1")) {
                    System.out.println("❌ Invalid condition choice. Assuming 'Good' (No Fine).");
                }
                
                String returnQuery = "UPDATE books SET status = 'Available', issued_to = NULL WHERE book_id = ?";
                PreparedStatement returnStmt = con.prepareStatement(returnQuery);
                returnStmt.setInt(1, bookId);
                returnStmt.executeUpdate();
                
                System.out.println("✅ Success: Book ID " + bookId + " has been returned to the library successfully!");
                
                returnStmt.close();
                
            } else {
                System.out.println("❌ Failed: Either the Book ID is wrong, or the book is not currently issued.");
            }
            
            rs.close();
            checkStmt.close();
            con.close();
            
        } catch (SQLException e) {
            System.out.println("❌ Database Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid number entered for fine.");
        }
    }
}