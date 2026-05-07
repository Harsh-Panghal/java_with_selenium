package management.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {

    public static boolean authenticate(String username, String password) {
        String query = "SELECT * FROM admins WHERE username = ? AND password = ?";
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            ResultSet rs = pstmt.executeQuery();
            boolean isValid = rs.next();
            
            rs.close();
            pstmt.close();
            con.close();
            
            return isValid;
            
        } catch (SQLException e) {
            System.out.println("❌ Database Error during login: " + e.getMessage());
            return false;
        }
    }
}