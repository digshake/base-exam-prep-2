package exam.codereading;

public class Q02 {

	public static int a (int x) {
		System.out.println ( "A" ) ;
		return x + 3 ;
	}
	
	public static int b(int y ) {
		System.out.println( "B" ) ;
		y = y + 1 ;
		return y ;
	}
	
	public static int c(int z) {
		System.out.println( "C" ) ;
		int w = a( z ) ;
		w = w + b( z ) ;
		return w;
	}
	
	public static int d(int w) {
		System.out.println( "D" ) ;
		System.out.println( c (w) ) ;
		return w * 5 ;
	}
	
	public static void main(String[] args) {
		//What is the output of the following?

		int n = c( 3 ) ;
		System.out.println(n) ;
	}
}
