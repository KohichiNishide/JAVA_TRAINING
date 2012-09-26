package sec02.ex01;

import javax.swing.JFrame;

public class DigitalClock extends JFrame{
	private static final long serialVersionUID = 1L;
	private final static String TITLE = "Digital clock";
	Thread timerThread;
	
	public DigitalClock() {
		DigitalPanel panel = new DigitalPanel();
	    add(panel);
	}
    
	public static void main(String[] args) {
	    DigitalClock clock = new DigitalClock();
	    clock.setTitle(TITLE);
	    clock.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    clock.setSize(300, 200);
	    clock.setVisible(true);
	}
}
