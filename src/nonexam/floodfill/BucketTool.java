package nonexam.floodfill;

import java.awt.Color;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;


public class BucketTool {
	
	
 protected Color[][] screen;
 double halfPixelWidth;
 double halfPixelHeight;
final  double SCREEN_WIDTH = 1.0;
final  double SCREEN_HEIGHT = 1.0;

public BucketTool(int dimensions){
	this.screen = new Color[dimensions][dimensions];
	for(int i = 0; i < screen.length; i++) {
		for(int j = 0; j < screen[0].length; j++) {
			screen[i][j] = StdDraw.WHITE;
		}
	}
	
	halfPixelWidth = 0.5/(double)dimensions;
	halfPixelHeight = 0.5/(double)dimensions;
	
}
	
	public void drawPixel(int r, int c) {
		double xcoord = (double) r / screen.length;
		double ycoord = (double) c / screen[0].length;
		StdDraw.setPenColor(screen[r][c]);
		StdDraw.filledRectangle(xcoord, ycoord, halfPixelWidth, halfPixelHeight);
	}
	
	public void drawScreen() {
		for (int r = 0; r < screen.length; r++) {
			for(int c = 0; c < screen[0].length; c++) { //no this is java, not c++
				drawPixel(r, c);
			}
		}
		
	}

	public int getXIndex(double x) {
		return (int) (x * (1.0/SCREEN_WIDTH) * screen.length);
	}
	
	public int getYIndex(double y) {
		return (int) (y * (1.0/SCREEN_HEIGHT)* screen[0].length);
	}
	public void fill(Color target, Color fillcolor, int x, int y) {
		if (target.equals(fillcolor)) {
			return;
		}
		if (x >= screen.length || x < 0 || y >= screen[0].length || y < 0) {
			return;
		}
		if(!screen[x][y].equals(target)) {
			return;
		}
		screen[x][y] = fillcolor;
		drawPixel(x, y);
		StdDraw.show();
		
		fill(target, fillcolor, x, y+1);
		fill(target, fillcolor, x, y-1);
		
		fill(target, fillcolor, x+1, y-1);
		fill(target, fillcolor, x+1, y);
		fill(target, fillcolor, x+1, y+1);
		
		fill(target, fillcolor, x-1, y-1);
		fill(target, fillcolor, x-1, y);
		fill(target, fillcolor, x-1, y+1);
	}
	
	
}
