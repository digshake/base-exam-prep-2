package exam.codereading;

public class Q11 {

	public static int left ( int [] x, int index ) {
		if( index > 0) {
			System .out. println (x[ index ]);
			return x[ index - 1];
		} else {
			return x[ index ];
		}
	}
	public static int right ( int x) {
		if(x > 0) {
			return (x % 3) + 3;
		} else {
			return 2;
		}
	}

	public static void main(String[] args) {
		//What gets printed?

		//part 1
		int [] a = {1, 3, 1};
		System.out.println ( left (a, 1));

		//part 2
		int [] b = {2, 3, 7, 1, 3, 9};
		for ( int i = 3; i < 7; i += 2) {
			int x = right (i);
			System.out.println ( left (b, x ));
		}

		//part 3
		int [] c = {2, 3, 7, 1, 3, -1};
		int x = c [2];
		while (x != 2) {
			x = right (x);
			x = right (x);
			x -= left (c, x);
			System .out. println (x);
		}
	}
}
