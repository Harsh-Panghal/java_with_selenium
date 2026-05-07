package management.library;
import java.sql.*;

public class Librarydb_Setup {
    public static void main(String[] args) {
        String baseUrl = "jdbc:mysql://localhost:3306/";
        String dbUrl = "jdbc:mysql://localhost:3306/library_db";
        String user = "root";
        String password = "hArsh@210192";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");            
            // 1. Create Database
            Connection baseCon = DriverManager.getConnection(baseUrl, user, password);
            Statement baseStmt = baseCon.createStatement();
            baseStmt.executeUpdate("CREATE DATABASE IF NOT EXISTS library_db");
            System.out.println("✅ Database 'library_db' ready!");
            baseCon.close();            
            // 2. Connect to library_db & Create Tables
            Connection con = DriverManager.getConnection(dbUrl, user, password);
            Statement stmt = con.createStatement();
            
            // Members Table
            String createMembers = "CREATE TABLE IF NOT EXISTS members ("
                    + "member_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "name VARCHAR(50), "
                    + "phone VARCHAR(15)"
                    + ")";
            stmt.executeUpdate(createMembers);
            System.out.println("✅ 'members' table created!");
            
            // Books Table
            String createBooks = "CREATE TABLE IF NOT EXISTS books ("
                    + "book_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "title VARCHAR(100), "
                    + "author VARCHAR(50), "
                    + "status VARCHAR(20) DEFAULT 'Available', "
                    + "issued_to INT DEFAULT NULL, "
                    + "FOREIGN KEY (issued_to) REFERENCES members(member_id)"
                    + ")";
            stmt.executeUpdate(createBooks);
            System.out.println("✅ 'books' table created!");
            
            con.close();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
