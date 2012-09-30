package ch21.ex01;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class LineReader extends FilterReader  {
	 protected LineReader(Reader in) {
	        super(in);
	 }

    public String readLine() throws IOException {
        String line = System.getProperty("line.separator");
        StringBuffer sb = new StringBuffer();

        while (!sb.toString().endsWith(line)) {
        	if (!ready()) break;
            //System.out.println("Reading...");
            sb.append((char)read());
        }
        return sb.toString();
    }
}
