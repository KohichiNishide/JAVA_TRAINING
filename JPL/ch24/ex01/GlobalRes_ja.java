package ch24.ex01;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class GlobalRes_ja extends ResourceBundle{

	@Override
	public Enumeration<String> getKeys() {
		return null;
	}

	@Override
	protected Object handleGetObject(String key) {
		if (key.equals("hello")) return "こんにちは";
        if (key.equals("goodbye")) return "さようなら";
	 	return null;
	}

}
