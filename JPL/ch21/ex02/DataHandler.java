package ch21.ex02;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public class DataHandler {
	private WeakReference<File> lastFile; // （おそらく）最後に読んだファイル
	Map<Integer, byte[]> dataMap = new WeakHashMap<Integer, byte[]>();
	
	public byte[] readFile(File file) {
		byte[] data;
		
		//　データを記憶しているか調べる
		if (lastFile != null && file.equals(lastFile.get())) {
			System.out.println("Data still is restored");
			data = dataMap.get(new Integer(1));
			if (data != null)
				return data;
		}
		
		// 記憶していないので、読み込む
		data = readBytesFromFile(file);
		lastFile = new WeakReference<File>(file);
		dataMap.put(new Integer(1), data); 
		return data;
	}
	
	public byte[] readBytesFromFile(File file) {
		// テスト用
	    byte[] buf = { 0x41, 0x42, 0x43, 0x0d, 0x0a };
		return buf;
	}
	
	public static void main(String[] args) {
		// テスト用ファイルオブジェクト生成
	    File file = new File("JPL/ch21/ex02/input.dat");
		
		DataHandler handler = new DataHandler();
		handler.readFile(file);
		file = null;
		System.gc();
		
		File file2 = new File("JPL/ch21/ex02/input2.dat");
		handler.readFile(file2); // "Data still is restored"が出力されなければOK
	}
}
