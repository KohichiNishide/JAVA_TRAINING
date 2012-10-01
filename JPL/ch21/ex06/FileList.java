package ch21.ex06;

import java.io.*;
import java.util.*;

class FilesList implements Enumeration {
	private String[] files;
	private int counter = 0;

	public FilesList(String[] args) {
		files = args;
	}

	// 要素が残っていれば true
	public boolean hasMoreElements() {
		if (counter < files.length) {
			return true;
		} else {
			return false;
		}
	}

	// 次の要素を返す
	public Object nextElement() {
		InputStream in = null;

		// 次の要素が無ければ例外
		if (!hasMoreElements()) {
			throw new NoSuchElementException("ファイル終了！");
		} else {
			String retFile = files[counter];
			counter++;
			try {
				in = new FileInputStream(retFile);
			} catch (IOException e) {
				System.err.println(files[counter] + ": 処理できない！");
			}
		}
		return in;
	}
}