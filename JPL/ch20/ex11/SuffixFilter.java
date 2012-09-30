package ch20.ex11;

import java.io.File;
import java.io.FilenameFilter;

public class SuffixFilter implements FilenameFilter{

	private final String suffix;
	
	/**
	 * Constructor
	 * @param suffix
	 */
	public SuffixFilter(String suffix) {
		this.suffix = suffix;
	}
	
	@Override
	/**
	 * Accept
	 * @return If the dir should be output, true. Otherwise, false.
	 * @param suffix
	 */
	public boolean accept(File dir, String name) {
		return name.matches(".*" + suffix + ".*");   
	}
	
	/**
	 * Main function
	 * @param args 0th means file name, 1st means suffix. If either pram is null, IllegalArgumentException occurs.
	 * @exception IllegalArgumentException if file name or suffix is null.
	 */
	public static void main(String[] args) throws IllegalArgumentException {
		if (args[0] == null || args[1] == null) {
			throw new IllegalArgumentException("File name or suffix is null");
		}
		
		File dir = new File(args[0]);
		String[] files = dir.list(new SuffixFilter(args[1]));
		System.out.println(files.length + "dir(s):");
		for (String file : files) {
			System.out.println("\t" + file);
		}
	}
}
