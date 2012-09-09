package ch20.ex07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Attr {
	private final String name;
	private Object value = null;
	
	public Attr(String name) {
		this.name = name;
	}
	
	public Attr(String name, Object value) {
		this.name = name;
		this.value = value;
	}
	
	public Attr(DataInputStream input) throws IOException {
		char[] data = new char[input.read()];
		int i = 0;
		while((i = input.read()) != -1) 
			data[i] = input.readChar();
		name = String.valueOf(data);
		input.close();
	}

	public void addContentToDataOutputStream(DataOutputStream output) throws IOException {
		char[] data = value.toString().toCharArray();
		output.writeInt(data.length);
		for (char c : data) 
			output.writeChar(c);
		output.close();
	}
	
	public String getName() {
		return name;
	}
	
	public Object getValue() {
		return value;
	}
	
	public Object setValue(Object newValue) {
		Object oldVal = value;
		value = newValue;
		return oldVal;
	}
	
	public String toString() {
		return name + "='" + value + ",";
	}
	
	public static void main(String[] args) throws IOException {
		InputStream fin = new FileInputStream("/Users/knishide/Desktop/input.txt");
		DataInputStream in = new DataInputStream(fin);
		Attr attr = new Attr(in);
		attr.setValue("kohichi");
		
		OutputStream fout = new FileOutputStream("/Users/knishide/Desktop/output.txt");
		DataOutputStream out = new DataOutputStream(fout);
		attr.addContentToDataOutputStream(out);
	}
}
