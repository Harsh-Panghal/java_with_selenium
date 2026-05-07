package management.library;

import java.sql.*;
import java.util.Scanner;

public class MemberService {

    public static void registerMember(Scanner sc) {
        System.out.print("Enter Member Name: ");
        String name = sc.nextLine();        
        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();
        
        String query = "INSERT INTO members (name, phone) VALUES (?, ?)";
        
        try {
        	Connection con = DBConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);            
            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Success: Member '" + name + "' registered successfully!");
            }
            
            pstmt.close();
            con.close();
            
        } catch (SQLException e) {
            System.out.println("❌ Database Error: " + e.getMessage());
        }
    }

    public static void viewMembers() {
        String query = "SELECT * FROM members";
        
        try {
        	Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            System.out.println("\n--- 👥 Registered Members ---");
           
            System.out.println("ID\tName\t\tPhone\t\tTotal Fine"); 
            System.out.println("-------------------------------------------------------------");
            
            boolean hasMembers = false;
            while (rs.next()) {
                hasMembers = true;
                int fine = rs.getInt("total_fine"); 
                
                System.out.println(rs.getInt("member_id") + "\t" + 
                                   rs.getString("name") + "\t\t" + 
                                   rs.getString("phone") + "\t" +
                                   "Rs. " + fine);
            }
            
            if (!hasMembers) {
                System.out.println("Koi members register nahi hue hain abhi.");
            }
            System.out.println("-------------------------------------------------------------\n");
            
            rs.close();
            stmt.close();
            con.close();
            
        } catch (SQLException e) {
            System.out.println("❌ Database Error: " + e.getMessage());
        }
    }
}