package sec02.ex02;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Observable;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class PropertyData extends Observable{
	public final int NORMAL_FONT_SIZE = 80;	
	public final String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	public final String strColors[] = {"Black", "Red", "Blue", "Cyan", "DarkGray", "Gray", "Green", "LightGray", "Magenta", "Orange", "Pink", "White", "Yellow"};
	public final Color colors[] = {
		Color.BLACK,
		Color.RED,
		Color.BLUE,
		Color.CYAN,
		Color.DARK_GRAY,
		Color.GRAY,
		Color.GREEN,
		Color.LIGHT_GRAY,
		Color.MAGENTA,
		Color.ORANGE,
		Color.PINK,
		Color.WHITE,
		Color.YELLOW
		};
	public final int sizes[] = {80, 100, 150, 200, 250, 300, 350, 400};
	
	public int fontStyle = Font.PLAIN;
	public String font = "Serif"; 
	public int fontSize = NORMAL_FONT_SIZE;
	public String color = strColors[5];
	public String backgroundColor = strColors[7];
	public int x = 100;
	public int y = 100;
		
	private Preferences prefs = Preferences.userNodeForPackage(PropertyData.class);
	private String unifiedID = "KohichiNishide";
	private final String[] keys = {unifiedID + "Font", unifiedID + "FontSize", unifiedID + "Color", unifiedID + "BackgroudColor", unifiedID + "x", unifiedID + "y"};
	
	public void setData(String fo, int si, String co, String baco) {
		font = fo;
		fontSize = si;
		color = co;
		backgroundColor = baco;
		save();
		notifyToPanel();
	}
	
	public void setData(int xVal, int yVal) {
		x = xVal;
		y = yVal;
		save();
		notifyToPanel();
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
        color = prefs.get(keys[2], color);
        backgroundColor = prefs.get(keys[3], backgroundColor);
        Integer xTemp = x;
        Integer yTemp = y;
        x = Integer.parseInt(prefs.get(keys[4], xTemp.toString()));
        y = Integer.parseInt(prefs.get(keys[5], yTemp.toString()));
    }
	
	public Color parseColor(String str) {
		for (int i = 0; i < strColors.length; i++) {
			if (str.equals(strColors[i])) {
				return colors[i];
			}
		}
		return null;
	}
	
	public void notifyToPanel() {
		setChanged();
		notifyObservers();
	}
}
