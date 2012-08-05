import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Scrollbar;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class InterpretView extends Frame implements Observer, ActionListener, AdjustmentListener{
	private static final long serialVersionUID = 1L;
	private Scrollbar bar;
	private Label objectNameLabel = new Label("Input class name");
	private Label successLabel = new Label("TBD");
	private Label fieldNameLabel = new Label("Name");
	private Label fieldTypeLabel = new Label("Type");
	private Label fieldValLabel = new Label("Value");
	private Choice fieldsChoice = new Choice();
	private TextField objectNameTextField = new TextField("java.awt.Frame");
	private Button okButton = new Button("Create object");
	private GridBagLayout gbl = new GridBagLayout();
	private Interpret con;
	static final int COMPONENT_COUNT = 45;
	private Label[] fieldNames = new Label[COMPONENT_COUNT];
	private Label[] fieldTypes = new Label[COMPONENT_COUNT];
	private TextField[] fieldValues = new TextField[COMPONENT_COUNT];
	
	public InterpretView(Interpret controller) {
		con = controller;
		setTitle("Interpret main view");
	    setSize(1200, 1200);
	    setLocationRelativeTo(null);
	    setResizable(false);
	    setLayout(gbl);
	    
	   
        bar = new Scrollbar(Scrollbar.VERTICAL, 0, 10, 0, 1000);
	    
        bar.addAdjustmentListener(this);
	    okButton.addActionListener(this);
	    okButton.addActionListener(con);
	    
	    addComponents();
	        
        addWindowListener(con);       
        //pack();
        show();
	}
	
	private void addBar(Scrollbar bar) {
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 100.0;
        gbc.weighty = 100.0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbl.setConstraints(bar, gbc);
        add(bar, BorderLayout.EAST);
	}
	
	private void addComponents() {
		// ラベルの配置
        //objectNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));      
        //addLabel(objectNameLabel, 0, 0, 1, 1);

        addLabel(fieldNameLabel, 0, 10, 3, 1);
        addLabel(fieldTypeLabel, 3, 10, 3, 1);
        addLabel(fieldValLabel, 6, 10, 4, 1);
        
        //successLabel.setFont(new Font("Arial", Font.PLAIN, 20));      
        //addLabel(successLabel, 0, 3, 3, 1);
        
        // テキストフィールドの配置
        addTextField(objectNameTextField, 0, 0, 10, 1);     
        
        for (int i = 0; i < COMPONENT_COUNT; i++) {
        	fieldNames[i] = new Label();
        	fieldTypes[i] = new Label();
        	fieldValues[i] = new TextField();
        	addLabel(fieldNames[i], 0, 11 + i, 3, 1);
        	addLabel(fieldTypes[i], 3, 11 + i, 3, 1);
        	addTextField(fieldValues[i], 6, 11 + i, 4, 1);
        }
        // ボタンフィールドの配置
        addButton(okButton, 10, 0, 1, 1);
	}
	
	private void addButton(Button button, int x, int y, int w, int h) {
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 100.0;
        gbc.weighty = 100.0;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbl.setConstraints(button, gbc);
        add(button);
	}
	
	private void addLabel(Label label, int x, int y, int w, int h) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 100.0;
        gbc.weighty = 100.0;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbl.setConstraints(label, gbc);
        add(label);
    }
	
	private void addTextField(TextField tf, int x, int y, int w, int h) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 100.0;
        gbc.weighty = 100.0;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbl.setConstraints(tf, gbc);
        add(tf);
    }
	
	private void addChoice(Choice choice, int x, int y, int w, int h) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
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

	@Override
	public void update(Observable obs, Object obj) {
		ObjectInfo model = (ObjectInfo)obs;
		if (!model.IsError()) {
			successLabel.setText("Success !!");			
			List<String> fieldNameList = model.getFieldNames();
			for (int i = 0; i < fieldNameList.size(); i++) {
				fieldNames[i].setText(fieldNameList.get(i));
				fieldTypes[i].setText(model.getFieldTypes().get(i));
				fieldValues[i].setText(model.getFieldVals().get(i));
			}
			
			//ObjectPropertyDialog dlg = new ObjectPropertyDialog(this, con);
			//dlg.show();
		} else {
			successLabel.setText("Failed !!");
			for (int i = 0; i < fieldNames.length; i++) {
				fieldNames[i].setText("");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		con.setObjectName(objectNameTextField.getText());
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
