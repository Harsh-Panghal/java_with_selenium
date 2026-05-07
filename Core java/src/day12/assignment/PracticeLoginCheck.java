package day12.assignment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PracticeLoginCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String u = sc.next();
        System.out.print("Enter password: ");
        String p = sc.next();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "hArsh@210192");
            
            PreparedStatement ps = con.prepareStatement("select * from users where username=? and password=?");
            ps.setString(1, u);
            ps.setString(2, p);
            
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                System.out.println("Login success");
            } else {
                System.out.println("Login failed");
            }
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        sc.close();
    }
}
