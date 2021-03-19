package mousechaser;

import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;
import mousechaser.debug.DrawBallCase;
import mousechaser.debug.DrawBallCases;
import support.cse131.Crosshairs;
import support.cse131.DialogBoxes;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DrawBallDebugApp {
	private static void drawCrosshairs(DrawBallCase drawBallCase) {
		StdDraw.setPenColor(0, 109, 219);
		Crosshairs.drawCrosshairs(drawBallCase.location(), drawBallCase.radius() * 2);
		StdDraw.show();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			for (DrawBallCase drawCase : DrawBallCases.getCases()) {
				StdDraw.clear();
				drawCase.draw();
				drawCrosshairs(drawCase);
				DialogBoxes.askUser(drawCase.getText());
			}
			System.exit(0);
		});
	}
}
