package ch20.ex08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class FileReader {
	static final String INPUT_FILE_PATH = "JPL/ch20/ex08/table_input.txt";
	static final String OUTPUT_FILE_PATH = "JPL/ch20/ex08/table_output.txt";
	
	public static void main(String[] args) throws IOException {
		InputStream fin = new FileInputStream(INPUT_FILE_PATH);
		InputStreamReader ir = new InputStreamReader(fin);
		BufferedReader br = new BufferedReader(ir);

		FileWriter fw = new FileWriter(OUTPUT_FILE_PATH);
	    BufferedWriter bw = new BufferedWriter(fw);
		
		//	読み込み
		String line;
		while((line=br.readLine()) != null)
		{
			if (line.length() > 2 && line.charAt(0) == '%' && line.charAt(1) == '%') {
				//　%%から始まる行のみ書き込み
				bw.write(line.substring(2) + "\r\n", 0, line.length()-1);
			}
		}
		// クローズ処理
		fin.close();
		ir.close();
		br.close();
		bw.close();
		
		// ランダムエントリーを表示
		RandomAccessFile randFile = new RandomAccessFile(OUTPUT_FILE_PATH, "rw");
		
		String readLine;
		long rand = 0;
		while(randFile.getFilePointer() < randFile.length()) {
			rand = (long)(Math.random() * (double)randFile.length());
			randFile.seek(rand);
			readLine = randFile.readLine();
			System.out.println("entry : " + readLine + ", rand : " + rand);
		}
		
		//	クローズ処理
		randFile.close();
	}
}
