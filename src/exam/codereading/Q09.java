package exam.codereading;

public class Q09 {

	public static int fun ( int k) {
		if(k >25) {
			return k;
		} else {
			return fun (k *2 -1)+1;
		}
	}

	public static void main(String[] args) {
		//Use the substitution method to show the evaluation of
		//the following:
		
		fun(4);
	}
}
