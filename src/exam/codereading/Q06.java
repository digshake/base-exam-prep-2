package exam.codereading;

public class Q06 {

	public static int f(int n) {
		if (n == 1) {
			return 1;
		}
		else if (n%2 == 0) { // n is even
			return f(n/2); // integer division
		}
		else {
			return f(3*n+1);
		}
	}

	public static void main(String[] args) {
		//Use the substitution method to show the result of the
		//following:
		
		f(3);
	}
}
