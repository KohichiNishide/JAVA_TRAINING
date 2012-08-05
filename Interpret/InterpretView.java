import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class InterpretView extends Frame implements Observer, ActionListener, AdjustmentListener, ItemListener{
	private static final long serialVersionUID = 1L;
	private Scrollbar bar;
	private Label objectNameLabel = new Label("");
	private Label successLabel = new Label("TBD");
	private Label fieldNameLabel = new Label("Name");
	private Label fieldTypeLabel = new Label("Type");
	private Label fieldValLabel = new Label("Value");
	private Label methodLabel = new Label("Method list");
	private Choice fieldsChoice = new Choice();
	private TextField objectNameTextField = new TextField("java.awt.Frame");
	private Button okButton = new Button("Create object");
	private Button setFButton = new Button("Set field value");
	private Button invokeMButton = new Button("Invoke method");
	private GridBagLayout gbl = new GridBagLayout();
	private Interpret con;
	static final int COMPONENT_COUNT = 45;
	static final int PARAMETER_COUNT = 10;
	private Label[] fieldNames = new Label[COMPONENT_COUNT];
	private Label[] fieldTypes = new Label[COMPONENT_COUNT];
	private TextField[] fieldValues = new TextField[COMPONENT_COUNT];
	private Choice methodsChoice = new Choice();
	private Label methodTypeLabel = new Label("Parameter type");
	private Label methodValLabel = new Label("Parameter value");
	private Label methodReturnTypeLabel = new Label("Return type");
	private Label methodReturnValLabel = new Label("Return value");
	private Label methodReturnTypeContent = new Label("");
	private Label methodReturnValContent = new Label("");
	private Label[] methodTypes = new Label[PARAMETER_COUNT];
	private TextField[] methodValues = new TextField[PARAMETER_COUNT];
	
	public InterpretView(Interpret controller) {
		con = controller;
		setTitle("Interpret main view");
	    setSize(1000, 1200);
	    setLocationRelativeTo(null);
	    setResizable(false);
	    setLayout(gbl);	    
	   
        bar = new Scrollbar(Scrollbar.VERTICAL, 0, 10, 0, 1000);
	    
        bar.addAdjustmentListener(this);
	    okButton.addActionListener(this);
	    okButton.addActionListener(con);
	    setFButton.addActionListener(this);
	    methodsChoice.addItemListener(this);
	    invokeMButton.addActionListener(this);
	    
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
		fieldNameLabel.setBackground(Color.LIGHT_GRAY);
		fieldTypeLabel.setBackground(Color.LIGHT_GRAY);
		fieldValLabel.setBackground(Color.LIGHT_GRAY);
		methodLabel.setBackground(Color.LIGHT_GRAY);
		methodTypeLabel.setBackground(Color.LIGHT_GRAY);
		methodValLabel.setBackground(Color.LIGHT_GRAY);
		methodReturnTypeLabel.setBackground(Color.LIGHT_GRAY);
		methodReturnValLabel.setBackground(Color.LIGHT_GRAY);
		addLabel(objectNameLabel, 0, 0, 1, 1);
        addLabel(fieldNameLabel, 0, 3, 3, 1);
        addLabel(fieldTypeLabel, 3, 3, 3, 1);
        addLabel(fieldValLabel, 6, 3, 4, 1);
        // ボタンフィールドの配置
        addButton(okButton, 10, 2, 4, 1);
        
        // テキストフィールドの配置
        addTextField(objectNameTextField, 0, 2, 10, 1);     
        
        for (int i = 0; i < COMPONENT_COUNT; i++) {
        	fieldNames[i] = new Label();
        	fieldTypes[i] = new Label();
        	fieldValues[i] = new TextField();
        	addLabel(fieldNames[i], 0, GridBagConstraints.RELATIVE, 3, 1);
        	addLabel(fieldTypes[i], 3, GridBagConstraints.RELATIVE, 3, 1);
        	addTextField(fieldValues[i], 6, GridBagConstraints.RELATIVE, 4, 1);
        }
        
        
        addButton(setFButton, 10, GridBagConstraints.RELATIVE, 4, 1);
        addLabel(methodLabel, 10, GridBagConstraints.RELATIVE, 4, 1);
        addChoice(methodsChoice, 10, GridBagConstraints.RELATIVE, 4, 1);
        addLabel(methodTypeLabel, 10, GridBagConstraints.RELATIVE, 2, 1);
        addLabel(methodValLabel, 12, GridBagConstraints.RELATIVE, 2, 1);
        

        for(int i = 0; i < PARAMETER_COUNT; i++) {
        	methodTypes[i] = new Label();
        	methodValues[i] = new TextField();
        	addLabel(methodTypes[i], 10, GridBagConstraints.RELATIVE, 2, 1);
        	addTextField(methodValues[i], 12, GridBagConstraints.RELATIVE, 2, 1);
        }
        
        addLabel(methodReturnTypeLabel, 10, GridBagConstraints.RELATIVE, 2, 1);
        addLabel(methodReturnValLabel, 12, GridBagConstraints.RELATIVE, 2, 1);
        addLabel(methodReturnTypeContent, 10, GridBagConstraints.RELATIVE, 2, 1);
        addLabel(methodReturnValContent, 12, GridBagConstraints.RELATIVE, 2, 1);
        addButton(invokeMButton, 10, GridBagConstraints.RELATIVE, 4, 1);
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
		String str = (String) obj;
		if (!model.IsError()) {
			if (str == null) {
				List<String> fieldNameList = model.getFieldNames();
				for (int i = 0; i < fieldNameList.size(); i++) {
					fieldNames[i].setText(fieldNameList.get(i));
					fieldTypes[i].setText(model.getFieldTypes().get(i));
					fieldValues[i].setText(model.getFieldVals().get(i));
				}
				
				List<String> methodNameList = model.getMethodNames();
				for (int i = 0; i < methodNameList.size(); i++) {
					methodsChoice.add(methodNameList.get(i));
				}
				
				//ObjectPropertyDialog dlg = new ObjectPropertyDialog(this, con);
				//dlg.show();
			} else if (str.equals("methodParameter")) {
				resetMethods();
				
				List<String> methodTypeList = model.getMethodParaTypes();
				for (int i = 0; i < methodTypeList.size(); i++) {
					methodTypes[i].setText(methodTypeList.get(i));
				}
			} else {			
				System.out.println("************Else*************");
			}
		} else {
			successLabel.setText("Failed !!");
			for (int i = 0; i < fieldNames.length; i++) {
				fieldNames[i].setText("");
				fieldTypes[i].setText("");
				fieldValues[i].setText("");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Create object") {
			con.setObjectName(objectNameTextField.getText());
		} else if (e.getActionCommand() == "Set field value") {	
			String[] vals = new String[fieldValues.length];
			for (int i = 0; i < vals.length; i++) {
				vals[i] = fieldValues[i].getText();
			}
			con.setFieldValues(vals);
		} else if (e.getActionCommand() == "Invoke method") {
			int argCount = 0;
			for (Label tx : methodTypes) {
				if (tx.getText() != "") {
					argCount ++;
				}
			}
			
			String[] vals = new String[argCount];
			for (int i = 0; i < vals.length; i++) {
				vals[i] = methodValues[i].getText();
			}
			con.callMethod(vals);
		} else {
			
		}
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Choice cho = (Choice)e.getItemSelectable();
		con.setSelectedMethod(cho.getSelectedIndex());
		//con.callMethod(cho.getSelectedIndex());	
	}
	
	private void resetMethods() {
		for (int i = 0; i < PARAMETER_COUNT; i++) {
			methodTypes[i].setText("");
			methodValues[i].setText("");
		}
	}
}
