package sec02.ex04;

import java.awt.*;
import java.awt.event.*;

public class ClockPropertyDialog extends Frame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private static final int NORMAL_LABEL_FONT_SIZE = 15;
	private GridBagLayout gbl = new GridBagLayout();
	private ClockPropertyData data;
	
	public static String buFont;
	public static int buFontSize;
	public static String buColor;
	public static String buBackgroundColor;
	
	private Choice fontChoice;
	private Choice sizeChoice;
	private Choice colorChoice;
	private Choice backgroundColorChoice;
	
	private static Label preview;

	public ClockPropertyDialog(final ClockPropertyData data) {
		setTitle("Property dialog");
        setSize(560, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(gbl);
        this.data = data;
        
        data.load();
        
        // ?Ω?Ω?Ωx?Ω?Ω?ΩÃîz?Ωu
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
        
        // ?Ω?Ω?Ωj?Ω?Ω?Ω[?Ω{?Ωb?ΩN?ΩX?ΩÃîz?Ωu
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
        
        // ?Ω{?Ω^?Ω?Ω?ΩÃîz?Ωu
        Button okButton = new Button("OK");
        Button cancelButton = new Button("Cancel");
        
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
        
        addButton(okButton, 3, 4, 1, 1);
        addButton(cancelButton, 4, 4, 1, 1);
        
        // ?Ω?Ω?ΩX?Ωi?Ω[?ΩÃí«âÔøΩ
        fontChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Choice cho = (Choice)e.getItemSelectable();
				ClockPropertyDialog.buFont = data.fonts[cho.getSelectedIndex()];
				Font f = new Font(buFont, Font.PLAIN, 35);
				ClockPropertyDialog.preview.setFont(f);
				ClockPropertyDialog.preview.setText("Preview");
			}
        });
        sizeChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Choice cho = (Choice)e.getItemSelectable();
				ClockPropertyDialog.buFontSize = data.sizes[cho.getSelectedIndex()];
			}
        });
        colorChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Choice cho = (Choice)e.getItemSelectable();
				ClockPropertyDialog.buColor = data.strColors[cho.getSelectedIndex()];
			}
        });
        backgroundColorChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Choice cho = (Choice)e.getItemSelectable();
				ClockPropertyDialog.buBackgroundColor = data.strColors[cho.getSelectedIndex()];
			}
        });
        
        preview = new Label("Preview", Label.CENTER);
        Font f = new Font(buFont, Font.PLAIN, 35);
        preview.setFont(f);
        preview.setBackground(Color.LIGHT_GRAY);
        preview.setForeground(Color.DARK_GRAY);
        addPreviewLabel(preview, 2, 2, 2, 2);
        
        Label memo = new Label("Font", Label.CENTER);
        Font memoFont = new Font("Serif", Font.BOLD, 20);
        memo.setFont(memoFont);
        addLabel(memo, 2, 1, 1, 1);
        
        //?Ω~?Ω?Ω?Ω?Ω?Ω?Ω?ΩÍÇΩ?Ω∆ÇÔøΩ?ΩÃèÔøΩ?Ω?Ω
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
	
	private void addPreviewLabel(Label label, int x, int y, int w, int h) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 100.0;
        gbc.weighty = 100.0;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = h;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.BOTH;
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
		buColor = data.color.toString();
		buBackgroundColor = data.backgroundColor.toString();
		resetComboBoxSelectedItem();
	}
	
	private void resetComboBoxSelectedItem() {
		fontChoice.select(data.font);
		Integer size = data.fontSize;
		sizeChoice.select(size.toString());
		colorChoice.select(data.color.toString());
		backgroundColorChoice.select(data.backgroundColor.toString());
	}
}

