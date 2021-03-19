package mousechaser.debug;

import javax.swing.Icon;

import edu.princeton.cs.introcs.StdDraw;
import mousechaser.ChaseTheMouse;
import support.cse131.DrawCase;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DrawBallCase implements DrawCase {
	private final double[] location;
	private final double radius;

	public DrawBallCase(double x, double y, double radius) {
		this.location = new double[] { x, y };
		this.radius = radius;
	}

	public double[] location() {
		return location;
	}

	public double radius() {
		return radius;
	}

	@Override
	public String getText() {
		return String.format(
				"<html>Does the screen show a single black dot at (%s, %s) of radius: %s?<br/>Note: we have added crosshairs at this location.</html>",
				location[0], location[1], radius);
	}

	@Override
	public void draw() {
		StdDraw.setPenColor(0,0,0);
		ChaseTheMouse.drawBall(location, radius);
	}

	@Override
	public Icon getIcon() {
		return null;
	}
}
