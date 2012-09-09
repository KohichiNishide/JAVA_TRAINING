package ch20.ex04;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class LineReader extends FilterReader  {
	 protected LineReader(Reader in) {
	        super(in);
	 }

    public String readLine() throws IOException {
        String ls = System.getProperty("line.separator");
        StringBuffer sb = new StringBuffer();

        while (!sb.toString().endsWith(ls)) {
            System.out.println(ready());
            sb.append((char)read());
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {

        // 行区切り文字
        String ls = System.getProperty("line.separator");

        // 読み取り元資源
        StringBuffer sb = new StringBuffer();

        sb.append("This ");
        sb.append("is ");
        sb.append("LineReader ");
        sb.append("LineTest.");
        sb.append(ls);
        sb.append("2 Line ");
        sb.append(ls);
        sb.append("3 Line ");
        sb.append(ls);
        sb.append("Last Line will be ");
        sb.append("not read, ");
        sb.append("because this line have ");
        sb.append("not line separator");

        StringReader sr = new StringReader(sb.toString());
        LineReader lr = new LineReader(sr);
        // LineReader lr = new LineReader(new InputStreamReader(System.in));

        // １行目
        System.out.println(lr.readLine());

        // ２行目
        System.out.println(lr.readLine());

        // ３行目
        System.out.println(lr.readLine());

        // ４行目（→行区切り文字が無いので、読めない。無限ループ。）
        System.out.println(lr.readLine());

    }
}
