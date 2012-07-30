package sec01.ex04;

import java.awt.*;
import java.awt.event.*;

public class PropertyDialog extends Frame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private static final int NORMAL_FONT_SIZE = 80;
	private static final int MAX_FONT_SIZE = 500;
	private static final int FONT_SIZE_INTERVAL = 50;
	private static final int NORMAL_LABEL_FONT_SIZE = 15;
	private GridBagLayout gbl = new GridBagLayout();
	
	public static String font = PropertyData.font; 
	public static int fontSize = PropertyData.fontSize;
	public static String color = PropertyData.color;
	public static String backgroundColor = PropertyData.backgroundColor;
	
	private Choice fontChoice;
	private Choice sizeChoice;
	private Choice colorChoice;
	private Choice backgroundColorChoice;

	public PropertyDialog() {
		setTitle("Property dialog");
        setBounds(10, 10, 550, 200);
        setResizable(false);
        setLayout(gbl);
        
        // ラベルの配置
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
        
        // メニューボックスの配置
        fontChoice = new Choice();
        sizeChoice = new Choice();
        colorChoice = new Choice();
        backgroundColorChoice = new Choice();
        
        setFontChoice(fontChoice);
        setSizeChoice(sizeChoice);
        setColorChoice(colorChoice);
        setColorChoice(backgroundColorChoice);
        
        addChoice(fontChoice, 1, 0, 1, 1);
        addChoice(sizeChoice, 1, 1, 1, 1);
        addChoice(colorChoice, 1, 2, 1, 1);
        addChoice(backgroundColorChoice, 1, 3, 1, 1);
        
        // ボタンの配置
        Button okButton = new Button("OK");
        Button cancelButton = new Button("Cancel");
        
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
        
        addButton(okButton, 2, 4, 1, 1);
        addButton(cancelButton, 3, 4, 1, 1);
        
        // リスナーの追加
        fontChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Choice cho = (Choice)e.getItemSelectable();
				PropertyDialog.font = PropertyData.fonts[cho.getSelectedIndex()];
			}
        });
        sizeChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Choice cho = (Choice)e.getItemSelectable();
				PropertyDialog.fontSize = PropertyData.sizes[cho.getSelectedIndex()];
			}
        });
        colorChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Choice cho = (Choice)e.getItemSelectable();
				PropertyDialog.color = PropertyData.strColors[cho.getSelectedIndex()];
			}
        });
        backgroundColorChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Choice cho = (Choice)e.getItemSelectable();
				PropertyDialog.backgroundColor = PropertyData.strColors[cho.getSelectedIndex()];
			}
        });
        
        //×を押されたときの処理
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
		String[] fonts = PropertyData.fonts;
		for(int i = 0; i < fonts.length; i++){
			ch.addItem(fonts[i]);
		}
	}
	
	private void setSizeChoice(Choice ch) {
		int size = NORMAL_FONT_SIZE;
        while(size < MAX_FONT_SIZE) {
        	ch.addItem(Integer.toString(size));
        	size += FONT_SIZE_INTERVAL;
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
			repaint();
			this.setVisible(false);
		} else if (e.getActionCommand() == "Cancel") {
			this.setVisible(false);
		}
	}
	
	private void setPropertyData() {
		PropertyData.font = this.font;
		PropertyData.fontSize = this.fontSize;
		PropertyData.color = this.color;
		PropertyData.backgroundColor = this.backgroundColor;
	}
	
	private void reloadPropertyData() {
		this.font = PropertyData.font;
		this.fontSize = PropertyData.fontSize;
		this.color = PropertyData.color;
		this.backgroundColor = PropertyData.backgroundColor;
		
		resetComboBoxSelectedItem();
	}
	
	private void resetComboBoxSelectedItem() {
		this.fontChoice.select(PropertyData.font);
		Integer size = PropertyData.fontSize;
		this.sizeChoice.select(size.toString());
		this.colorChoice.select(PropertyData.color);
		this.backgroundColorChoice.select(PropertyData.backgroundColor);
	}
}

