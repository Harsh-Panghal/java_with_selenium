package practice.string;

public class ConvertMutableToImmAndViceVersa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//immutable
		String str = "Harsh";
		System.out.println(str);
		
//		immutable to mutable
		
		StringBuffer sb = new StringBuffer(str);
		System.out.println(sb);
		
//		mutable to immutable
		String str1 = new String(sb);
		System.out.println(str1);
		
//		stringbuffer works on synchronisation so it take more time as compare to builder.
//		synchronisation means execute tasks in a specific order..
		

	}

}
