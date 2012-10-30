package sec02.ex02;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class DigitalPanel extends JPanel implements Runnable, Observer{
	private static final long serialVersionUID = 1L;
	private final static int UPDATE_TIME_INTERVAL = 50;
	Thread timerThread;
	private PropertyData data;
	private DigitalClock clock;

	public DigitalPanel(PropertyData data, DigitalClock clock) {
		this.data = data;
		this.clock = clock;
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
        
        g.setFont(new Font(data.font, data.fontStyle, data.fontSize));
		g.setColor(data.parseColor(data.color));
		setBackground(data.parseColor(data.backgroundColor));
		FontMetrics met = g.getFontMetrics();
		
        int strWidth = met.stringWidth(timeStr);
        int strHeight = met.getAscent() + met.getDescent();
        clock.setSize(new Dimension(strWidth, strHeight));
        this.setPreferredSize(null);
        
        g.drawString(timeStr, (getWidth() - met.stringWidth(timeStr)) / 2,
                (getHeight() + met.getAscent() - met.getDescent()) / 2);
    }

	@Override
	public void update(Observable obs, Object obj) {
		this.repaint();		
	}
}
