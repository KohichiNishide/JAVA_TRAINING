package sec02.ex01;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.JPanel;

public class DigitalPanel extends JPanel implements Runnable{
	private static final long serialVersionUID = 1L;
	private final static int UPDATE_TIME_INTERVAL = 100;
	Thread timerThread;

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
        
        FontMetrics met = g.getFontMetrics();
        
        g.drawString(timeStr, (getWidth() - met.stringWidth(timeStr)) / 2,
                (getHeight() + met.getAscent() - met.getDescent()) / 2);
    }
}
