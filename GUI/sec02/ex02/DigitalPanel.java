package sec02.ex02;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import sec01.ex04.PropertyData;

public class DigitalPanel extends JPanel implements Runnable, Observer{
	private static final long serialVersionUID = 1L;
	private final static int UPDATE_TIME_INTERVAL = 100;
	Thread timerThread;
	
	private static int height = 200;
	private static int width = 400;
	private static final int BLANK_SPACE_SIZE = 50;

	public DigitalPanel() {
		timerThread = new Thread(this);
    	timerThread.start();
	}
	
	public void run(){
	    while(true){
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
        
        SimpleDateFormat sf = new SimpleDateFormat("hh:mm:ss");
        GregorianCalendar cal = new GregorianCalendar();
        String timeStr = sf.format(cal.getTime());       
        
        
        g.setFont(new Font(PropertyData.font, PropertyData.fontStyle, PropertyData.fontSize));
		g.setColor(PropertyData.parseColor(PropertyData.color));
		setBackground(PropertyData.parseColor(PropertyData.backgroundColor));
		FontMetrics met = g.getFontMetrics();
		int strWidth = met.stringWidth(timeStr);
        int strHeight = met.getAscent() + met.getDescent();
        
        width = strWidth + BLANK_SPACE_SIZE;
        height = strHeight + BLANK_SPACE_SIZE;
		setSize(width, height);
        
        g.drawString(timeStr, (getWidth() - met.stringWidth(timeStr)) / 2,
                (getHeight() + met.getAscent() - met.getDescent()) / 2);
    }

	@Override
	public void update(Observable obs, Object obj) {
		repaint();		
	}
}
