package day12.assignment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PracticeInsertData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Name: ");
        String name = sc.next();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "hArsh@210192");
            
            PreparedStatement ps = con.prepareStatement("insert into students values(?, ?)");
            ps.setInt(1, id);
            ps.setString(2, name);
            
            int rowAffected = ps.executeUpdate();
            if(rowAffected > 0) {
                System.out.println("Data saved");
            }
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        sc.close();
    }
}
