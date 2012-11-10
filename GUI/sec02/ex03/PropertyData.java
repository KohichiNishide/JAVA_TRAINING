package sec02.ex03;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;

public class PropertyData extends Observable {
	public final int NORMAL_FONT_SIZE = 80;	
	public int fontStyle = Font.PLAIN;
	public String font = "Serif"; 
	public int fontSize = NORMAL_FONT_SIZE;
	public Color color = Color.BLACK;
	public Color backgroundColor = Color.WHITE;
	
	//-------------------------------------------------------------------
	//   Public methods
	//-------------------------------------------------------------------
	public void setFont(String font) {
		this.font = font;
		notifyToPanel();
	}
	
	public void setFontSize(int size) {
		this.fontSize = size;
		notifyToPanel();
	}
	
	public void setColor(Color color) {
		this.color = color;
		notifyToPanel();
	}
	
	public void setBackgroundColor(Color color) {
		this.backgroundColor = color;
		notifyToPanel();
	}
	
	//-------------------------------------------------------------------
	//   Private methods
	//-------------------------------------------------------------------
	private void notifyToPanel() {
		setChanged();
		notifyObservers();
	}
}
