import java.io.FileInputStream;
import java.io.IOException;

public class MyUtilities {
	public double [] getDataSet(String setName) throws BadDataSetException {
		String file = setName + ".txt";
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			return readDataSet(in);
		} catch (IOException e) {
			BadDataSetException excep = new BadDataSetException();
			excep.setFileName(file);
			throw excep;
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				; //無視：データの読み込みは成功しているか、あるいは、
				  //BadDataSetExceptionをスローしようとしている
			}
		}
	}
	
	//readDataSetの定義
	//今回は常にnullを返すように実装
	public double[] readDataSet(FileInputStream in) throws IOException {
		int i = 0;
		int b = 0;
		double[] results = new double[4];
		while ((b = in.read()) != -1) { //ファイルの終わりまで読む
			results[i] = b;
			i++;
		}
		return results;
	}
}
