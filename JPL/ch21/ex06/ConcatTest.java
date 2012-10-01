package ch21.ex06;

import static org.junit.Assert.*;
import java.io.IOException;

import org.junit.Test;

public class ConcatTest {

	@Test
	public void test() {
		String str1 = "JPL/ch21/ex06/test1.txt";
		String str2 = "JPL/ch21/ex06/test2.txt";
		String str3 = "JPL/ch21/ex06/test3.txt";
		String[] args = {str1, str2, str3};
		
		try {
			Concat.main(args);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
