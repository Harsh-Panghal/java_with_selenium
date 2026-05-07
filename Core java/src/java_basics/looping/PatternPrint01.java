package java_basics.looping;

public class PatternPrint01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for(int i=1; i <= 5; i++) {
//			for(int j = 1; j <= i; j++) {
//				System.out.print("* ");
//			}
//			System.out.println();
//		}
		//mirror image
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				if(j <= (5-i)) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}

	}

}
