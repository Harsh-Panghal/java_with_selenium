package practice.keywords;

public class PracticeStatic {
	int empid;
	String employeeName;
	static String companyName;
	
//	for initialising the static fields
	static {
		companyName = "Wipro";
		System.out.println("Intialising static fields done");
	}
	
	void displayInfo() {
		System.out.println("Employee Name: " + employeeName + "\nEmployee id: " + empid+ "\ncompany name: " + companyName);
	}
	
	public PracticeStatic(int empid, String employeeName) {
		this.empid = empid;
		this.employeeName = employeeName;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PracticeStatic emp1 = new PracticeStatic(101, "Harsh");
		emp1.displayInfo();

	}

}
