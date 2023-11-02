package nonexam.wordle;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.*;
import javax.swing.JOptionPane;

import edu.princeton.cs.introcs.StdDraw;

public class LetterPressDebugApp {
	public static void main(String[] args) throws InterruptedException {
		int opt = JOptionPane.showConfirmDialog(null,
	             "Include backspace and delete?", "Include backspace and delete?", JOptionPane.YES_NO_OPTION);
		int[] letters = new int[5];
		if(opt == JOptionPane.YES_OPTION) {
			letters = new int[]{KeyEvent.VK_A, KeyEvent.VK_B, KeyEvent.VK_C, KeyEvent.VK_BACK_SPACE, KeyEvent.VK_SPACE};
		}
		else {
			letters = new int[]{KeyEvent.VK_A, KeyEvent.VK_B, KeyEvent.VK_C, KeyEvent.VK_D, KeyEvent.VK_E};
		}
		final int[] l = letters;
		Robot buddy;
		try {
			buddy = new Robot();
			for(int i = 0; i < 5; i++) {
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.text(0.5, 0.5, "Testing...: " + KeyEvent.getKeyText(letters[i]));
				char[] studentLetter = {' '};
				Runnable runStudentMethod = () -> {
					studentLetter[0] = Wordle.getKeyPress();
					System.out.println(studentLetter[0]);
				};
				int _i = i;
				Runnable pressKey = () -> {
					StdDraw.pause(1000);
					buddy.keyPress(l[_i]);
				};
				Thread t1 = new Thread(runStudentMethod);
				Thread t2 = new Thread(pressKey);
				t1.start();
				t2.start();
				t1.join();
				t2.join();
				char cleanedLetter = Character.toUpperCase(studentLetter[0]);
				StdDraw.setPenColor(cleanedLetter != letters[i] ? StdDraw.RED : StdDraw.GREEN);
				StdDraw.text(0.2, 0.5, "Your output: " + KeyEvent.getKeyText(cleanedLetter));
				StdDraw.pause(800);
				StdDraw.clear();
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
	}
}
