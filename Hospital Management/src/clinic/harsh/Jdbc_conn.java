package clinic.harsh;
import java.sql.*;
//import packages
//load & register driver
//establish connection
//create statements
//execute query
//process result
//close connection
public class Jdbc_conn {

public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String url="jdbc:mysql://localhost:3306/mydata";
		String user="root";
		String password="hArsh@210192";
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con= DriverManager.getConnection(url,user,password);
		System.out.println("Connection created");
		//create statement
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from Student");
		System.out.println("rollNo\t name\t age\t per");
		while(rs.next()){
		int rollNo=rs.getInt("rollNo");
		String name=rs.getString("name");
		int age=rs.getInt("age");
		int per=rs.getInt("per");
		System.out.println(rollNo+"\t"+ name+"\t"+ age +"\t"+ per);
		//System.out.println("ID:"+id+"\tName:"+ name+"Salary:"+ salary);
		}
		rs.close();
		stmt.close();
		con.close();

		}

}
