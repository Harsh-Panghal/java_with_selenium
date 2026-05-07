package management.library;
import java.sql.Connection;
import java.sql.Statement;

public class AdminSetup {
    public static void main(String[] args) {
        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            
            // 1. Create admins table
            String createTable = "CREATE TABLE IF NOT EXISTS admins ("
                    + "admin_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "username VARCHAR(50) UNIQUE, "
                    + "password VARCHAR(50)"
                    + ")";
            stmt.executeUpdate(createTable);
            System.out.println("✅ 'admins' table created!");
            
            // 2. Insert a default admin
            String insertAdmin = "INSERT IGNORE INTO admins (username, password) VALUES ('admin', 'admin1234')";
            stmt.executeUpdate(insertAdmin);
            System.out.println("✅ Default admin record inserted! (Username: admin, Password: admin1234)");
            
            stmt.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
