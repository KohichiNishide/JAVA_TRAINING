package ch20.ex09;

import java.io.File;
import java.io.IOException;

public class FileInfoReader {
	public static void showFileProperty(File file) throws IOException {
		System.out.println("getName() = " + file.getName());
		System.out.println("getPath() = " + file.getPath());
		System.out.println("getAbsolutePath() = " + file.getAbsolutePath());
		System.out.println("getCanonicalPath() = " + file.getCanonicalPath());
		System.out.println("getParent() = " + file.getParent());
		System.out.println("lastModified() = " + file.lastModified());
		System.out.println("length() = " + file.length());
		System.out.print("list() = ");
		String[] files = file.list();
		if (files != null) {
			for (String f : files) {
				System.out.print(f + ", ");
			}
		} else {
			System.out.print("0");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) throws IOException {
		final String INPUT_FILE_PATH = "JPL/ch20/ex09/input.txt";
		File file = new File(INPUT_FILE_PATH);
		showFileProperty(file);
	}
}