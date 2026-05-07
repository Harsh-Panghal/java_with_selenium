package java_basics.looping;

public class PrintPattern02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//       for(int i = 1; i <= 5; i++) {
//    	   for(int j = 1; j <= 5 - i + 1; j++) {
//    		   System.out.print("*");
//    	   }
//    	   System.out.println();
//       }
		
		//mirror image
       for(int i = 1; i <= 5; i++) {
    	   for(int j = 1; j <= i - 1; j++) {
    	        System.out.print(" ");
    	    }
    	    for(int j = 1; j <= 5 - i + 1; j++) {
    	        System.out.print("*");
    	    }
    	   System.out.println();
       }
		
	}

}
