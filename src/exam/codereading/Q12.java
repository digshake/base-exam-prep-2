package exam.codereading;

public class Q12 {

	public static int foo ( int n) {
		if (n == 0) {
			return 1;
		} else if (n > 0) {
			return 2 * foo (-n);
		} else {
			return foo (n + 1) + 1;
		}
	}

	public static void main(String[] args) {
		//Use the substitution method to show the computation of
		//the following:
		
		foo(3);
	}
}
