package sec02.ex02;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observer;

import javax.swing.JDialog;

public class PropertyDialog extends JDialog implements ActionListener{
	private final long serialVersionUID = 1L;
	private PropertyData data;
	public String buFont;
	public int buFontSize;
	public String buColor;
	public String buBackgroundColor;
	private GridBagLayout gbl = new GridBagLayout();

	
	private Choice fontChoice;
	private Choice sizeChoice;
	private Choice colorChoice;
	private Choice backgroundColorChoice;
	
	private final int NORMAL_LABEL_FONT_SIZE = 15;
	
	public PropertyDialog(DigitalPanel panel, PropertyData aData) {
		data = aData;
		buFont = data.font;
		buFontSize = data.fontSize;
		buColor = data.color;
		buBackgroundColor = data.backgroundColor;
		setTitle("Property dialog");
        setSize(560, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(gbl);
        data.load();
        data.addObserver((Observer)panel);
        
        
        Label fontLabel = new Label("Font");
        Label sizeLabel = new Label("Font size");
        Label colorLabel = new Label("Color");
        Label backgroundColorLabel = new Label("Background color");
        
        fontLabel.setFont(new Font("Arial", Font.PLAIN, NORMAL_LABEL_FONT_SIZE));
        sizeLabel.setFont(new Font("Arial", Font.PLAIN, NORMAL_LABEL_FONT_SIZE));
        colorLabel.setFont(new Font("Arial", Font.PLAIN, NORMAL_LABEL_FONT_SIZE));
        backgroundColorLabel.setFont(new Font("Arial", Font.PLAIN, NORMAL_LABEL_FONT_SIZE));
        
        addLabel(fontLabel, 0, 0, 1, 1);
        addLabel(sizeLabel, 0, 1, 1, 1);
        addLabel(colorLabel, 0, 2, 1, 1);
        addLabel(backgroundColorLabel, 0, 3, 1, 1);
        
        
        fontChoice = new Choice();
        sizeChoice = new Choice();
        colorChoice = new Choice();
        backgroundColorChoice = new Choice();
        
        setFontChoice(fontChoice);
        setSizeChoice(sizeChoice);
        setColorChoice(colorChoice);
        setColorChoice(backgroundColorChoice);
        
        addChoice(fontChoice, 1, 0, 3, 1);
        addChoice(sizeChoice, 1, 1, 1, 1);
        addChoice(colorChoice, 1, 2, 1, 1);
        addChoice(backgroundColorChoice, 1, 3, 1, 1);
        
        
        Button okButton = new Button("OK");
        Button cancelButton = new Button("Cancel");
        
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
        
        addButton(okButton, 3, 4, 1, 1);
        addButton(cancelButton, 4, 4, 1, 1);
        
        fontChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Choice cho = (Choice)e.getItemSelectable();
				buFont = data.fonts[cho.getSelectedIndex()];
				Font f = new Font(buFont, Font.PLAIN, 35);
			}
        });
        sizeChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Choice cho = (Choice)e.getItemSelectable();
				buFontSize = data.sizes[cho.getSelectedIndex()];
			}
        });
        colorChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Choice cho = (Choice)e.getItemSelectable();
				buColor = data.strColors[cho.getSelectedIndex()];
			}
        });
        backgroundColorChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Choice cho = (Choice)e.getItemSelectable();
				buBackgroundColor = data.strColors[cho.getSelectedIndex()];
			}
        });
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)  {
                e.getWindow().setVisible(false);
            }
       });
	}
	
	public void load() {
		reloadPropertyData();
		this.setVisible(true);
	}
	
	private void setFontChoice(Choice ch) {
		String[] fonts = data.fonts;
		for(int i = 0; i < fonts.length; i++){
			ch.addItem(fonts[i]);
		}
	}
	
	private void setSizeChoice(Choice ch) {
		int[] sizes = data.sizes;
		for(int i = 0; i < sizes.length; i++){
			ch.addItem(Integer.toString(sizes[i]));
		}
	}
	
	private void setColorChoice(Choice ch) {
		ch.addItem("Black");
        ch.addItem("Red");
        ch.addItem("Blue");
        ch.addItem("Cyan");
        ch.addItem("DarkGray");
        ch.addItem("Gray");
        ch.addItem("Green");
        ch.addItem("LightGray");
        ch.addItem("Magenta");
        ch.addItem("Orange");
        ch.addItem("Pink");
        ch.addItem("White");
        ch.addItem("Yellow");
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
        gbc.insets = new Insets(5, 5, 5, 5);
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
        gbc.insets = new Insets(5, 5, 5, 5);
        gbl.setConstraints(choice, gbc);
        add(choice);
    }
	
	private void addButton(Button button, int x, int y, int w, int h) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 100.0;
        gbc.weighty = 100.0;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.anchor = GridBagConstraints.SOUTHWEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbl.setConstraints(button, gbc);
        add(button);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "OK") {
			setPropertyData();
			setVisible(false);
		} else if (e.getActionCommand() == "Cancel") {
			setVisible(false);
		}
	}
	
	private void setPropertyData() {			
		data.setData(buFont, buFontSize, buColor, buBackgroundColor);
	}
	
	private void reloadPropertyData() {
		buFont = data.font;
		buFontSize = data.fontSize;
		buColor = data.color;
		buBackgroundColor = data.backgroundColor;
		resetComboBoxSelectedItem();
	}
	
	private void resetComboBoxSelectedItem() {
		fontChoice.select(data.font);
		Integer size = data.fontSize;
		sizeChoice.select(size.toString());
		colorChoice.select(data.color);
		backgroundColorChoice.select(data.backgroundColor);
	}
}
