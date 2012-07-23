package ch14.ex07;

public class Babble extends Thread{
	static boolean doYield; //他のスレッドに実行を譲るのか？
	static int howOften; //表示する回数
	private String word; //このスレッドの単語
	
	Babble(String whatToSay) {
		word = whatToSay;
	}
	
	public void run() {
		for (int i = 0; i < howOften; i++) {
			System.out.println(word);
			if (doYield)
				Thread.yield(); //他のスレッドを走らせる
		}
	}
	
	public static void main(String[] args) {
		doYield = new Boolean(args[0]).booleanValue();
		howOften = Integer.parseInt(args[1]);
		
		//各単語に対してスレッドを生成
		for (int i = 2; i < args.length; i++)
			new Babble(args[i]).start();
	}
}
