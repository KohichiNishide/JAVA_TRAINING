import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;


public class InterpretView extends Frame implements Observer, ActionListener{
	private static final long serialVersionUID = 1L;
	private Label objectNameLabel = new Label("Input class name");
	private Label successLabel = new Label("TBD");
	private TextField objectNameTextField = new TextField("Input class name");
	private Button okButton = new Button("Create object");
	private GridBagLayout gbl = new GridBagLayout();
	private Interpret con;
	
	public InterpretView(Interpret controller) {
		con = controller;
		setTitle("Interpret main view");
	    setSize(600, 200);
	    setLocationRelativeTo(null);
	    setResizable(false);
	    setLayout(gbl);
	    
	    okButton.addActionListener(this);
	    okButton.addActionListener(con);
	    
	    addComponents();
	        
        addWindowListener(con);       
        pack();
        show();
	}
	
	private void addComponents() {
		// ラベルの配置
        //objectNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));      
        //addLabel(objectNameLabel, 0, 0, 1, 1);
        
        successLabel.setFont(new Font("Arial", Font.PLAIN, 20));      
        addLabel(successLabel, 0, 3, 3, 1);
        
        // テキストフィールドの配置
        addTextField(objectNameTextField, 0, 1, 3, 1);
        
        // ボタンフィールドの配置
        addButton(okButton, 2, 2, 1, 1);
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

	@Override
	public void update(Observable obs, Object obj) {
		if (!((ObjectInfo)obs).IsError()) {
			successLabel.setText("Success !!");
		} else {
			successLabel.setText("Failed !!");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		con.setObjectName(objectNameTextField.getText());
		
	}
}
