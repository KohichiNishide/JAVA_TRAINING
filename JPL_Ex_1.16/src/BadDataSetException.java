
public class BadDataSetException extends Exception {
	
	//java.lang.ThrowableがSerializableを実装しているため、serialVersionUIDを宣言
	private static final long serialVersionUID = 1L;
	private String fileName;
	
	public BadDataSetException() {
		super("不正なデータが設定されています。");
	}
	
	public void setFileName(String name) {
		fileName = name;
	}
	
	public String getFileName() {
		return fileName;
	}
}
