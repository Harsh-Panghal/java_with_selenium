package day12.assignment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PracticeInsertMulti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "hArsh@210192");
            PreparedStatement ps = con.prepareStatement("insert into students values(?, ?)");

            System.out.print("How many ");
            int n = sc.nextInt();
            for(int i = 0; i < n; i++) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                System.out.print("Enter Name: ");
                String name = sc.next();

                ps.setInt(1, id);
                ps.setString(2, name);
                ps.executeUpdate();
            }
            System.out.println("All records saved");
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        sc.close();
    }
}
