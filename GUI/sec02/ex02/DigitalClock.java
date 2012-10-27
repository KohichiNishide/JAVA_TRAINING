package sec02.ex02;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class DigitalClock extends JFrame{
	private static final long serialVersionUID = 1L;
	private final static String TITLE = "Digital clock";
	Thread timerThread;
	private PropertyDialog pDialog = new PropertyDialog();
	private MenuItem propertyItem;
	
	public DigitalClock() {
		DigitalPanel panel = new DigitalPanel();
	    add(panel);
	    
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
        
        //プロパティを押された時の処理
        propertyItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	pDialog.load();
            }
        });
	}
    
	public static void main(String[] args) {
	    DigitalClock clock = new DigitalClock();
	    clock.setTitle(TITLE);
	    clock.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    clock.setSize(400, 200);
	    clock.setResizable(false);
	    clock.setVisible(true);
	}
}
