package stocks;

import java.awt.AWTException;
import java.awt.event.InputEvent;

/* 
 * Extra funktioner till AWT Robot klassen;
 * Och små Delays för att den kan annars hinna kalla på nästa innan musen har flyttats till exempel
 * 
 * */


public class RobotAwt extends java.awt.Robot {

	public RobotAwt() throws AWTException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	// Flytta musen
	protected void mouseMove(int x, int y, int delay) throws InterruptedException {

		mouseMove(x, y);
		Thread.sleep(delay);
	}

	// Skriv text
	protected void typeText(String text, int  delay) throws InterruptedException {

		for (int i = 0; i < text.length(); i++) {

			keyPress(text.charAt(i));
			keyRelease(text.charAt(i));
		}
		Thread.sleep(delay);
	}

	// Mus click
	@SuppressWarnings("deprecation")
	// Provide a Delay 0 or more; 1 or more pairs of X and y coordinates
	//, where x is first and y second
	// To Doubleclick just provide 0 delay and 2 pairs of same coordinates
	protected void mouseClick(int delayAfterMouseMove, int delayAfterClick, int... xy) throws InterruptedException {

		for (int i : xy) {
			if ((i & 1) == 0)
				continue;

			mouseMove(xy[i], xy[i + 1], delayAfterMouseMove);
			mousePress(InputEvent.BUTTON1_MASK);
			mouseRelease(InputEvent.BUTTON1_MASK);

			Thread.sleep(delayAfterClick);
		}
	}	
}
