package practice.string;

public class StringBufferMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("Hello!");
		System.out.println(sb);
		sb.append(" Harsh");
		System.out.println(sb);
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		System.out.println(sb.substring(0)); 
//		substring -> continuous part of string...
		System.out.println(sb.charAt(0));
		System.out.println(sb.codePointAt(0));
		System.out.println(sb.insert(7, "buddy "));
//		System.out.println(sb);
		

	}

}
