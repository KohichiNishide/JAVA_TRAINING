package ch20.ex05;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FindWord {
	static void main(String[] args) throws IOException {
		if (args.length != 2)
			throw new IllegalArgumentException("need word and file");
		
		String match = args[0];
		FileReader fileIn = new FileReader(args[1]);
		LineNumberReader in = new LineNumberReader(fileIn);
		
		in.setLineNumber(1);
        boolean isFound = false;
        while (in.ready()) {
            String readLine = in.readLine();
            if (readLine.indexOf(match) != -1) {
                System.out.println((in.getLineNumber() -1) + " : " +readLine);
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("The word is not found");
        }
	}
}
