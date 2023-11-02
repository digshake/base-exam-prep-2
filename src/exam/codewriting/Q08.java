package exam.codewriting;

import java.util.Scanner;

import edu.princeton.cs.introcs.StdDraw;

public class Q08 {

	/*
	For this problem we wish to construct a method named countValues that will count and
	return the number of times a particular value appears in the columns of a 2D integer array. For example
	if you were given an array:

		int [][] a = {
			{1, 2, 4},
			{3, 4, 1},
			{1, 7, 7}
		}

	The call to countValues(a, 1) would return [2, 0, 1], a 1D array that represents the number of times
	that the value 1 appears in each column of a.
	You should assume that the array given as an input could be any size, and your method should work
	appropriately. It is not necessary to use recursion for this problem. Complete the method below:
	 */

	public static int[] countValues (int[][] a, int findMe ) {
		return new int[0]; //fix me
	}

	public static void main ( String[] args ) {
		int [][] a = {
				{1, 2, 4},
				{3, 4, 1},
				{1, 7, 7}
		};
		int[] answer = countValues(a, 1);
		for(int i : answer) {
			System.out.println(i);
		}
	}

}
