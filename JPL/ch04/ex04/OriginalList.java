package ch04.ex04;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * String型の要素をソートしてLinkedListに格納するコレクションクラス
 * 使用しているインターフェースはListとSet。
 */
public class OriginalList implements Iterable<String>{
	 List<String> list = new LinkedList<String>();
	 
	 /** 要素をソートした上でリストに格納する。ただし、既に同じ文字列の要素が格納されている場合はAddされない。*/
	 public void Add(String inStr) {
		 Set<String> set = new TreeSet<String>();
		 set.add(inStr);
		 for (String str: list) {
			 set.add(str);
		 }		 
		 list.clear();
		 
		 for (String str: set) {
			 list.add(str);
		 }		 
	 }
	 
	 /** 与えられたindexの要素を取得する */ 
	 public String get(int index) {
		 return list.get(index);
	 }

	@Override
	public Iterator<String> iterator() {
		return list.listIterator();
	}
	
	static void main(String[] args) {
		OriginalList list = new OriginalList();
		for (int i = 0; i < args.length; i++) {
			list.Add(args[i]);
		}
		for (String str: list) {
			System.out.println(str);
		}
	}
}
