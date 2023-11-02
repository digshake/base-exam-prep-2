package exam.codereading;

public class Q15 {

	public static String foo (int x) {
		if (x <= 0) {
			return "a";
		}
		if (x == 1) {
			return "b";
		} else {
			return foo (x - 2) + "c" + foo (x - 1);
		}
	}

	public static void main(String[] args) {
		//Use the substitution method to show the computation of
		//the following:
		
		foo(4);
	}
}
