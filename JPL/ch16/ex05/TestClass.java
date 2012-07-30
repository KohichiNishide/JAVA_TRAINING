package ch16.ex05;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Marker{}

@Retention(RetentionPolicy.RUNTIME)
@interface SingleValue{
	String value() default "nothing";
}

@Retention(RetentionPolicy.RUNTIME)
@interface DoubleValues{
	String value1() default "nothing";
	String value2() default "nothing";
}

@Marker
@SingleValue("something")
public class TestClass extends Exception{
	private int count;
	public int pCount;
	
	@SingleValue("hoge1")
	@DoubleValues(value1 = "hoge2", value2 = "hoge3")
	private void hoge() {		
	}
	
	@SingleValue("moge1")
	@DoubleValues(value1 = "moge2", value2 = "moge3")
	private void moge() {
	}
	
	public void poge() {
	}
}
