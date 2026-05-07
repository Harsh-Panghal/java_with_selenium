package clinic.harsh;
import java.sql.*;

public class AlterTable {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydata";
        String user = "root";
        String password = "hArsh@210192";

        String alterSQL = "ALTER TABLE students ADD total_marks INT";
        String updateSQL = "UPDATE students SET total_marks = 100";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection created successfully.");
            
            Statement stmt = con.createStatement();
//            stmt.executeUpdate(alterSQL);
//            System.out.println("total_marks field added to the students table.");
//            
//            System.out.println("\n--- Table Structure ---");
//            ResultSet rs = stmt.executeQuery("DESCRIBE students");
//            System.out.println("Field\t\tType");
//            System.out.println("---------------------------------");
//            while (rs.next()) {
//                String fieldName = rs.getString("Field");
//                String fieldType = rs.getString("Type");
//                System.out.println(fieldName + "\t\t" + fieldType);
//            }
            
            int rowsAffected = stmt.executeUpdate(updateSQL);
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            System.out.println("RollNo\t Name\t\t Per\t Email\t\t\t Total Marks");
            System.out.println("----------------------------------------------------------------------");
            
            // while loop for fetching all the table records
            while (rs.next()) {
                int rollno = rs.getInt("rollno");
                String name = rs.getString("name");
                int per = rs.getInt("per");
                String email = rs.getString("email");
                int totalMarks = rs.getInt("total_marks"); // Fetching the newly updated column
                
                System.out.println(rollno + "\t " + name + "\t " + per + "\t " + email + "\t\t " + totalMarks);
            }
            
            stmt.close();
            con.close();
            
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Class Not Found: " + e.getMessage());
        }
    }
}
