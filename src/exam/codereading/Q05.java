package exam.codereading;

public class Q05 {

	public static void m2( int x , int y ) {
		System.out.println("x : " + x) ;
		if(y>3) {
			m2(x , y-1);
		} else if(x>0) {
			m2(x-2 , y);
		}
		
		System.out.println("x : " + x) ; //println moved here!
	}

	public static void main(String[] args) {
		//What is the output of the following?

		m2(2, 0);
		m2(2, 4);
	}
}
