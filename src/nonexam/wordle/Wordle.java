package nonexam.wordle;

import java.util.Arrays;
import java.util.Scanner;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.event.KeyEvent;
public class Wordle {
	private static final double TOP_BUFFER = -0.0833;
	private static final double SIDE_BUFFER = 0.10;
	private static final String[] WORDS = {
	            "apple", "beach", "chair", "dream", "seven",
	            "flame", "grape", "happy", "igloo", "juice",
	            "kites", "lemon", "mango", "noble", "ocean",
	            "piano", "queen", "rainy", "sunny", "table",
	            "umbra", "vivid", "wrist", "adieu", "yacht",
	            "zebra", "alike", "bison", "crisp", "daisy",
	            "emote", "fable", "globe", "hello", "inlay",
	            "joker", "kudos", "liver", "magic", "nexus"
	};
	public static void drawBoard(int rowToStart) {
		for(int row = rowToStart; row > 0; row--) {
			drawRow(row);
		}
		StdDraw.show();
	}
	public static void drawRow(int row) {
		double y = (row * (1.0/6.0)) + TOP_BUFFER;
		for(int col = 0; col < 5; col++) {
			double x = (col * 0.2) + SIDE_BUFFER;
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledSquare(x, y, (1.0/15.0));
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.square(x, y, (1.0/15.0));
		}
	}
	public static char getKeyPress() {
		System.out.println("waiting for keypress..");
		while(!StdDraw.hasNextKeyTyped()) {
		}
		char key = StdDraw.nextKeyTyped();
		return key;
	}
	public static void drawWord(int guess, String word) {
		int rowNumber = 6 - guess;
		double y = (rowNumber * (1.0/6.0)) + TOP_BUFFER;
		for(int i = 0; i < word.length(); i++) {
			double x = (i * 0.2) + SIDE_BUFFER;
			StdDraw.text(x, y, word.substring(i, i+1));
		}
	}
	public static String getGuess(int guessNumber) {
		String guess = "";
		char letterTyped = getKeyPress();
		System.out.println(letterTyped == KeyEvent.VK_ENTER);
		while(letterTyped != KeyEvent.VK_ENTER || guess.length() != 5) {
			if(letterTyped == KeyEvent.VK_BACK_SPACE) {
				if(guess.length() != 0) {
					guess = guess.substring(0, guess.length()-1);
				}
			}
			else if(guess.length() <= 5){
				guess += letterTyped;
			}
			drawBoard(6 - guessNumber);
			drawWord(guessNumber, guess);
			StdDraw.show();
			letterTyped = getKeyPress();
			System.out.println((letterTyped == KeyEvent.VK_ENTER));
		}
		guess = guess.toLowerCase();
		return guess;
	}
	public static String getRandomWord() {
		int randomIndex = (int) (Math.random() * WORDS.length);
		return WORDS[randomIndex];
	}
	public static String[] checkGuess(String guess, String answer) {
		String[] feedback = new String[5];
//		System.out.println(guess+  " " + answer);
		String repeaters = "";
		for(int i = 0; i < guess.length(); i++) {
			if(guess.charAt(i) == answer.charAt(i)) {
				feedback[i] = "Correct";
			}
			else if(answer.contains(guess.subSequence(i, i+1))) {
				if(countLetter(answer, guess.charAt(i)) < countLetter(guess, guess.charAt(i))) {
//					System.out.println(guess.charAt(i) + " " + repeaters);
					if(countLetter(answer, guess.charAt(i)) <= countLetter(repeaters, guess.charAt(i))) {
						feedback[i] = "Incorrect";
					}
					else {
						feedback[i] = "Wrong Place";
						repeaters += guess.charAt(i);
					}
				}
				else {
					feedback[i] = "Wrong Place";
				}
			}
			else {
				feedback[i] = "Incorrect";
			}
		}
		return feedback;
	}
	public static int countLetter(String word, char letter) {
		int count = 0;
		for(char c : word.toCharArray()) {
			if(c == letter) {
				count++;
			}
		}
		return count;
	}
	public static void drawColors(String guess, String[] feedback, int guessNumber) {
		int rowNumber = 6 - guessNumber;
		double y = (rowNumber * (1.0/6.0)) + TOP_BUFFER;
		for(int col = 0; col < 5; col++) {
			double x = (col * 0.2) + SIDE_BUFFER;
			if(feedback[col].equals("Correct")) {
				StdDraw.setPenColor(StdDraw.GREEN);
			}
			else if (feedback[col].equals("Wrong Place")) {
				StdDraw.setPenColor(StdDraw.YELLOW);
			}
			else {
				StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
			}
			StdDraw.filledSquare(x, y, (1.0/15.0));
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(x, y, Character.toString(guess.charAt(col)));
			StdDraw.show();
		}
	}
	public static boolean correctAnswer(String[] feedback) {
		for(String s : feedback) {
			if(!s.equals("Correct")) {
				return false;
			}
		}
		return true;
	}
	public static void showMessage(String message) {
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.filledRectangle(0.5, 0.5, 0.4, 0.2);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.5, 0.5, message);
	}
	public static void main(String[] args) {
		StdDraw.enableDoubleBuffering();
		boolean debugMode = false;
		drawBoard(6);
		String answer;
		if(debugMode) {
			Scanner scan = new Scanner(System.in);
			System.out.println("word?");
			answer = scan.next();
			scan.close();
		}
		else {
			answer = getRandomWord();
		}
		for(int guess = 0; guess < 6; guess++) {
			String guessString = getGuess(guess);
			System.out.println(guessString);
			String[] correctness = checkGuess(guessString, answer);
			System.out.println(Arrays.toString(correctness));
			drawColors(guessString, correctness, guess);
			if(correctAnswer(correctness)) {
				showMessage("You won!");
				StdDraw.show();
				return;
			}
		}
		showMessage("You lost :( The word was " + answer);
		StdDraw.show();
		
	}
}
