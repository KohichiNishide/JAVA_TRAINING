package ch23.ex01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class ProcessManager {
	
	public static Process userProg(String cmd) throws IOException {
		Process proc = Runtime.getRuntime().exec(cmd);
		plugTogether(System.in, proc.getOutputStream());
		plugTogether(System.out, proc.getInputStream());
		plugTogether(System.err, proc.getErrorStream());
		return proc;
	}
	
	private static void plugTogether(InputStream in, OutputStream out) {
		Thread thread = new Thread(new StreamPlug(in, out));
		thread.start();
	}
	
	private static void plugTogether(PrintStream in, InputStream out) {
		Thread thread = new Thread(new StreamPlug(in, out));
		thread.start();
	}
	
	public static void main(String[] args) throws IOException{
		Process proc = ProcessManager.userProg("ls");
		try {
			proc.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
