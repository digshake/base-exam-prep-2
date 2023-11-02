package nonexam.wordle;

import java.util.Arrays;
import java.util.Scanner;
import java.awt.event.KeyEvent;
public class Wordle {
	private static final double TOP_BUFFER = -0.0833;
	private static final double SIDE_BUFFER = 0.10;
	private static final double CELL_SIZE = (1.0/15.0);
	
	private static final String[] WORDS = {
	            "apple", "beach", "chair", "dream", "eleven",
	            "flame", "grape", "happy", "igloo", "juice",
	            "kites", "lemon", "mango", "noble", "ocean",
	            "piano", "queen", "rainy", "sunny", "table",
	            "umbra", "vivid", "wrist", "adieu", "yacht",
	            "zebra", "alike", "bison", "crisp", "daisy",
	            "emote", "fable", "globe", "hello", "inlay",
	            "joker", "kudos", "liver", "magic", "nexus"
	};

	/**
	 * Draw a single row from the Wordle board with 5 columns.
	 * @param row: The row number to draw
	 */
	public static void drawRow(int row) {
		// TODO 
	}
	
	/**
	 * Draw a standard Wordle board, with 6 rows and 5 columns.
	 * Use the defined constant variables for sizes
	 */
	public static void drawBoard() {
		// TODO: draw an empty board with 6 rows and 5 columns
	}
	
	/**
	 * Wait until a key is pressed then return the char that was pressed
	 * @return the char that was pressed
	 */
	public static char getKeyPress() {
		return ' ';
	}
	
	/**
	 *  Get the full guess entered by the user, marked by pressing enter when done
	 * @param guessNumber: the number guess (out of 6) that the user is onn
	 * @return the users final guess, String
	 */
	public static String getGuess(int guessNumber) {
		return null; // TODO delete me and complete the method
	}
	
	/**
	 * Draw the text inside previously drawn cells
	 * @param guess: the number guess (row) the player is on
	 * @param word: the word the player has guessed
	 */
	public static void drawWord(int guess, String word) {
		// TODO
	}
	
	/**
	 * Using the provided array of words, randomly pick one and return it
	 * @return the randomly generated word
	 */
	public static String getRandomWord() {
		return null; // TODO delete the placeholder (return null) and complete the method
	}
	
	/**
	 * Check to see if the user's guess is incorrect, in the wrong place, or correct
	 * @param guess: the user's guess
	 * @param answer: the correct word
	 * @return a String array, containing information about each letter
	 */
	public static String[] checkGuess(String guess, String answer) {
		return null; // TODO delete the placeholder (return null) and complete the method
	}
	
	/**
	 *  Draw gray/green/yellow based on each character
	 * @param guess: The user's guess
	 * @param feedback: the array generated from checkGuess(..)
	 * @param guessNumber: the number guess a user is on
	 */
	public static void drawColors(String guess, String[] feedback, int guessNumber) {
		// TODO
	}
	
	/**
	 *  Check to see if the guess is completely correct
	 * @param feedback: the array generated from checkGuess
	 * @return true if the guess is right, false if not
	 */
	public static boolean correctAnswer(String[] feedback) {
		return false; // TODO delete the placeholder (return false) and complete the method
	}
	
	/**
	 * Show a message over the board, use for winning or losing
	 * @param message: message to display
	 */
	public static void showMessage(String message) {
		// TODO
	}
	
	public static void main(String[] args) {
		// TODO run the game
	}
}
