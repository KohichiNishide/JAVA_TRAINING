package sec02.ex04;

import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class ClockMenuPopup extends JPopupMenu{
	private static final long serialVersionUID = 1L;
	private ClockPropertyData data;
	private String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	private String colors[] = {"Black", "Red", "Blue", "Cyan", "DarkGray", "Gray", "Green", "LightGray", "Magenta", "Orange", "Pink", "White", "Yellow"};
	private int sizes[] = {80, 100, 150, 200, 250};
	
	private JMenu menuFont, menuFontSize, menuCharColor, menuBackgroundColor, menuClockMode;
	private List<JMenuItem> fontMenuItems = new ArrayList<JMenuItem>();
	private List<JMenuItem> fontSizeMenuItems = new ArrayList<JMenuItem>();
	private List<JMenuItem> charColorMenuItems = new ArrayList<JMenuItem>();
	private List<JMenuItem> backgroundColorMenuItems = new ArrayList<JMenuItem>();
	private JMenuItem analogModeMenuItem = new JMenuItem("Analog");
	private JMenuItem digitalModeMenuItem = new JMenuItem("Digital");
	private JMenuItem exitMenuItem = new JMenuItem("Exit");
	
	//-------------------------------------------------------------------
	//   Public methods
	//-------------------------------------------------------------------
	public ClockMenuPopup(ClockPropertyData data) {	
		this.data = data;
        createMenu();
        createMenuItem();
        addMenu();
        addMenuItem();
	}
	
	//-------------------------------------------------------------------
	//   Private methods
	//-------------------------------------------------------------------	
	private void createMenu() {
        menuFont = new JMenu("Font");
        menuFontSize = new JMenu("Font Size");
        menuCharColor = new JMenu("Color");
        menuBackgroundColor = new JMenu("Background Color");
        menuClockMode = new JMenu("Clock Mode");
	}
	
	private void createMenuItem() {
		JMenuItem item;
		for (int i = 0; i < fonts.length; i++) {
			item = new JMenuItem(fonts[i]);
        	item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	String fontName = e.getActionCommand();
                	data.setFont(fontName);
                }
            });
        	fontMenuItems.add(item);
        }
        for (int i = 0; i < sizes.length; i++) {
        	item = new JMenuItem(Integer.toString(sizes[i]));
        	item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	data.setFontSize(e.getActionCommand());
                }
            });
        	fontSizeMenuItems.add(item);
        }
        for (int i = 0; i < colors.length; i++) {
        	item = new JMenuItem(colors[i]);
        	item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	data.setColor(e.getActionCommand());
                }
            });
        	charColorMenuItems.add(item);
        	
        	item = new JMenuItem(colors[i]);
        	item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	data.setBackgroundColor(e.getActionCommand());
                }
            });
        	backgroundColorMenuItems.add(item);
        }
        
        analogModeMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//TODO
            	data.setAnalogClockMode();
            	System.out.println("Change to analog mode");
            }
        });
        digitalModeMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//TODO
            	data.setDigitalClockMode();
            	System.out.println("Change to digital mode");
            }
        });

        menuClockMode.add(analogModeMenuItem);
        menuClockMode.add(digitalModeMenuItem);
        
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 System.exit(0);
            }
        });
	}
	
	private void addMenu() {
        this.add(menuFont);
        this.add(menuFontSize);
        this.add(menuCharColor);
        this.add(menuBackgroundColor);
        this.add(menuClockMode);
        this.add(exitMenuItem);
	}
	
	private void addMenuItem() {
		for (JMenuItem item : fontMenuItems) {
        	menuFont.add(item);
        }
        for (JMenuItem item : fontSizeMenuItems) {
        	menuFontSize.add(item);
        }
        for (JMenuItem item : charColorMenuItems) {
        	menuCharColor.add(item);
        }
        for (JMenuItem item : backgroundColorMenuItems) {
        	menuBackgroundColor.add(item);
        }
	}
}
