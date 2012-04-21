/**
 * 練習問題1.15:addとremoveメソッドを宣言したインターフェースを、Lookupを拡張して定義する
 * その拡張したインターフェースを新たなクラスに実装する。
 */

public class ExtendedSimpleLookup implements ExtendedLookup{
	private String[] names = new String[10];
	private Object[] values = new Object[10];
	
	public void add(Object value) {
		/**
		 * 値をvaluesに追加する
		 * それと同時に、"Key+index番号"を名前をnamesに登録する。
		 */
		for (int i = 0; i < values.length; i++) {
			if (values[i] == null) {
				values[i] = value;
				names[i] = "Key" + i;
				return;
			}
		}
	}
	
	public void remove(String name) {
		/**
		 * nameと関連づけされた値をvaluesから削除する。
		 * それと同時にnameもnamesから削除する。
		 */
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(name)) {
				values[i] = null;
				names[i] = null;
				return;
			}
		}
	}

	public Object find(String name) {
		/** nameと関連づけされた値を返す。
		 * そのような値がなければnullを返す。
		 */
		for (int i = 0; i < names.length; i++) {
			if (names[i] != null) {
				if (names[i].equals(name))
					return values[i];
			}
		}
		return null; //見つからなかった
	}
}
