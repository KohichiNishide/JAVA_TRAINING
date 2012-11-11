package sec02.ex03;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToggleButton;
import javax.swing.JWindow;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ClockMainWindow extends JWindow implements MouseListener, MouseMotionListener, Observer, ChangeListener {
	private static final long serialVersionUID = 1L;
	private static int height = 200;
	private static int width = 300;
	
	private GridBagLayout gbl = new GridBagLayout();
	private ClockPropertyData data = new ClockPropertyData(); //プロパティデータ
	private JPopupMenu pop = new ClockMenuPopup(data); //ポップアップメニュー
	private JPanel digitalTimePanel = new ClockDigitalTimePanel(data);
	private JPanel analogTimePanel = new ClockAnalogTimePanel(data);
	
    /*
     * コンストラクタ
     */
    public ClockMainWindow() {
        setLayout(gbl);    
        digitalTimePanel.add(pop);
        addPanel(digitalTimePanel, 0, 0, 1, 1);
        addMouseListener(this);
        addMouseMotionListener(this);
        
        setSize(width, height);
        this.setVisible(true);
    }
    
    private void addPanel(JPanel panel, int x, int y, int w, int h) {
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
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
    
    public void createChangePanel(){
        getContentPane().removeAll();
        JPanel newPanel = new JPanel();
        getContentPane().add(newPanel);
        System.out.println("new panel created");//for debugging purposes
        validate();
        setVisible(true);
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
    	if (btn == MouseEvent.BUTTON1 || btn == MouseEvent.BUTTON3) {
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
	
	@Override
	public void update(Observable event, Object obj) {
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		JToggleButton btn = (JToggleButton)e.getSource();
	      if (btn.isSelected()) {
	         btn.setText("Analog Mode");
	      } else {
	         btn.setText("Digital Mode");
	      }
	}

	/**
	 * メイン関数
	 */
	public static void main(String args[]) {	
		ClockMainWindow clock = new ClockMainWindow();
	    clock.addWindowListener(new windowListener());
	}
}

class windowListener extends WindowAdapter
{
	public void windowClosing(WindowEvent e) {   //×を押されたときの処理
	   System.exit(0);
	}
}