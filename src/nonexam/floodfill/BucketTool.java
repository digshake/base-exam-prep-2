package nonexam.floodfill;

import java.awt.Color;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

/*
 * Instructions for this extension can be found here:
 * 
 * https://131text.com/ns/books/published/csjava/Extensions/6.06.html
 */
public class BucketTool {
	protected Color[][] screen;
	protected double halfPixelWidth; 
	protected double halfPixelHeight;
	protected final double SCREEN_WIDTH = 1.0;
	protected final double SCREEN_HEIGHT = 1.0;

	/**
	 * Provided: A constructor for the BucketTool objeect
	 * @param dimensions
	 */
	public BucketTool(int dimensions){
		// initialize the screen array to desired resolution (the higher dimensions, the more detailed the image)
		this.screen = new Color[dimensions][dimensions];
		// set everything in the image to white initially
		for(int i = 0; i < screen.length; i++) {
			for(int j = 0; j < screen[0].length; j++) {
				screen[i][j] = StdDraw.WHITE;
			}
		}
		// set the pixel size, if you'd like it more detailed, decrease the 0.5 value
		halfPixelWidth = 0.5/(double)dimensions;
		halfPixelHeight = 0.5/(double)dimensions;
	}

	/**
	 * Draws a pixel with the color at the given indices 
	 * @param r The row in screen 
	 * @param c The column in screen
	 */
	public void drawPixel(int r, int c) {
		// TODO
	}

	/**
	 * Draw everything in the screen array
	 */
	public void drawScreen() {
		// TODO
	}

	/**
	 * Get the x index in screen from the x coordinate on the canvas
	 * @param x: x coordinate
	 * @return the corresponding index in the screen array (row)
	 */
	public int getXIndex(double x) {
		return 0;
	}

	/**
	 * Get the y index in screen from the y coordinate on the canvas
	 * @param y: y coordinate
	 * @return the corresponding index in the screen array (column)
	 */
	public int getYIndex(double y) {
		return 0;
	}
	
	/**
	 * Fill the screen (or available area)
	 * @param currentColor: the current color of the area
	 * @param fillColor: the color to fill in the area 
	 * @param row: the current row
	 * @param col: the current column
	 */
	public void fill(Color currentColor, Color fillColor, int row, int col) {
		// TODO
		StdDraw.show(); // leave this here to see the color fill in real-time
	}
}
