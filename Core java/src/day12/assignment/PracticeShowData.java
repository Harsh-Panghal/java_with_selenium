package day12.assignment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class PracticeShowData {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "hArsh@210192");            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from students");

            while(rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2));
            }
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
