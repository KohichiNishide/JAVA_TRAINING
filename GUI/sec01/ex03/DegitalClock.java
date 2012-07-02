package sec01.ex03;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class DegitalClock extends Window implements Runnable, ItemListener, MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;
	private static int h;           //時を入れる変数を宣言
	private static int m;           //分を入れる変数を宣言
	private static int s;           //秒を入れる変数を宣言
	private static int height = 200;
	private static int width = 400;
    
    
	private static final int NORMAL_FONT_SIZE = 100;	
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
	
	PopupMenu pop = new PopupMenu("Property"); //ポップアップメニュー
	
    /*
     * コンストラクタ
     */
    public DegitalClock() {
    	super(new Frame());
    	timerThread = new Thread(this);
    	timerThread.start();
    	
        setLayout(new FlowLayout());
        setSize(width, height);             
        
        //メニュー項目の生成
        menuFont = new Menu("フォント");
        menuFontSize = new Menu("フォントサイズ");
        menuCharColor = new Menu("文字色");
        menuBackgroundColor = new Menu("背景色");
        
        //メニューへの追加
        pop.add(menuFont);
        pop.add(menuFontSize);
        pop.add(menuCharColor);
        pop.add(menuBackgroundColor);
        
        //スタイル
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
        int size = NORMAL_FONT_SIZE;
        while(size < 500) {
        	menuFontSize.add(new MenuItem(Integer.toString(size)));
        	size += 20;
        }       
        menuFontSize.addActionListener(new ActionListener() {
        	// フォントサイズの設定
        	public void actionPerformed(ActionEvent e) {
                fontSize = Integer.valueOf(e.getActionCommand());
                repaint();
            }
        });
        
        //文字色
        menuCharColor.add(new MenuItem("Black"));
        menuCharColor.add(new MenuItem("Red"));
        menuCharColor.add(new MenuItem("Blue"));
        menuCharColor.add(new MenuItem("Cyan"));
        menuCharColor.add(new MenuItem("DarkGray"));
        menuCharColor.add(new MenuItem("Gray"));
        menuCharColor.add(new MenuItem("Green"));
        menuCharColor.add(new MenuItem("LightGray"));
        menuCharColor.add(new MenuItem("Magenta"));
        menuCharColor.add(new MenuItem("Orange"));
        menuCharColor.add(new MenuItem("Pink"));
        menuCharColor.add(new MenuItem("White"));
        menuCharColor.add(new MenuItem("Yellow"));
       
        menuCharColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Black")) {
                	color = Color.BLACK;
                } else if (e.getActionCommand().equals("Blue")) {
                	color = Color.BLUE;
                } else if (e.getActionCommand().equals("Red")) {
                	color = Color.RED;
                } else if (e.getActionCommand().equals("Cyan")) {
                	color = Color.CYAN;
                } else if (e.getActionCommand().equals("DarkGray")) {
                	color = Color.DARK_GRAY;
                } else if (e.getActionCommand().equals("Gray")) {
                	color = Color.GRAY;
                } else if (e.getActionCommand().equals("Green")) {
                	color = Color.GREEN;
                } else if (e.getActionCommand().equals("LightGray")) {
                	color = Color.LIGHT_GRAY;
                } else if (e.getActionCommand().equals("Magenta")) {
                	color = Color.MAGENTA;
                } else if (e.getActionCommand().equals("Orange")) {
                	color = Color.ORANGE;
                } else if (e.getActionCommand().equals("Pink")) {
                	color = Color.PINK;
                } else if (e.getActionCommand().equals("White")) {
                	color = Color.WHITE;
                } else if (e.getActionCommand().equals("Yellow")) {
                	color = Color.YELLOW;
                }
                repaint();
            }
        });
        
        //背景色
        menuBackgroundColor.add(new MenuItem("Black"));
        menuBackgroundColor.add(new MenuItem("Red"));
        menuBackgroundColor.add(new MenuItem("Blue"));
        menuBackgroundColor.add(new MenuItem("Cyan"));
        menuBackgroundColor.add(new MenuItem("DarkGray"));
        menuBackgroundColor.add(new MenuItem("Gray"));
        menuBackgroundColor.add(new MenuItem("Green"));
        menuBackgroundColor.add(new MenuItem("LightGray"));
        menuBackgroundColor.add(new MenuItem("Magenta"));
        menuBackgroundColor.add(new MenuItem("Orange"));
        menuBackgroundColor.add(new MenuItem("Pink"));
        menuBackgroundColor.add(new MenuItem("White"));
        menuBackgroundColor.add(new MenuItem("Yellow"));
       
        menuBackgroundColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Black")) {
                	backgroundColor = Color.BLACK;
                } else if (e.getActionCommand().equals("Blue")) {
                	backgroundColor = Color.BLUE;
                } else if (e.getActionCommand().equals("Red")) {
                	backgroundColor = Color.RED;
                } else if (e.getActionCommand().equals("Cyan")) {
                	backgroundColor = Color.CYAN;
                } else if (e.getActionCommand().equals("DarkGray")) {
                	backgroundColor = Color.DARK_GRAY;
                } else if (e.getActionCommand().equals("Gray")) {
                	backgroundColor = Color.GRAY;
                } else if (e.getActionCommand().equals("Green")) {
                	backgroundColor = Color.GREEN;
                } else if (e.getActionCommand().equals("LightGray")) {
                	backgroundColor = Color.LIGHT_GRAY;
                } else if (e.getActionCommand().equals("Magenta")) {
                	backgroundColor = Color.MAGENTA;
                } else if (e.getActionCommand().equals("Orange")) {
                	backgroundColor = Color.ORANGE;
                } else if (e.getActionCommand().equals("Pink")) {
                	backgroundColor = Color.PINK;
                } else if (e.getActionCommand().equals("White")) {
                	backgroundColor = Color.WHITE;
                } else if (e.getActionCommand().equals("Yellow")) {
                	backgroundColor = Color.YELLOW;
                }
                repaint();
            }
        });

        add(pop);
        addMouseListener(this);
        addMouseMotionListener(this);
        
        this.show();
        this.toFront();
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

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	private MouseEvent start;
	@Override
	public void mousePressed(MouseEvent e) {
		start = e;
		//System.out.println("mousePressed");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int btn = e.getButton();
    	if (btn == MouseEvent.BUTTON3) {
    		//System.out.println("right click");
    		pop.show(this , e.getX() , e.getY());
    	}	
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		int btn = e.getButton();
    	if (btn == MouseEvent.BUTTON1) {
    		// System.out.println("drag");
    		Point eventLocationOnScreen = e.getLocationOnScreen();
    	    setLocation(eventLocationOnScreen.x - start.getX(),
                    eventLocationOnScreen.y - start.getY());
    	}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub	
	}
	
	/**
	 * メイン関数
	 */
	public static void main(String args[]) {	
		DegitalClock clock = new DegitalClock();
	    //clock.setVisible(true);
	    //clock.setResizable(false);
	    clock.addWindowListener(new windowListener());
	}
}

class windowListener extends WindowAdapter
{
	public void windowClosing(WindowEvent e) {   //×を押されたときの処理
	   System.exit(0);
	}
}
