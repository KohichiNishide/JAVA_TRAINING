package sec02.ex03;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class PropertyData extends Observable {
	public final int NORMAL_FONT_SIZE = 80;	
	public int fontStyle = Font.PLAIN;
	public String font = "Serif"; 
	public int fontSize = NORMAL_FONT_SIZE;
	public Color color = Color.BLACK;
	public Color backgroundColor = Color.WHITE;
	
	private Map<String, Color> colorMap = new HashMap<String, Color>() {
		private static final long serialVersionUID = 1L;
		{
	    	put("Black", Color.BLACK);
	    	put("Red", Color.RED);
	    	put("Blue", Color.BLUE);
	    	put("Cyan", Color.CYAN);
	    	put("DarkGray", Color.DARK_GRAY);
	    	put("Gray", Color.GRAY);
	    	put("Green", Color.GREEN);
	    	put("LightGray", Color.LIGHT_GRAY);
	    	put("Magenta", Color.MAGENTA);
	    	put("Orange", Color.ORANGE);
	    	put("Pink", Color.PINK);
	    	put("White", Color.WHITE);
	    	put("Yellow", Color.YELLOW);    	
	    }
	};
	
	//-------------------------------------------------------------------
	//   Public methods
	//-------------------------------------------------------------------
	public void setFont(String font) {
		this.font = font;
		notifyToPanel();
	}
	
	public void setFontSize(String size) {
		this.fontSize = Integer.parseInt(size);
		notifyToPanel();
	}
	
	public void setColor(String color) {
		this.color = colorMap.get(color);
		notifyToPanel();
	}
	
	public void setBackgroundColor(String color) {
		this.backgroundColor = colorMap.get(color);
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
