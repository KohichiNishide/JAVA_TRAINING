package ch01.ex08;
/**
 * ��K���1.8�FPoint�N���X�Ɉ�Ƃ��ēn���ꂽ�I�u�W�F�N�g�̍��W�������̍��W�ɐݒ肷�郁�\�b�h��ǉ�����
 */
public class Point {
	public double x, y;
	public Point (double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void setCordinateData(Point point) {
		x = point.x;
		y = point.y;
	}
}
