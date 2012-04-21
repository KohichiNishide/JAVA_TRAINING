
/**
 * 練習問題1.2：HelloWorldの一部を変更して、どのようなエラーが発生するか調べる。
 */

private class HelloWorld {
	/** HelloWorldクラスをprivate宣言にすると以下のエラーが発生。
	 * "Illegal modifier for the class HelloWorld; only public, abstract & final are permitted"
	 * 
	 * 一方、HelloWorldクラスをpublic宣言に戻し、mainメソッドをprivate宣言すると、コンパイルは成功する。
	 */
	public static void main (String[] args) {
		System.out.println("Hello, world");
	}
}
