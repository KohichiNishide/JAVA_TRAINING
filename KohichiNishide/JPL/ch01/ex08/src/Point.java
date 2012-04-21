/**
 * 練習問題1.8：Pointクラスに引数として渡されたオブジェクトの座標を自分の座標に設定するメソッドを追加する
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
