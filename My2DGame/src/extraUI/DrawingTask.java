package extraUI;

import java.awt.Font;

public class DrawingTask {

	public int x, y;
	public int fontSize = 16;
	public Font font;
	public String text;
	
	public DrawingTask(int x, int y, String text) {
		this.x = x;
		this.y = y;
		this.text = text;
		font = new Font("SANS_SERIF", Font.BOLD, fontSize);
	}
	public DrawingTask(int x, int y, int fontSize, String text) {
		this.x = x;
		this.y = y;
		this.fontSize = fontSize;
		this.text = text;
		font = new Font("SANS_SERIF", Font.BOLD, fontSize);
	}
	
}
	

