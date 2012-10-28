package ch23.ex02;

import java.io.IOException;

public class Printer {	
	public static void main(String[] args) throws IOException {
		if(args[0] ==  null)
			throw new IllegalArgumentException("command is invalid");
		Process child = Runtime.getRuntime().exec(args[0]);
		Thread thread1 = new Thread(new StreamPlug(System.in, child.getOutputStream()));
		Thread thread2 = new Thread(new StreamPlug(System.out, child.getInputStream()));
		//Thread thread3 = new Thread(new StreamPlug(System.err, child.getErrorStream()));
		thread1.start();
		thread2.start();
		//thread3.start();
		try {
			child.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
