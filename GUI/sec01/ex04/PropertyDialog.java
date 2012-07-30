package sec01.ex04;

import java.awt.*;
import java.awt.event.*;

public class PropertyDialog extends Frame {
	private static final long serialVersionUID = 1L;
	private static final int NORMAL_FONT_SIZE = 80;
	private final String fonts[]= GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	private GridBagLayout gbl = new GridBagLayout();

	public PropertyDialog() {
		setTitle("Property dialog");
        setBounds(10, 10, 500, 200);
        setResizable(false);
        setLayout(gbl);
        
        // ラベルの配置
        Label fontLabel = new Label("Font");
        Label sizeLabel = new Label("Font size");
        Label colorLabel = new Label("Color");
        Label backgroundColorLabel = new Label("Background color");
        
        fontLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        sizeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        colorLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        backgroundColorLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        
        fontLabel.setBackground(Color.CYAN);
        
        addLabel(fontLabel, 0, 0, 1, 1);
        addLabel(sizeLabel, 0, 1, 1, 1);
        addLabel(colorLabel, 0, 2, 1, 1);
        addLabel(backgroundColorLabel, 0, 3, 1, 1);
        
        // メニューボックスの配置
        Choice fontChoice = new Choice();
        Choice sizeChoice = new Choice();
        Choice colorChoice = new Choice();
        Choice backgroundColorChoice = new Choice();
        
        setFontChoice(fontChoice);
        setSizeChoice(sizeChoice);
        setColorChoice(colorChoice);
        setColorChoice(backgroundColorChoice);
        
        addChoice(fontChoice, 1, 0, 1, 1);
        addChoice(sizeChoice, 1, 1, 1, 1);
        addChoice(colorChoice, 1, 2, 1, 1);
        addChoice(backgroundColorChoice, 1, 3, 1, 1);
              
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)  {
                e.getWindow().setVisible(false);
            }
       });
	} 
	
	private void setFontChoice(Choice ch) {
		for(int i = 0; i < fonts.length; i++){
			ch.add(fonts[i]);
		}
	}
	
	private void setSizeChoice(Choice ch) {
		int size = NORMAL_FONT_SIZE;
        while(size < 500) {
        	ch.add(Integer.toString(size));
        	size += 50;
        }    
	}
	
	private void setColorChoice(Choice ch) {
		ch.add("Black");
        ch.add("Red");
        ch.add("Blue");
        ch.add("Cyan");
        ch.add("DarkGray");
        ch.add("Gray");
        ch.add("Green");
        ch.add("LightGray");
        ch.add("Magenta");
        ch.add("Orange");
        ch.add("Pink");
        ch.add("White");
        ch.add("Yellow");
	}
	
	private void addLabel(Label label, int x, int y, int w, int h) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 100.0;
        gbc.weighty = 100.0;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.anchor = GridBagConstraints.EAST;
        gbl.setConstraints(label, gbc);
        add(label);
    }
	
	private void addChoice(Choice choice, int x, int y, int w, int h) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 100.0;
        gbc.weighty = 100.0;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.anchor = GridBagConstraints.WEST;
        gbl.setConstraints(choice, gbc);
        add(choice);
    }
}

