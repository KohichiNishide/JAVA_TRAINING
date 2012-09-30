package ch20.ex10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class StreamTokenizer {
	private static HashMap<String, Integer> wordMap = new HashMap<String, Integer>();

	/**
	 * Process tokenizer(break down & store & print)
	 * @param fileName
	 * @throws IOException 
	 */
	private static void processTokenizer(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;
		while((line = br.readLine()) != null) {
			String[] words = line.split(","); // コンマで単語区切り
			for (String word: words) {
				storeWord(word);
			}
		}
		printWordCountInfo();
	}
	
	/**
	 * Store the word in HashMap
	 * @param word
	 */
	private static void storeWord(String word) {
		int count = 0;
		if (wordMap.containsKey(word)) {
			count = wordMap.get(word);
		}
		wordMap.put(word, ++count);
	}

	/**
	 * Print word & word count
	 */
	private static void printWordCountInfo() {
		Iterator<String> ite = wordMap.keySet().iterator(); 
		while(ite.hasNext()) {
			String key = ite.next();
			Integer value = wordMap.get(key);
		    System.out.println("Word : " + key + ", Count : " + value);
		}
	}
	
	/**
	 * Main function
	 */
	public static void main(String[] args) {
		final String INPUT_FILE_PATH = "JPL/ch20/ex10/input.txt";
		try {
			processTokenizer(INPUT_FILE_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
