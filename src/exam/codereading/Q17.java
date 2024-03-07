package exam.codereading;

public class Q17 {

	public static void ruby(int x) {
	    System.out.println("red");
	    if(x >= 7) {
	        emerald(x - 4);
	    }
	}
	public static void emerald(int y) {
	    if(y < 4) {
	        sapphire(y);
	    }
	    System.out.println("green");
	    if(y > 2) { 
	        ruby(y - 4);
	    }
	}
	public static void sapphire(int z) {
	    if(z == 3) {
	        System.out.println("gems");
	    }
	    System.out.println("blue");
	}

	public static void main(String[] args) {
		//Use the substitution method to show the computation of
		//the following:
		
		ruby(12);
	}
}
