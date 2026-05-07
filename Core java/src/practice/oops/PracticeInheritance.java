package practice.oops;
class Grandparent
{
	void openland()
	{
		System.out.println("Openland for commercial use");
	}
}
class Parent1 extends Grandparent
{
	void flat()
	{
		System.out.println("2BHK");
	}
	void car()
	{
		System.out.println("BAleno Petrol car");
	}
}
class Parent2 extends Grandparent
{
	void flat()
	{
		System.out.println("2BHK");
	}
	void car()
	{
		System.out.println("BAleno Petrol car");
	}
}
class Childp1 extends Parent1
{
	void bike()
	{
		System.out.println("Pulsar");
	}
}
class Child1p2 extends Parent2
{
	void bike()
	{
		System.out.println("Pulsar");
	}
}
 
public class PracticeInheritance {
	
 
	public static void main(String[] args) {
		Childp1 mohan=new Childp1();
		mohan.flat();// self
		mohan.car();// parent
		mohan.bike();// parent
		mohan.openland();// grandparent
		
		
		
	}
 
}
// Single inheritance= parent-->Child
//Multilevel inheritance= GrandParent-->Parent--> Child-->SubChild.......
// Hierarchical inheritance=Parent-->Child1-->Subchild1
//                                         -->Subchild2
//                               -->Child2
//                                -->Child3
 
