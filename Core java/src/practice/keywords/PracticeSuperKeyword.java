package practice.keywords;

public class PracticeSuperKeyword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child c1 = new Child("Harsh", "Hapur, U.P.");
		c1.displayInfo();
		c1.greet();

	}

}

class Parent {
	String name;
	String noOfCars;
	String address;
	
	void displayInfo() {
		System.out.println(name + " " + address);
	}
	void greet() {
		System.out.println("Ram Ram");
	}
}

class Child extends Parent{
		Child(String name, String address){
			this.name = name;
			this.address = address;
		}
		
		@Override
		void greet() {
//			super.greet();
			System.out.println("Morning!");
			super.greet();
		}
		
}
