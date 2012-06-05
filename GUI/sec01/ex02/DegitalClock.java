package sec01.ex02;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class DegitalClock extends Frame implements Runnable, ItemListener {
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
	private Menu menuFont, menuFontSize, menuCharColor, menuBackgroundColor;
	private MenuItem menuFontPlain, menuFontBold, menuFontItalic; //メニューフォントアイテム
	private MenuItem menuFontSizeLarge, menuFontSizeNormal, menuFontSizeSmall; //メニューフォントサイズアイテム
	private MenuItem menuCharRed, menuCharBlue, menuCharBlack; //メニュー文字色アイテム
	private MenuItem menuBackgroundRed, menuBackgroundBlue, menuBackgroundWhite; //メニュー背景色アイテム
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
    	
    	//メニューの生成
        Menu menuProperty = new Menu("プロパティ");
        
        //メニュー項目の生成
        menuFont = new Menu("フォント");
        menuFontSize = new Menu("フォントサイズ");
        menuCharColor = new Menu("文字色");
        menuBackgroundColor = new Menu("背景色");
        
        //メニューへの追加
        menuProperty.add(menuFont);
        menuProperty.add(menuFontSize);
        menuProperty.add(menuCharColor);
        menuProperty.add(menuBackgroundColor);
        
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
        menuFontSizeLarge = new MenuItem("大");
        menuFontSizeNormal = new MenuItem("中");
        menuFontSizeSmall = new MenuItem("小");
        menuFontSize.add(menuFontSizeLarge);
        menuFontSize.add(menuFontSizeNormal);
        menuFontSize.add(menuFontSizeSmall);
        
        menuFontSize.addActionListener(new ActionListener() {
        	// フォント・オブジェクトの作成
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("大")) {
                	fontSize = LARGE_FONT_SIZE;
                } else if (e.getActionCommand().equals("中")) {
                	fontSize = NORMAL_FONT_SIZE;
                } else if (e.getActionCommand().equals("小")) {
                	fontSize = SMALL_FONT_SIZE;
                }
                repaint();
            }
        });
        
        //文字色
        menuCharBlack = new MenuItem("黒色");
        menuCharRed = new MenuItem("赤色");
        menuCharBlue = new MenuItem("青色");
        menuCharColor.add(menuCharBlack);
        menuCharColor.add(menuCharRed);
        menuCharColor.add(menuCharBlue);        
        
        menuCharColor.addActionListener(new ActionListener() {
        	// フォント・オブジェクトの作成
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("黒色")) {
                	color = Color.BLACK;
                } else if (e.getActionCommand().equals("青色")) {
                	color = Color.BLUE;
                } else if (e.getActionCommand().equals("赤色")) {
                	color = Color.RED;
                }
                repaint();
            }
        });
        
        //背景色
        menuBackgroundWhite = new MenuItem("白色");
        menuBackgroundRed = new MenuItem("赤色");
        menuBackgroundBlue = new MenuItem("青色");
        menuBackgroundColor.add(menuBackgroundWhite);
        menuBackgroundColor.add(menuBackgroundRed);
        menuBackgroundColor.add(menuBackgroundBlue);        
        
        menuBackgroundColor.addActionListener(new ActionListener() {
        	// フォント・オブジェクトの作成
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("白色")) {
                	backgroundColor = Color.WHITE;
                } else if (e.getActionCommand().equals("青色")) {
                	backgroundColor = Color.BLUE;
                } else if (e.getActionCommand().equals("赤色")) {
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
