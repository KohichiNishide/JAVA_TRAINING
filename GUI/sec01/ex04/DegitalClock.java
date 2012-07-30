package sec01.ex04;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class DegitalClock extends Frame implements Runnable{
	private static final long serialVersionUID = 1L;
	private static int h;           //時を入れる変数を宣言
	private static int m;           //分を入れる変数を宣言
	private static int s;           //秒を入れる変数を宣言
	private static int height = 200;
	private static int width = 400;
    
    private static final int LARGE_FONT_SIZE = 200;
	private static final int NORMAL_FONT_SIZE = 80;	
	private static final int SMALL_FONT_SIZE = 10;
	private static final int BLANK_SPACE_SIZE = 50;
	
	private static String fontName = "Default";
	private static int fontStyle = Font.PLAIN;
	private static int fontSize = NORMAL_FONT_SIZE;
	private static Color color = Color.BLACK;
	private static Color backgroundColor = Color.WHITE;
	private Graphics buffer;        //オフスクリーンバッファのグラフィックコンテキスト
	private Image back = null;
    
	private Thread timerThread;
	
	private MenuItem propertyItem;
	
	private PropertyDialog pDialog = new PropertyDialog();
    /*
     * コンストラクタ
     */
    DegitalClock() {   	
    	timerThread = new Thread(this);
    	timerThread.start();
    	
    	setTitle("Degital clock");
        setLayout(new FlowLayout());
        setSize(width, height);
               
        //メニューバーの生成
        MenuBar menuBar = new MenuBar();
    	
    	//メニューアイテムの生成
        Menu menuProperty = new Menu("Property");
        propertyItem = new MenuItem("Open");
        menuProperty.add(propertyItem);
        menuBar.add(menuProperty);
        
        //プロパティを押された時の処理
        propertyItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.out.println("Property");
            	pDialog.setVisible(true);
            }
        });
        
        //×を押されたときの処理
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)  {
            	System.exit(0);
            }
        });

        //メニューバーをフレームへ追加
        this.setMenuBar(menuBar);
    }
    
	public void run() {
	    while(true) {
	          h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY); //時を代入
	          m = Calendar.getInstance().get(Calendar.MINUTE);      //分を代入
	          s = Calendar.getInstance().get(Calendar.SECOND);      //秒を代入
	          repaint();
	          pause(100);
	    }
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	public void paint(Graphics g) {    
		back = this.createImage(width, height);  
		buffer = back.getGraphics();
		buffer.setFont(new Font(fontName, fontStyle, fontSize));
		buffer.setColor(color);
		setBackground(backgroundColor);
	    
		drawTimeCenter();
		setSize(width, height);
		g.drawImage(back, 0, 0, this);      //バッファを画面に描画
	}
	
    private void drawTimeCenter() {
    	FontMetrics fo = buffer.getFontMetrics();
        int strWidth = fo.stringWidth(h+":"+m+":"+s);
        int strHeight = fo.getAscent() + fo.getDescent();
        
        width = strWidth + BLANK_SPACE_SIZE;
        height = strHeight + BLANK_SPACE_SIZE;
        
        buffer.drawString(h+":"+m+":"+s, (width - strWidth) / 2, (height - strHeight) / 2 + fo.getMaxAscent());
    }

	private void pause(int time) {
        try {
        	Thread.sleep(time);
        } catch (InterruptedException e) {}
    }
    
	/**
	 * メイン関数
	 */
	public static void main(String args[]) {	
		DegitalClock clock = new DegitalClock();
	    clock.setVisible(true);
	    clock.setResizable(false);
	}
}
