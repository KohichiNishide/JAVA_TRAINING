package ch16.ex04;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Marker{}

@Retention(RetentionPolicy.RUNTIME)
@interface SingleValue{
	String value() default "nothing";
}

@Marker
@SingleValue("something")
public class TestClass {

}
