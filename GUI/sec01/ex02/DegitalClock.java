package sec01.ex02;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class DegitalClock extends Frame implements Runnable, ItemListener {
	private static final long serialVersionUID = 1L;
	static int h;           //時を入れる変数を宣言
    static int m;           //分を入れる変数を宣言
    static int s;           //秒を入れる変数を宣言
    static int height = 200;
    static int width = 400;
    static String fontName = "Default";
    static int fontStyle = Font.PLAIN;
    static int fontSize = 70;
    static Color color = Color.BLACK;
    static Color backgroundColor = Color.WHITE;
    Graphics buffer;        //オフスクリーンバッファのグラフィックコンテキスト
    Image back = null;
    
    Thread timerThread;
    Menu menuFont, menuFontSize, menuCharColor, menuBackgroundColor, menuLanguage;
    MenuItem menuFontPlain, menuFontBold, menuFontItalic;
    MenuItem menuFontSizeLarge, menuFontSizeNormal, menuFontSizeSmall;
    MenuItem menuCharRed, menuCharBlue, menuCharBlack;
    MenuItem menuBackgroundRed, menuBackgroundBlue, menuBackgroundWhite;
    /*
     * コンストラクタ
     */
    DegitalClock() {   	
    	timerThread = new Thread(this);
    	timerThread.start();
    	
    	setTitle("Degital clock");
        setLayout(new FlowLayout());
               
        //メニューバーの生成
        MenuBar menuBar = new MenuBar();
    	
    	//メニューの生成
        Menu menuProperty = new Menu("プロパティ");
        
        //メニュー項目の生成
        menuFont = new Menu("フォント");
        menuFontSize = new Menu("フォントサイズ");
        menuCharColor = new Menu("文字色");
        menuBackgroundColor = new Menu("背景色");
        menuLanguage = new Menu("言語");
        
        //メニューへの追加
        menuProperty.add(menuFont);
        menuProperty.add(menuFontSize);
        menuProperty.add(menuCharColor);
        menuProperty.add(menuBackgroundColor);
        menuProperty.addSeparator(); //セパレーター
        menuProperty.add(menuLanguage);
        
        //フォント
        menuFontPlain = new MenuItem("標準");
        menuFontBold = new MenuItem("太字");
        menuFontItalic = new MenuItem("斜体");
        menuFont.add(menuFontPlain);
        menuFont.add(menuFontBold);
        menuFont.add(menuFontItalic);
        
        menuFont.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	fontName = e.getActionCommand();
                if (fontName.equals("標準")) {
                	fontStyle = Font.PLAIN;
                } else if (fontName.equals("太字")) {
                	fontStyle = Font.BOLD;
                } else if (fontName.equals("斜体")) {
                	fontStyle = Font.ITALIC;
                }
                repaint();
            }
        });
        
        //フォントサイズ
        menuFontSizeLarge = new MenuItem("Large");
        menuFontSizeNormal = new MenuItem("Normal");
        menuFontSizeSmall = new MenuItem("Small");
        menuFontSize.add(menuFontSizeLarge);
        menuFontSize.add(menuFontSizeNormal);
        menuFontSize.add(menuFontSizeSmall);
        
        menuFontSize.addActionListener(new ActionListener() {
        	// フォント・オブジェクトの作成
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Large")) {
                	fontSize = 900;
                } else if (e.getActionCommand().equals("Normal")) {
                	fontSize = 70;
                } else if (e.getActionCommand().equals("Small")) {
                	fontSize = 10;
                }
                repaint();
            }
        });
        
        //文字色
        menuCharBlack = new MenuItem("Black");
        menuCharRed = new MenuItem("Red");
        menuCharBlue = new MenuItem("Blue");
        menuCharColor.add(menuCharBlack);
        menuCharColor.add(menuCharRed);
        menuCharColor.add(menuCharBlue);        
        
        menuCharColor.addActionListener(new ActionListener() {
        	// フォント・オブジェクトの作成
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Black")) {
                	color = Color.BLACK;
                } else if (e.getActionCommand().equals("Blue")) {
                	color = Color.BLUE;
                } else if (e.getActionCommand().equals("Red")) {
                	color = Color.RED;
                }
                repaint();
            }
        });
        
        //背景色
        menuBackgroundWhite = new MenuItem("White");
        menuBackgroundRed = new MenuItem("Red");
        menuBackgroundBlue = new MenuItem("Blue");
        menuBackgroundColor.add(menuBackgroundWhite);
        menuBackgroundColor.add(menuBackgroundRed);
        menuBackgroundColor.add(menuBackgroundBlue);        
        
        menuBackgroundColor.addActionListener(new ActionListener() {
        	// フォント・オブジェクトの作成
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("White")) {
                	backgroundColor = Color.WHITE;
                } else if (e.getActionCommand().equals("Blue")) {
                	backgroundColor = Color.BLUE;
                } else if (e.getActionCommand().equals("Red")) {
                	backgroundColor = Color.RED;
                }
                repaint();
            }
        });

        //メニューバーへの追加
        menuBar.add(menuProperty);

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
		back = this.createImage(this.getWidth(),this.getHeight());  
		buffer = back.getGraphics();
		buffer.setFont(new Font(fontName, fontStyle, fontSize));
		buffer.setColor(color);
		setBackground(backgroundColor);
	    FontMetrics fo = buffer.getFontMetrics();
        int strWidth = fo.stringWidth(h+":"+m+":"+s);
        buffer.drawString(h+":"+m+":"+s, width/2 - strWidth/2 , height/2);
		g.drawImage(back, 0, 0, this);      //バッファを画面に描画
	}
	
	void pause(int time) {
        try {
        	Thread.sleep(time);
        } catch (InterruptedException e) {}
    }
		
    public void itemStateChanged(ItemEvent e) {
        CheckboxMenuItem menu = (CheckboxMenuItem)e.getSource();
        if (menu.getState()) {
            System.out.println(menu.getLabel() + " SELECTED");
        } else {
            System.out.println(menu.getLabel() + " DESELECTED");
        }
    }
    
	/**
	 * メイン関数
	 */
	public static void main(String args[]) {	
		DegitalClock clock = new DegitalClock();
	    clock.setSize(width, height);
	    clock.setVisible(true);
	    clock.setResizable(false);
	    clock.addWindowListener(new windowListener());
	}
}

class windowListener extends WindowAdapter
{
	public void windowClosing(WindowEvent e) {   //×を押されたときの処理
	   System.exit(0);
	}
}
