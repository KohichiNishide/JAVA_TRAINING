package ch01.ex16;

public class BadDataSetException extends Exception {
	
	//java.lang.Throwable��Serializable���������Ă��邽�߁AserialVersionUID��錾
	private static final long serialVersionUID = 1L;
	private String fileName;
	
	public BadDataSetException() {
		super("�s���ȃf�[�^���ݒ肳��Ă��܂��B");
	}
	
	public void setFileName(String name) {
		fileName = name;
	}
	
	public String getFileName() {
		return fileName;
	}
}
