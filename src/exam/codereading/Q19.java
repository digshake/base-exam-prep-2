package exam.codereading;

public class Q19 {

	public static boolean examine(int[] numbers, boolean[] check) {
	    for(int i = 0; i < check.length; i++) {
	        if(check[i]) {
	            int out = process(numbers[i]);
	            System.out.println(out);
	            if (out > 2) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
	public static int process(int incoming) {
	    if(incoming % 2 == 0) { //even
	        return incoming * 3;
	    } else {
	        return incoming - 7;
	    }
	}

	public static void main(String[] args) {
		//Use the substitution method to show the computation of
		//the following:
		
		int[] input = {1, 4, 5, 7, 2};
		for(int i = 0; i < input.length; i++) {
		    System.out.println(process(input[i]));
		}
	}
}
