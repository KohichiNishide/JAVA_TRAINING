package ch03.ex07;

public class ColorAttr extends Attr{
	private ScreenColor myColor; //変換された色
	
	//-----------------------------------------
	// コンストラクタ
	//-----------------------------------------
	public ColorAttr(String name, Object value) {
		super(name, value);
		decodeColor();
	}
	
	public ColorAttr(String name) {
		this(name, "transparent");
	}
	
	public ColorAttr(String name, ScreenColor value) {
		super(name, value.toString());
		myColor = value;
	}
	
	//-----------------------------------------
	// setメソッド
	//-----------------------------------------
	public Object setValue(Object newValue) {
		//スーパークラスのsetValueを最初に行う
		Object retval = super.setValue(newValue);
		decodeColor();
		return retval;
	}
	
	public ScreenColor setValue(ScreenColor newValue) {
		//スーパークラスのsetValueを最初に行う
		super.setValue(newValue.toString());
		ScreenColor oldValue = myColor;
		myColor = newValue;
		return oldValue;
	}

	//-----------------------------------------
	// getメソッド
	//-----------------------------------------
	/** 変換されたScreenColorオブジェクトを返す */
	public ScreenColor getColor() {
		return myColor;
	}
	
	//-----------------------------------------
	// その他メソッド
	//-----------------------------------------
	/** getValue()で得られる記述からScreenColorを設定する */
	protected void decodeColor() {
		if (getValue() == null) {
			myColor = null;
		} else {
			myColor = new ScreenColor(getValue());
		}
	}
	
	/** Name, Valueが共に同値であればTrue、そうでなければFalseを返す */
	public Boolean equals(ColorAttr attr) {
		return (getColor().equals(attr.getColor())) && (getName().equals(attr.getName()));
	}
	
	/** 同値性を示すhashコードを返す */
	public int hashCode() {
		return (getColor().hashCode() + getName().hashCode());
	}
}
