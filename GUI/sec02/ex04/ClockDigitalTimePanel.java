package sec02.ex04;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

public class ClockDigitalTimePanel extends JPanel implements Runnable, Observer{
	private static final long serialVersionUID = 1L;
	private static final int UPDATE_TIME_INTERVAL = 100;
	private static final int BLANK_SPACE_SIZE = 50;
	
	private static int height = 200;
	private static int width = 400;
	
	//Font metrics that will use to store font informations  
	//For example, width of a character  
	private FontMetrics fm; 
	private Thread timerThread;
	private ClockPropertyData data;
	
	public ClockDigitalTimePanel(ClockPropertyData data) {
		this.data = data;
    	
		timerThread = new Thread(this);
    	timerThread.start();
		
    	BevelBorder border = new BevelBorder(BevelBorder.LOWERED);
    	this.setBorder(border);
    	this.setVisible(true);
	}
	
	public void run() {
	    while(true) {
	          repaint();
	          pause(UPDATE_TIME_INTERVAL);
	    }
	}
	
	void pause(int time){
        try {
        	Thread.sleep(time);
        } catch (InterruptedException e) {}
    }

    public void paintComponent(Graphics g) {
    	super.paintComponent(g);  
    	
    	g.setFont(new Font(data.font, data.fontStyle, data.fontSize));     	  
    	g.setColor(data.getColor());
    	setBackground(data.getBackgroundColor());
    	fm=g.getFontMetrics(); 
    	drawTimeCenter(g);
    }
    
    private void drawTimeCenter(Graphics g) {
        int strWidth = fm.stringWidth(timeNow());
        int strHeight = fm.getAscent() + fm.getDescent();
        
        width = strWidth + BLANK_SPACE_SIZE;
        height = strHeight + BLANK_SPACE_SIZE;
        
        JFrame topWindow = (JFrame) SwingUtilities.getWindowAncestor(this);
        topWindow.setSize(new Dimension(width , height)); //TODO
        setSize(new Dimension(width, height));
        g.drawString(timeNow(), (width - strWidth) / 2, (height - strHeight) / 2 + fm.getMaxAscent());
    }
    
    //get current time
    private String timeNow()
    {
      Calendar now = Calendar.getInstance();
      int hrs = now.get(Calendar.HOUR_OF_DAY);
      int min = now.get(Calendar.MINUTE);
      int sec = now.get(Calendar.SECOND);
      
      String time = zero(hrs)+":"+zero(min)+":"+zero(sec);
      
      return time;
    }
    
    private String zero(int num)
    {
      String number=( num < 10) ? ("0"+num) : (""+num);
      return number;                                    //Add leading zero if needed
    }

	@Override
	public void update(Observable source, Object obj) {
		repaint();
	}
}
