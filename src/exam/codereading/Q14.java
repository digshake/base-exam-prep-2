package exam.codereading;

public class Q14 {

	public static void and ( int w) {
		System.out.println (w);
		watch (w * 2);
	}
	public static void now ( int [] a, int x) {
		System.out.println (x);
		if(x > a. length ) {
			and (a [0]);
		} else {
			watch (a[x] * 2);
		}
	}
	public static void watch (int z) {
		if (z / 2 < 7) {
			and (z);
		} else {
			System.out.println ("bye");
		}
	}

	public static void main(String[] args) {
		//What will get printed?
		
		watch(4);
		and(2);
		
		int [] a = {3, 2, 4, 6};
		now(a, 9);
	}
}
