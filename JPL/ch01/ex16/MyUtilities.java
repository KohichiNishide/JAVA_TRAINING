package ch01.ex16;
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
				; //�����F�f�[�^�̓ǂݍ��݂͐������Ă��邩�A���邢�́A
				  //BadDataSetException���X���[���悤�Ƃ��Ă���
			}
		}
	}
	
	//readDataSet�̒�`
	//����͏��null��Ԃ��悤�Ɏ���
	public double[] readDataSet(FileInputStream in) throws IOException {
		int i = 0;
		int b = 0;
		double[] results = new double[4];
		while ((b = in.read()) != -1) { //�t�@�C���̏I���܂œǂ�
			results[i] = b;
			i++;
		}
		return results;
	}
}
