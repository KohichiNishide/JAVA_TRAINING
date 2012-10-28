package ch23.ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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
		try {
			String line;
			int i = 0;
			BufferedReader buf =
				new BufferedReader( new InputStreamReader(from) );
			BufferedWriter outFile =
                                new BufferedWriter( new OutputStreamWriter(to) );
			while( (line=buf.readLine()) != null ) {
				StringBuffer out = new StringBuffer();
				i++;
				out.append(Integer.toString(i));
				out.append(":");
				out.append(line);
				outFile.write(out.toString());
				outFile.newLine();
				System.out.println(out);
			}
			buf.close();
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
