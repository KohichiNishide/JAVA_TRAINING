import jp.co.dgic.testing.framework.DJUnitTestCase;

public class HelloWorldTest extends DJUnitTestCase {

	public void testMain() {
		HelloWorld.main(null);
		String arg = (String) getArgument(java.io.PrintStream.class, "println", 0);
		assertEquals("Hello, world", arg);
	}
}