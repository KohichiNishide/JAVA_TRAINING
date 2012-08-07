package sec01.ex04;

import java.awt.Color;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class PropertyData {
	public static final int NORMAL_FONT_SIZE = 80;	
	public static final String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	public static final String strColors[] = {"Black", "Red", "Blue", "Cyan", "DarkGray", "Gray", "Green", "LightGray", "Magenta", "Orange", "Pink", "White", "Yellow"};
	public static final Color colors[] = {
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
	public static final int sizes[] = {80, 100, 150, 200, 250, 300, 350, 400};
	
	public static int fontStyle = Font.PLAIN;
	public static String font = "Serif"; 
	public static int fontSize = NORMAL_FONT_SIZE;
	public static String color = strColors[5];
	public static String backgroundColor = strColors[7];
	public static int x = 100;
	public static int y = 100;
	
	private static Preferences prefs = Preferences.userNodeForPackage(PropertyData.class);
	private static String unifiedID = "KohichiNishide";
	private static final String[] keys = {unifiedID + "Font", unifiedID + "FontSize", unifiedID + "Color", unifiedID + "BackgroudColor", unifiedID + "x", unifiedID + "y"};
	
	
	public static void setData(String fo, int si, String co, String baco) {
		font = fo;
		fontSize = si;
		color = co;
		backgroundColor = baco;
		save();
	}
	
	public static void setData(int xVal, int yVal) {
		x = xVal;
		y = yVal;
		save();
	}
	
	private static void save() {
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
	
	public static void load() {
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
	
	public static Color parseColor(String str) {
		for (int i = 0; i < strColors.length; i++) {
			if (str.equals(strColors[i])) {
				return colors[i];
			}
		}
		return null;
	}
}
