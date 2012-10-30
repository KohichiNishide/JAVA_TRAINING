package sec02.ex02;

import java.awt.Dimension;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

public class DigitalClock extends JFrame implements Observer{
	private static final long serialVersionUID = 1L;
	private final static String TITLE = "Digital clock";
	Thread timerThread;
	private PropertyDialog pDialog;
	private MenuItem propertyItem;
	private DigitalPanel panel;
	private PropertyData data = new PropertyData();
	
	public DigitalClock() {		
	    //メニューバーの生成
        MenuBar menuBar = new MenuBar();    	
    	//メニューの生成
        Menu menuProperty = new Menu("Property");  
        propertyItem = new MenuItem("Open");
        //メニューバーへの追加
        menuProperty.add(propertyItem);
        menuBar.add(menuProperty);       
        //メニューバーをフレームへ追加
        this.setMenuBar(menuBar);     
	}
	
	public void init() {
		panel = new DigitalPanel(data, this);
		panel.setPreferredSize(new Dimension(400,280));
		getContentPane().add(panel);	  
		pack();
		pDialog = new PropertyDialog(panel, data);
		data.addObserver((Observer)this);
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

	@Override
	public void update(Observable obs, Object obj) {
		/*if (obj != null) {
			getContentPane().setPreferredSize((Dimension)obj);
			pack();
		}*/
	}
}
