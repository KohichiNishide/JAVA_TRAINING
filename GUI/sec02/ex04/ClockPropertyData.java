package sec02.ex04;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import sec01.ex04.PropertyData;

public class ClockPropertyData extends Observable {
	public final int NORMAL_FONT_SIZE = 80;	
	public int fontStyle = Font.PLAIN;
	public String font = "Serif"; 
	public int fontSize = NORMAL_FONT_SIZE;
	public String color = "Black";
	public String backgroundColor = "White";	
	public static final String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	public static final int sizes[] = {80, 100, 150, 200, 250, 300, 350, 400};
	public static final String strColors[] = {"Black", "Red", "Blue", "Cyan", "DarkGray", "Gray", "Green", "LightGray", "Magenta", "Orange", "Pink", "White", "Yellow"};
	
	public Map<String, Color> colorMap = new HashMap<String, Color>() {
		public static final long serialVersionUID = 1L;
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
	
	enum ClockMode { ANALOG, DIGITAL }
	private ClockMode clockMode = ClockMode.DIGITAL;
	public int x = 100;
	public int y = 100;
	
	private Preferences prefs = Preferences.userNodeForPackage(ClockPropertyData.class);
	private String unifiedID = "KohichiNishide";
	private final String[] keys = {unifiedID + "Font", unifiedID + "FontSize", unifiedID + "Color", unifiedID + "BackgroudColor", unifiedID + "x", unifiedID + "y"};
	
	
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
		this.color = color;
		notifyToPanel();
	}
	
	public void setBackgroundColor(String color) {
		this.backgroundColor = color;
		notifyToPanel();
	}
	
	public void setAnalogClockMode() {
		clockMode = ClockMode.ANALOG;
		setChanged();
		notifyObservers("analog");
	}
	
	public void setDigitalClockMode() {
		clockMode = ClockMode.DIGITAL;
		setChanged();
		notifyObservers("digital");
	}
	
	public void setData(String fo, int si, String co, String baco) {
		font = fo;
		fontSize = si;
		color = co;
		backgroundColor = baco;
		save();
	}
	
	public void setData(int xVal, int yVal) {
		x = xVal;
		y = yVal;
		save();
	}
	
	private void save() {
        try {
            prefs.put(keys[0], font);
            Integer size = fontSize;
            prefs.put(keys[1], size.toString());
            prefs.put(keys[2], color);
            prefs.put(keys[3], backgroundColor);
            Integer xTemp = x;
            Integer yTemp = y;
            prefs.put(keys[4], xTemp.toString());
            prefs.put(keys[5], yTemp.toString());
            
            prefs.flush();
        } catch (BackingStoreException ex) {
            ex.printStackTrace();
        }
    }
	
	public void load() {
        font = prefs.get(keys[0], font);
        Integer size = fontSize;
        fontSize = Integer.parseInt(prefs.get(keys[1], size.toString()));
        color = prefs.get(keys[2], "black");
        backgroundColor = prefs.get(keys[3], "white");
        Integer xTemp = x;
        Integer yTemp = y;
        x = Integer.parseInt(prefs.get(keys[4], xTemp.toString()));
        y = Integer.parseInt(prefs.get(keys[5], yTemp.toString()));
    }
	
	public Color getColor() {
		return colorMap.get(color);
	}
	
	public Color getBackgroundColor() {
		return colorMap.get(backgroundColor);
	}
	//-------------------------------------------------------------------
	//   Private methods
	//-------------------------------------------------------------------
	private void notifyToPanel() {
		setChanged();
		notifyObservers();
	}
}
