package ch20.ex02;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TranslateByte extends FilterInputStream  {

    private byte from;
    private byte to;
	
	protected TranslateByte(InputStream input) {
		super(input);
	}
	
    public int read() throws IOException {
        int tmp = super.read();
        return (tmp == from ? to : tmp);
    }
    
    public int read(byte b[]) throws IOException {
        int tmp = super.read(b, 0, b.length);
        return (tmp == from ? to : tmp);
    }

    public int read(byte b[], int offset, int count) throws IOException {
        int tmp = super.read(b, offset, count);
        return (tmp == from ? to : tmp);
    }
    
    public void setFrom(byte from) {
        this.from = from;
    }
    
    public void setTo(byte to) {
        this.to = to;
    }

    public static void main(String[] args) throws IOException {
    	InputStream input = new FileInputStream("JPL/ch20/ex02/input.txt");
    	TranslateByte filter = new TranslateByte(input);
        filter.setFrom((byte)args[0].charAt(0));
        filter.setTo((byte)args[1].charAt(0));
        int b;
        while((b = filter.read()) != -1) {
            System.out.write(b);
            System.out.println(b);
        }
        input.close();
    }
}
