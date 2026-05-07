package java_basics;

public class Employee {
	//instance/global variables -> have a default value as well. 
	int id, age;
	String employeeName = "Harsh";
	double salary;
	static String companyName = "Wipro";
	
	//local variables -> you have to initialise them otherwise you see a complier error... 
    void department(int departmentId, String departmentName) {
    	System.out.println("--------department info----------");
    	System.out.println("employee name: " + employeeName);
    	System.out.println("department id: " + departmentId);
    	System.out.println("department name: " + departmentName);
    	
    }
    void team(int teamId, String teamName) {
    	System.out.println("--------team info----------");
    	System.out.println("employee name: " + employeeName);
    	System.out.println("team id: " + teamId);
    	System.out.println("department name: " + teamName);
    }
    
    void printEmployeeInfo() {
    	System.out.println("--------employee info----------");
    	System.out.println("EmployeeName :" + employeeName + "\ncompany name:" + companyName);
    }

	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.department(101, "CSE");
		e1.team(101, "Lions");
		e1.printEmployeeInfo();

	}

}
