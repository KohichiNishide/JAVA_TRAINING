package sec02.ex02;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DigitalClock extends JFrame{
	private static final long serialVersionUID = 1L;
	private final static String TITLE = "Digital clock";
	Thread timerThread;
	private PropertyDialog pDialog;
	private JMenuItem propertyItem;
	private DigitalPanel panel;
	private PropertyData data = new PropertyData();
	
	public DigitalClock() {		
	    //メニューバーの生成
        JMenuBar menuBar = new JMenuBar();    	
    	//メニューの生成
        JMenu menuProperty = new JMenu("Property");  
        propertyItem = new JMenuItem("Open");
        //メニューバーへの追加
        menuProperty.add(propertyItem);
        menuBar.add(menuProperty);       
        //メニューバーをフレームへ追加
        this.setJMenuBar(menuBar);     
	}
	
	public void init() {
		panel = new DigitalPanel(data, this);
		panel.setPreferredSize(new Dimension(400,280));
		getContentPane().add(panel);	  
		pack();
		pDialog = new PropertyDialog(panel, data);
		 //プロパティを押された時の処理
        propertyItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	pDialog.load();
            }
        });
	}
    
	public static void main(String[] args) {
	    DigitalClock clock = new DigitalClock();
	    clock.init();
	    clock.setTitle(TITLE);
	    clock.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    clock.setResizable(false);
	    clock.setVisible(true);
	}
}
