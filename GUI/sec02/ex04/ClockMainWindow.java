package sec02.ex04;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import sec01.ex04.PropertyData;

public class ClockMainWindow extends JFrame implements MouseListener, MouseMotionListener, Observer{
	private static final long serialVersionUID = 1L;
	private static int height = 100;
	private static int width = 200;
	
	private GridBagLayout gbl = new GridBagLayout();
	private ClockPropertyData data = new ClockPropertyData(); //プロパティ�??タ
	private ClockPropertyDialog dialog = new ClockPropertyDialog(data);
	private JPopupMenu pop = new ClockMenuPopup(data); //ポップア�??メニュー
	private JPanel digitalTimePanel = new ClockDigitalTimePanel(data);
	private JPanel analogTimePanel = new ClockAnalogTimePanel(data);
	private JPanel smallAnalogTimePanel = new ClockPanel();
	//���j���[�o�[�̐���
    MenuBar menuBar = new MenuBar();
    
    private MenuItem propertyItem;
    private MenuItem degitalModeItem;
    private MenuItem analogModeItem;
	
    /*
     * コンストラクタ
     */
    public ClockMainWindow() {
        setLayout(gbl);    
        //digitalTimePanel.add(pop);
        //analogTimePanel.add(pop);
        addPanel(digitalTimePanel, 0, 0, 1, 1);
        addMouseListener(this);
        addMouseMotionListener(this);
        data.addObserver(this);
        
        setSize(width, height);
        this.setResizable(false);
        
        //���j���[�o�[�̐���
        MenuBar menuBar = new MenuBar();
    	
    	//���j���[�A�C�e���̐���
        Menu menuProperty = new Menu("Property");
        propertyItem = new MenuItem("Open Dialog");
        degitalModeItem = new MenuItem("Digital Mode");
        analogModeItem = new MenuItem("Analog Mode");
        menuProperty.add(propertyItem);
        menuProperty.add(degitalModeItem);
        menuProperty.add(analogModeItem);
        menuBar.add(menuProperty);
        
        //�v���p�e�B�������ꂽ���̏���
        propertyItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dialog.load();
            }
        });
        
        degitalModeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	data.setDigitalClockMode();
            }
        });
        
        analogModeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	data.setAnalogClockMode();
            }
        });
        
        //�~�������ꂽ�Ƃ��̏���
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)  {
            	data.setData(e.getWindow().getX(), e.getWindow().getY());
            	System.exit(0);
            }
        });
        //���j���[�o�[���t���[���֒ǉ�
        setMenuBar(menuBar);
        setBounds(data.x, data.y, width, height);
        this.setVisible(true);
        this.setBackground(Color.WHITE);
    }
    
    private void addPanel(JPanel panel, int x, int y, int w, int h) {
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.8d;
        gbc.weighty = 0.8d;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.anchor = GridBagConstraints.NORTH;
        //gbc.insets = new Insets(10, 10, 10, 10);
        gbl.setConstraints(panel, gbc);
        add(panel);
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
    	if ((e.getModifiers() & java.awt.event.MouseEvent.BUTTON3_MASK) != 0) {
    		//System.out.println("right click");
    		//pop.show(this , e.getX() , e.getY());
    	}	
	}

	@Override
	public void mouseDragged(MouseEvent e) {
    	if ((e.getModifiers() & java.awt.event.MouseEvent.BUTTON1_MASK) != 0)  {
    		// System.out.println("drag");
    		Point eventLocationOnScreen = e.getLocationOnScreen();
    	    setLocation(eventLocationOnScreen.x - start.getX(),
                    eventLocationOnScreen.y - start.getY());
    	}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	
	@Override
	public void update(Observable event, Object arg) {
		if (arg == null)
			return;
		
		String str = (String) arg;
		if (str.equals("analog")) {
			getContentPane().removeAll();
			setSize(500, 400);
			
//			JLabel label = new JLabel();
//
//			ImageIcon icon = new ImageIcon("GUI/sec02/ex04/resource/clock.png");
//			label.setIcon(icon);
			
			addPanel(analogTimePanel, 0, 0, 1, 1);
			this.add(smallAnalogTimePanel);
			//this.add(label);
			this.setLayout(null);
			smallAnalogTimePanel.setBounds(370, 40, 100, 100);
			//label.setBounds(350, 190, 150, 150);
			analogTimePanel.setVisible(true);
			smallAnalogTimePanel.setVisible(true);
			
		} else if (str.equals("digital")) {
			getContentPane().removeAll();
			addPanel(digitalTimePanel, 0, 0, 1, 1);
			digitalTimePanel.setVisible(true);
		} else {
			System.out.println("Fatal error!");
		}
	}

	public static void main(String args[]) {	
		ClockMainWindow clock = new ClockMainWindow();
	}
}