package ch21.ex04;

/*
 * ShortStringsを拡張すべきか？：
 * listIteratorのAPIをそのまま使用すると便利なので、あえてIteratorの機能しかないShortStringsを拡張する必要はない。
 */

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ShortStrings implements ListIterator<String>{
	private ListIterator<String> strings;
	private String nextShort;
	private String previousShort;
	private final int maxLen;
	
	public ShortStrings(ListIterator<String> strings, int maxLen) {
		this.strings = strings;
		this.maxLen = maxLen;
		nextShort = null;
	}
	
	@Override
	public void add(String str) {
		if (str.length() > maxLen)
			throw new NoSuchElementException();
		strings.add(str);
		previous();
	}

	@Override
	public boolean hasNext() {
		if (nextShort != null)
			return true;
		while (strings.hasNext()) {
			nextShort = strings.next();
			if (nextShort.length() <= maxLen)
				return true;
		}
		nextShort = null;
		return false;
	}

	@Override
	public boolean hasPrevious() {
		if (previousShort != null)
			return true;
		while (strings.hasPrevious()) {
			previousShort = strings.previous();
			if (previousShort.length() <= maxLen)
				return true;
		}
		previousShort = null;
		return false;
	}

	@Override
	public String next() throws NoSuchElementException{
		if (nextShort == null && !hasNext())
			throw new NoSuchElementException();
		String n = nextShort;
		nextShort = null;
		return n;
	}

	@Override
	public int nextIndex() {
		if (nextShort == null && !hasNext())
			throw new NoSuchElementException();
		return strings.nextIndex();
	}

	@Override
	public String previous() {
		if (previousShort == null && !hasPrevious())
			throw new NoSuchElementException();
		String p = previousShort;
		previousShort = null;
		return p;
	}

	@Override
	public int previousIndex() {
		if (previousShort == null && !hasPrevious())
			throw new NoSuchElementException();
		return strings.previousIndex();
	}

	@Override
	public void remove() {
		previous();
		strings.remove();
	}

	@Override
	public void set(String str) {
		previous();
		strings.set(str);
	}

}
