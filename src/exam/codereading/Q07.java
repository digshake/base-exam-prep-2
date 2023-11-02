package exam.codereading;

public class Q07 {

	public static int prod ( int a, int b, int c) {
		System .out. println ("A: " + a);
		return a*b*c;
	}
	
	public static double root (int a, int b, int c) {
		double x = sq(b);
		System .out. println ("X: " + x);
		double y = prod (a, c, -4);
		double z = prod (1, 2, a);
		return (-b + Math . sqrt (x+y)) / z;
	}
	
	public static int sq( int x) {
		System .out. println ("Sq: " + x);
		return prod (1, x, x);
	}
	
	public static void main(String[] args) {
		//What gets printed?
		
		System.out.println( prod (4 ,2 ,1));
		
		System.out.println(sq (4));
		
		double d = root (3 ,4 ,5); // No println ()
	}
}
