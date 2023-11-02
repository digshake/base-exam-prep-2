package nonexam.floodfill;

import java.awt.Color;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;


public class FloodfillClient {
	static Color currentColor = StdDraw.BOOK_RED;
	static int i = 0;
	static final Color[] colorOptions = {StdDraw.RED, StdDraw.BLUE, StdDraw.CYAN, StdDraw.GREEN, StdDraw.PINK};
	public static void changeColor() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
			currentColor = colorOptions[i];
			
			i++;
			if(i >= colorOptions.length) {
				i = 0;
			}
		}
	}
	public static void run(BucketTool bk) {
		for (int i = 0; i < bk.screen.length; i++) {
			bk.screen[i][bk.screen[0].length/2] = StdDraw.BLACK;
		}

		for(int i = 0; i < bk.screen[0].length; i++) {
			bk.screen[bk.screen.length/2][i] = StdDraw.BLACK;
		}

		for(int i = 0; i < bk.screen[0].length; i++) {
			bk.screen[bk.screen.length/4][i] = StdDraw.BLACK;
		}

		for (int i = 0; i < bk.screen.length; i++) {
			bk.screen[i][3*bk.screen[0].length/4] = StdDraw.BLACK;
		}
		bk.drawScreen();


		while(!StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)) {
			changeColor();
			if(StdDraw.isMousePressed()) {
				double mouseX = StdDraw.mouseX();
				double mouseY = StdDraw.mouseY();
				int x = bk.getXIndex(mouseX);
				int y = bk.getYIndex(mouseY);
				Color target = bk.screen[x][y];
				bk.fill(target, currentColor, x, y);

			}
		}
	}

	public static void main(String[] args) {
		StdDraw.enableDoubleBuffering();
		BucketTool app = new BucketTool(50);
		run(app);
	}
}
