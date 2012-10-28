package ch23.ex01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class StreamPlug implements Runnable{
	InputStream from;
	OutputStream to;
		
	public StreamPlug(InputStream in, OutputStream out) {
		this.from = in;
		this.to = out;
	}
	
	public StreamPlug(PrintStream out, InputStream in) {
		this.from = in;
		this.to = out;
	}
	
	public void run() {
		byte b;
		try {
			while ((b= (byte) from.read()) !=  -1) 
				to.write(b);
		} 
		catch (IOException e) {
		   System.out.println(e);
		}
		finally
		{
			try {
				from.close();
				to.close();		
			} catch (IOException e) {
		   		System.out.println(e);
			}
		}
	}
}
