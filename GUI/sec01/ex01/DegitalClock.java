package sec01.ex01;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class DegitalClock extends Frame implements Runnable{
	private static final long serialVersionUID = 1L;
	static int h;           //��������ϐ���錾
    static int m;           //��������ϐ���錾
    static int s;           //�b������ϐ���錾
    static int height = 200;
    static int width = 400;
    Thread timerThread;
    
    DegitalClock() {
    	timerThread = new Thread(this);
    	timerThread.start();
    }
    
	public void run(){
	    while(true){
	          h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY); //������
	          m = Calendar.getInstance().get(Calendar.MINUTE);      //������
	          s = Calendar.getInstance().get(Calendar.SECOND);      //�b����
	          repaint();
	          pause(100);
	    }
	}
	public void paint(Graphics g)
	{    
		g.setFont(new Font("Dialog", Font.BOLD, 70));
	    FontMetrics fo = g.getFontMetrics();
        int strWidth = fo.stringWidth(h+":"+m+":"+s);
        g.drawString(h+":"+m+":"+s , width/2 - strWidth/2 , height/2);
	}
	
	void pause(int time){
        try {
        	Thread.sleep(time);
        } catch (InterruptedException e) {}
    }
	
	public static void main(String args[]){	
		DegitalClock clock = new DegitalClock();
	    clock.setSize(width, height);
	    clock.setVisible(true);
	    clock.setResizable(false);
	    clock.addWindowListener(new windowListener());
	}
}

class windowListener extends WindowAdapter
{
	public void windowClosing(WindowEvent e){   //�~�������ꂽ�Ƃ��̏���
	   System.exit(0);
	}
}
