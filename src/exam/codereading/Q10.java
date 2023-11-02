package exam.codereading;

public class Q10 {

	public static void bipitty (int x) {
		System .out. println (x);
		bopitty (x, x - 2);
	}
	public static void bopitty (int x, int y) {
		if(x > y * .5) {
			boo (y);
		} else if (x > y) {
			bipitty (y);
		}
	}
	public static void boo ( int z) {
		if(z == 0) {
			System .out. println (" boo ");
		} else {
			System .out. println (z);
			boo (z / 2);
		}
	}

	public static void main(String[] args) {
		//What gets printed?

		boo(4);
		
		bopitty(7, 3);
		
		bipitty(12);
	}
}
