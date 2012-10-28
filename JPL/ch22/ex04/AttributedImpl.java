package ch22.ex04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class AttributedImpl implements Attributed, Iterable<Attr>, Observer{
	protected Map<String, Attr> attrTable = new HashMap<String, Attr>();

	@Override
	public void add(Attr newAttr) {
		newAttr.addObserver(this);
		attrTable.put(newAttr.getName(), newAttr);
	}

	@Override
	public Attr find(String name) {
		return attrTable.get(name);
	}

	@Override
	public Attr remove(String name) {
		Attr removed = attrTable.remove(name);
		removed.deleteObservers();
		return removed;
	}

	@Override
	public Iterator<Attr> iterator() {
		return attrs();
	}
	
	@Override
	public Iterator attrs() {
		return attrTable.values().iterator();
	}

	@Override
	public void update(Observable attr, Object whichName) {
		System.out.println("Value updated from " + whichName);
	}
}
