package ch03.ex11;

public class SimpleSortDouble extends SortDouble{
	protected void doSort() {
		for (int i = 0; i < getDataLength(); i++) {
			for (int j = i +1; j < getDataLength(); j++) {
				if (compare(i, j) > 0)
					swap(i, j);
			}
		}
		// doSort()����sort()���ĂԂƖ������[�v�ɓ���B
		double[] args = {1.0};
		super.sort(args);
	}
}
