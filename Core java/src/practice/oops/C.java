package practice.oops;
import practice.accessmodifiers.A;

public class C extends A{
	void print() {
		System.out.println(val4);
		System.out.println(val3);
//		System.out.println(val2);
	}
	public static void main(String[] args) {
		A obj = new A();
		System.out.println(obj.val4);//across package only public accessible
//		System.out.println(val3);
	}

}
