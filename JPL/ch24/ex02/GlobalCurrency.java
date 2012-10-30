package ch24.ex02;

import java.util.Currency;
import java.util.Locale;

public class GlobalCurrency {
	public static void main(String[] args) {
		Locale[] locales = {Locale.CANADA, Locale.FRANCE, Locale.UK, Locale.CHINA, Locale.GERMANY, Locale.US};
		for (Locale l: locales) {
			Currency c = Currency.getInstance(l);
			System.out.println(c.getCurrencyCode() + ", " + c.getSymbol(l));
		}
	}
}
