package ch03.ex07;

public class ColorAttr extends Attr{
	private ScreenColor myColor; //�ϊ����ꂽ�F
	
	//-----------------------------------------
	// �R���X�g���N�^
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
	// set���\�b�h
	//-----------------------------------------
	public Object setValue(Object newValue) {
		//�X�[�p�[�N���X��setValue���ŏ��ɍs��
		Object retval = super.setValue(newValue);
		decodeColor();
		return retval;
	}
	
	public ScreenColor setValue(ScreenColor newValue) {
		//�X�[�p�[�N���X��setValue���ŏ��ɍs��
		super.setValue(newValue.toString());
		ScreenColor oldValue = myColor;
		myColor = newValue;
		return oldValue;
	}

	//-----------------------------------------
	// get���\�b�h
	//-----------------------------------------
	/** �ϊ����ꂽScreenColor�I�u�W�F�N�g��Ԃ� */
	public ScreenColor getColor() {
		return myColor;
	}
	
	//-----------------------------------------
	// ���̑����\�b�h
	//-----------------------------------------
	/** getValue()�œ�����L�q����ScreenColor��ݒ肷�� */
	protected void decodeColor() {
		if (getValue() == null) {
			myColor = null;
		} else {
			myColor = new ScreenColor(getValue());
		}
	}
	
	/** Name, Value�����ɓ��l�ł����True�A�����łȂ����False��Ԃ� */
	public Boolean equals(ColorAttr attr) {
		return (getColor().equals(attr.getColor())) && (getName().equals(attr.getName()));
	}
	
	/** ���l��������hash�R�[�h��Ԃ� */
	public int hashCode() {
		return (getColor().hashCode() + getName().hashCode());
	}
}
