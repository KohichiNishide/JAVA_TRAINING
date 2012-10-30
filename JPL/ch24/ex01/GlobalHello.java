package ch24.ex01;

import java.util.Locale;
import java.util.ResourceBundle;

public class GlobalHello {
	public static String msg;
	public static void main(String[] args) {
		Locale.setDefault(new Locale("ja","jp")); //ここで切り替える
		ResourceBundle res = ResourceBundle.getBundle("ch24.ex01.GlobalRes");
		
		if (args.length > 0)
			msg = res.getString(GlobalRes.GOODBYE);
		else
			msg = res.getString(GlobalRes.HELLO);
		System.out.println(msg);
	}
}
