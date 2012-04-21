
public interface Lookup {
	/** nameと関連づけされた値を返す。
	 * そのような値がなければnullを返す。
	 */
	Object find(String name);
}
