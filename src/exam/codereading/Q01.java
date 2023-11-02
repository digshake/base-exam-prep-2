package exam.codereading;

public class Q01 {

	public static int a (int x) {
		System.out.println ( "A" ) ;
		return x + 3 ;
	}
	
	public static int b(int y ) {
		System.out.println( "B" ) ;
		y = y + 1 ;
		return y ;
	}
	
	public static void main(String[] args) {
		//What is the output of the following?

		int y = 3 ;
		int m = b( y ) ;
		System.out.println(m) ;
		System.out.println(y) ;
	}
}
