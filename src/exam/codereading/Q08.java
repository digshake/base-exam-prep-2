package exam.codereading;

public class Q08 {

	public static String select ( String [] values , int location , int count ) {
		System .out. println ( values [ location ]);
		int next = 3* location +1;
		if( location %2 == 0) { // Check if location is an even number
			next = location /2;
		}
		if( location ==1 || count ==0)
			return values [ location -1];
		else
			return select (values , next , count -1);
	}

	public static void main(String[] args) {
		//What gets printed?

		String [] val1 = {"E","T","I","D","R","G","A"};
		System .out. println ( select (val1 , 1, 1));
		
		System .out. println ( select (val1 , 4, 4));
	}
}
