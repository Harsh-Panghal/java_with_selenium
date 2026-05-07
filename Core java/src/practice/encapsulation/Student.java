package practice.encapsulation;

public class Student {
	private String name;
	private int rollNumber;
	private String address;
	
	Student(String name, int rollNumber, String address){
		this.name = name;
		this.rollNumber = rollNumber;
		this.address = address;
	}
	
	public void displayInfo() {
		System.out.println("student name: "+ name +" rollnumber " + rollNumber + " address: " + address );
	}
		

}
