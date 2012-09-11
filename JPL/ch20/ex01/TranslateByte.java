package ch20.ex01;

import java.io.*;

public class TranslateByte {
	static OutputStream createOutputStreamFromInputStream(InputStream input, OutputStream output, String[] args) {
		byte from = (byte) args[0].charAt(0);
		byte to = (byte) args[1].charAt(0);
		int b;
		
		try {
			while ((b = input.read()) != -1) {				
				output.write(b == from ? to : b);				
			}
			input.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return output;
	}
	
	
	public static void main(String[] args) throws IOException {
		String[] strs = {"b", "B"};
		InputStream input = new FileInputStream("JPL/ch20/ex01/input.txt");
		OutputStream output = new FileOutputStream("JPL/ch20/ex01/output.txt");
		TranslateByte.createOutputStreamFromInputStream(input, output, strs);
	}
}
