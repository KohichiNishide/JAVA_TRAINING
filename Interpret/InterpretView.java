
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class InterpretView extends Frame implements Observer, ActionListener, ItemListener{
	private static final long serialVersionUID = 1L;
	private Label objectNameLabel = new Label("");
	private Label successLabel = new Label("");
	private Choice fieldChoice = new Choice();
	private Label fieldNameLabel = new Label("Name");
	private Label fieldTypeLabel = new Label("Type");
	private Label fieldValLabel = new Label("Value");
	private Label methodLabel = new Label("Method list");
	private Label fieldLabel = new Label("Field list");
	private Label constructorLabel = new Label("Constructor list");
	private Label arrayLabel = new Label("Array");
	private TextField objectNameTextField = new TextField("java.lang.Integer");
	private Button okButton = new Button("Set #");
	private Button showConButton = new Button("Show constructor");
	private Button setFButton = new Button("Set field value");
	private Button invokeMButton = new Button("Invoke method");
	private Button invokeConButton = new Button("Invoke constructor");
	private GridBagLayout gbl = new GridBagLayout();
	private Interpret con;
	static final int COMPONENT_COUNT = 44;
	static final int PARAMETER_COUNT = 10;
	private Label fieldName = new Label("");
	private Label fieldType = new Label("");
	private TextField fieldValue = new TextField("");
	private Choice methodsChoice = new Choice();
	private Choice constructorsChoice = new Choice();
	private Label methodTypeLabel = new Label("Parameter type");
	private Label methodValLabel = new Label("Parameter value");
	private Label conTypeLabel = new Label("Parameter type");
	private Label conValLabel = new Label("Parameter value");
	private Label methodReturnTypeLabel = new Label("Return type");
	private Label methodReturnValLabel = new Label("Return value");
	private Label methodReturnTypeContent = new Label("");
	private Label methodReturnValContent = new Label("");
	private Label[] methodTypes = new Label[PARAMETER_COUNT];
	private TextField[] methodValues = new TextField[PARAMETER_COUNT];
	private Label[] conTypes = new Label[PARAMETER_COUNT];
	private TextField[] conValues = new TextField[PARAMETER_COUNT];
	private TextField exceptionTextField = new TextField("Exception log...");
	private Label fieldResultVal = new Label("");
	private Label fieldResultIcon = new Label("");
	
	private Label arrayTypeLabel = new Label("Array type");
	private TextField arrayTypeText = new TextField("");
	private Label arraySizeLabel = new Label("Array size");
	private TextField arraySizeText = new TextField("");
	private Button arrayButton = new Button("Create array");
	private Choice arrayChoice = new Choice();
	private Button setElementButton = new Button("Set element");
	private Button getElementButton = new Button("Get element");
	private Label elementsLabel = new Label("Elements");
	
	private Label stockLabel = new Label("Stock object");
	private Label stockNumberLabel = new Label("No.");
	private Label stockNameLabel = new Label("Name");
	private Label[] numberLabels = new Label[PARAMETER_COUNT];
	private Label[] stockNames = new Label[PARAMETER_COUNT];
	
	public InterpretView(Interpret controller) {
		con = controller;
		setTitle("Interpret main view");
	    setSize(1000, 1000);
	    setLocationRelativeTo(null);
	    setResizable(true);
	    setLayout(gbl);	    
	   
	    okButton.addActionListener(this);
	    okButton.addActionListener(con);
	    showConButton.addActionListener(this);
	    showConButton.addActionListener(con);
	    setFButton.addActionListener(this);
	    methodsChoice.addItemListener(this);
	    invokeMButton.addActionListener(this);
	    invokeConButton.addActionListener(this);
	    arrayButton.addActionListener(this);
	    setElementButton.addActionListener(this);
	    getElementButton.addActionListener(this);
	    
	    fieldChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Choice cho = (Choice)e.getItemSelectable();
				int index = cho.getSelectedIndex();
				if (index != -1)
					con.setSelectedField(index);
			}
        });
	    
	    constructorsChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Choice cho = (Choice)e.getItemSelectable();
				int index = cho.getSelectedIndex();
				if (index != -1)
					con.setSelectedConstructor(index);
			}
        });
	    
	    constructorsChoice.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = constructorsChoice.getSelectedIndex();
				if (index != -1)
					con.setSelectedConstructor(index);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        });
	    
	    arrayChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Choice cho = (Choice)e.getItemSelectable();
			}
        });
	    
	    addComponents();
	        
        addWindowListener(con);   
        show();
	}
	
	private void addComponents() {
		fieldNameLabel.setBackground(Color.LIGHT_GRAY);
		fieldTypeLabel.setBackground(Color.LIGHT_GRAY);
		fieldValLabel.setBackground(Color.LIGHT_GRAY);
		methodLabel.setBackground(Color.CYAN);
		fieldLabel.setBackground(Color.CYAN);
		constructorLabel.setBackground(Color.CYAN);
		arrayLabel.setBackground(Color.CYAN);
		methodTypeLabel.setBackground(Color.LIGHT_GRAY);
		methodValLabel.setBackground(Color.LIGHT_GRAY);
		conTypeLabel.setBackground(Color.LIGHT_GRAY);
		conValLabel.setBackground(Color.LIGHT_GRAY);
		methodReturnTypeLabel.setBackground(Color.LIGHT_GRAY);
		methodReturnValLabel.setBackground(Color.LIGHT_GRAY);
		arrayTypeLabel.setBackground(Color.LIGHT_GRAY);
		arraySizeLabel.setBackground(Color.LIGHT_GRAY);
		elementsLabel.setBackground(Color.LIGHT_GRAY);
		stockLabel.setBackground(Color.CYAN);
		stockNumberLabel.setBackground(Color.LIGHT_GRAY);
		stockNameLabel.setBackground(Color.LIGHT_GRAY);
		
        
		
        // Add components
        addButton(okButton, 11, 1, 1, 1);
        addLabel(successLabel, 6, 2, 1, 2);
        addButton(setFButton, 6, 6, 4, 1);
        addChoice(fieldChoice, 0, 6, 6, 1);
        addLabel(fieldLabel, 0, 5, 10, 1);
        addLabel(fieldValLabel, 6, 7, 4, 1);
        addLabel(constructorLabel, 10, 5, 4, 1);
        addChoice(constructorsChoice, 10, 6, 3, 1);
        addButton(showConButton, 13, GridBagConstraints.RELATIVE, 1, 1);
        addButton(invokeConButton, 13, GridBagConstraints.RELATIVE, 1, 1);
        addLabel(conTypeLabel, 10, 8, 2, 1);
        addLabel(conValLabel, 12, GridBagConstraints.RELATIVE, 2, 1);
        
        for(int i = 0; i < PARAMETER_COUNT; i++) {
        	conTypes[i] = new Label();
        	conValues[i] = new TextField();
        	
        	addLabel(conTypes[i], 10, GridBagConstraints.RELATIVE, 2, 1);
        	addTextField(conValues[i], 12, GridBagConstraints.RELATIVE, 2, 1);
        }
        
        
        
        addTextField(objectNameTextField, 0, 1, 10, 1);  
        addLabel(objectNameLabel, 0, 0, 1, 1);
        addLabel(fieldNameLabel, 0, 7, 3, 1);
        addLabel(fieldTypeLabel, 3, 7, 3, 1);
        addLabel(fieldName, 0, 8 , 3, 1);
    	addLabel(fieldType, 3, 8 , 3, 1);
    	addTextField(fieldValue, 6, 8 , 4, 1);
    	addLabel(fieldResultIcon, 3, 9, 3, 1);
    	addLabel(fieldResultVal, 6, 9, 4, 1);
        
        
        addLabel(methodLabel, 10, GridBagConstraints.RELATIVE, 4, 1);
        addChoice(methodsChoice, 10, GridBagConstraints.RELATIVE, 3, 1);
        addButton(invokeMButton, 13, GridBagConstraints.RELATIVE, 1, 1);
        
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
        addExceptionTextField(exceptionTextField, 0, GridBagConstraints.RELATIVE, 15, 4);
        
        addLabel(arrayLabel, 15, 5, 4, 1);
        addLabel(arrayTypeLabel, 15, 6, 2, 1);
        addLabel(arraySizeLabel, 17, 6, 2, 1);
        addTextField(arrayTypeText, 15, GridBagConstraints.RELATIVE, 2, 1);
        addTextField(arraySizeText, 17, GridBagConstraints.RELATIVE, 2, 1);
        addButton(arrayButton, 17, GridBagConstraints.RELATIVE, 2, 1);
        
        addLabel(elementsLabel, 15, 9, 2, 1);
        addChoice(arrayChoice, 15, GridBagConstraints.RELATIVE, 4, 1);
        addButton(setElementButton, 15, GridBagConstraints.RELATIVE, 2, 1);
        addButton(getElementButton, 17, GridBagConstraints.RELATIVE, 2, 1);
        
        addLabel(stockLabel, 15, 25, 4, 1);
        addLabel(stockNumberLabel, 15, GridBagConstraints.RELATIVE, 1, 1);
        addLabel(stockNameLabel, 16, GridBagConstraints.RELATIVE, 3, 1);
        
        for(int i = 0; i < PARAMETER_COUNT; i++) {
        	numberLabels[i] = new Label("#" + i);
        	stockNames[i] = new Label("");
        	addLabel(numberLabels[i], 15, GridBagConstraints.RELATIVE, 1, 1);
        	addLabel(stockNames[i], 16, GridBagConstraints.RELATIVE, 3, 1);
        }
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
        gbc.insets = new Insets(2, 2, 2, 2);
        gbl.setConstraints(button, gbc);
        add(button);
	}
	
	private void addLabel(Label label, int x, int y, int w, int h) {
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
        gbc.insets = new Insets(2, 2, 2, 2);
        gbl.setConstraints(tf, gbc);
        add(tf);
    }
	
	private void addExceptionTextField(TextField tf, int x, int y, int w, int h) {
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
        gbc.insets = new Insets(1, 1, 1, 1);
        gbl.setConstraints(choice, gbc);
        add(choice);
    }

	@Override
	public void update(Observable obs, Object obj) {
		ObjectInfo model = (ObjectInfo)obs;
		String str = (String) obj;
		if (!model.IsError()) {
			exceptionTextField.setText("");
			if (str == null) {
				resetFields();
				List<String> fieldNameList = model.getFieldNames();
				fieldChoice.removeAll();
				for (int i = 0; i < fieldNameList.size(); i++) {
					fieldChoice.add(fieldNameList.get(i));
				}
				List<String> methodNameList = model.getMethodNames();
				resetMethods();
				resetConstructors();
				if (methodNameList == null)
					return;
				for (int i = 0; i < methodNameList.size(); i++) {
					methodsChoice.add(methodNameList.get(i));
				}
				updateStockObjectList(model);				
			} else if (str.equals("field")) {
				fieldName.setText(model.getFieldName());
				fieldType.setText(model.getFieldType());
				fieldValue.setText(model.getFieldVal());
			} else if (str.equals("setFieldVal")) {
				showIndicatorForSetField();
				fieldResultVal.setText(model.getFieldVal());
				fieldResultVal.setForeground(Color.RED);
				updateStockObjectList(model);
				updateArrayList(model);
			} else if (str.equals("methodParameter")) {
				resetMethodProperty();
				List<String> methodTypeList = model.getMethodParaTypes();
				if (methodTypeList == null)
					return;
				for (int i = 0; i < methodTypeList.size(); i++) {
					methodTypes[i].setText(methodTypeList.get(i));
				}
				methodReturnTypeContent.setText(model.getReturnType());
			} else if (str.equals("methodReturnVal")) {
				methodReturnValContent.setText(model.getReturnValue());
				exceptionTextField.setText(model.getExceptionStr());
			} else if (str.equals("constructors")) {
				resetConstructors();
				List<String> conList = model.getConNames();
				if (conList == null)
					return;
				for (int i = 0; i < conList.size(); i++) {
					constructorsChoice.add(conList.get(i));
				}
			} else if (str.equals("conParameter")) {
				resetConProperty();
				List<String> conTypeList = model.getConParaTypes();
				if (conTypeList == null)
					return;
				for (int i = 0; i < conTypeList.size(); i++) {
					conTypes[i].setText(conTypeList.get(i));
				}
			} else if (str.equals("conReturnVal")) {
				// TBD
				exceptionTextField.setText(model.getExceptionStr());
			} else if (str.equals("arrayReturnVal")) {
				updateArrayList(model);
				exceptionTextField.setText(model.getExceptionStr());
			} else {			
				System.out.println("************Else*************");
			}
		} else {
			successLabel.setText("");
			exceptionTextField.setText(model.getExceptionStr());
		}
	}
	
	private void updateStockObjectList(ObjectInfo model) {
		List<String> stockNameList = model.getStockObjs();
		for (int i = 0; i < numberLabels.length; i++) {
			stockNames[i].setText(stockNameList.get(i));
		}
	}
	
	private void updateArrayList(ObjectInfo model) {
		resetElements();
		List<String> arrayList = model.getArrayNames();
		if (arrayList == null)
			return;
		for (int i = 0; i < arrayList.size(); i++) {
			arrayChoice.add(arrayList.get(i));
		}
	}
	
	private void showIndicatorForSetField() {
		try {
			fieldResultIcon.setForeground(Color.RED);
			fieldResultIcon.setText("➡");
			Thread.sleep(200);
			fieldResultIcon.setText("➡➡");
			Thread.sleep(200);
			fieldResultIcon.setText("➡➡➡");
			Thread.sleep(200);
			fieldResultIcon.setText("➡➡➡➡");
			Thread.sleep(200);
			fieldResultIcon.setText("➡➡➡➡➡");
			Thread.sleep(200);
			fieldResultIcon.setText("➡➡➡➡➡➡");
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Set #") {
			//con.setObjectName(objectNameTextField.getText());
			con.getStockObject(objectNameTextField.getText());
		} else if (e.getActionCommand() == "Set field value") {	
			fieldResultVal.setText("");
			con.setFieldVal(fieldChoice.getSelectedIndex(), fieldValue.getText());
		} else if (e.getActionCommand() == "Show constructor") {
			con.setObjectName(objectNameTextField.getText());
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
		} else if (e.getActionCommand() == "Invoke constructor") {
			int argCount = 0;
			for (Label tx : conTypes) {
				if (tx.getText() != "") {
					argCount ++;
				}
			}
			
			String[] vals = new String[argCount];
			for (int i = 0; i < vals.length; i++) {
				vals[i] = conValues[i].getText();
			}
			con.callConstructor(vals);
		} else if (e.getActionCommand() == "Create array") {
			con.createArray(arrayTypeText.getText(), arraySizeText.getText());
		} else if (e.getActionCommand() == "Set element") {
			con.setElement(arrayChoice.getSelectedIndex());
		} else if (e.getActionCommand() == "Get element") {
			con.readSelectedElement(arrayChoice.getSelectedIndex());
		}  else {
			// TBD
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Choice cho = (Choice)e.getItemSelectable();
		con.setSelectedMethod(cho.getSelectedIndex());
	}
	
	private void resetMethodProperty() {
		for (int i = 0; i < PARAMETER_COUNT; i++) {
			methodTypes[i].setText("");
			methodValues[i].setText("");
		}
	}
	
	private void resetMethods() {	
		methodsChoice.removeAll();
		 for(int i = 0; i < PARAMETER_COUNT; i++) {
	        	methodTypes[i].setText("");
	        	methodValues[i].setText("");
	        }
	}
	
	private void resetFields() {
		fieldName.setText("");
		fieldType.setText("");
		fieldValue.setText("");
		fieldResultIcon.setText("");
		fieldResultVal.setText("");
	}
	
	private void resetConstructors() {
		constructorsChoice.removeAll();
		for(int i = 0; i < PARAMETER_COUNT; i++) {
        	conTypes[i].setText("");
        	conValues[i].setText("");
        }
	}
	
	private void resetConProperty() {
		for (int i = 0; i < PARAMETER_COUNT; i++) {
			conTypes[i].setText("");
			conValues[i].setText("");
		}
	}
	
	private void resetElements() {
		arrayChoice.removeAll();
	}
}
