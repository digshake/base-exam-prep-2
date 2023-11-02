package exam.codereading;

public class Q04 {

	public static void m( int x , int y ) {
		System.out.println("x : " + x) ;
		if(y>3) {
			m(x , y-1);
		} else if(x>0) {
			m(x-2 , y);
		}
	}

	public static void main(String[] args) {
		//What is the output of the following?

		m(-2, -1);
		m(2, 0);
		m(2, 4);
	}
}
