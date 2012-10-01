package ch21.ex05;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ArrayBunchList<E> extends AbstractList<E> {
	private final E[][] arrays;
	private final int size;

	public ArrayBunchList(E[][] arrays) {
		this.arrays = arrays.clone();
		int s = 0;
		for (E[] array : arrays)
			s += array.length;
		size = s;
	}
	
	@Override
	public E get(int index) {
		int off = 0;
		for (int i = 0; i < arrays.length; i++) {
			if (index < off + arrays[i].length)
				return arrays[i][index - off];
			off += arrays[i].length;
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}
	
	public E set(int index, E value) {
		int off = 0;
		for (int i = 0; i < arrays.length; i++) {
			if (index < off + arrays[i].length) {
				E ret = arrays[i][index - off];
				arrays[i][index - off] = value;
				return ret;
			}
			off += arrays[i].length;
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}

	@Override
	public int size() {
		return size;
	}
	
	//********************
	//  Iterator
	//********************
	private class ABLIterator implements Iterator<E>{
		private int off; // リストの先頭からのオフセット
		private int array; // 現在処理している配列
		private int pos; // 現在の配列内の位置

		public ABLIterator() {
			off = 0;
			array = 0;
			pos = 0;
			for (array = 0; array < arrays.length; array++) {
				if (arrays[array].length > 0)
					break;
			}
		}
		
		@Override
		public boolean hasNext() {
			return off + pos < size();
		}

		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			E ret = arrays[array][pos++];
			
			while (pos >= arrays[array].length) {
				off += arrays[array++].length;
				pos = 0;
				if (array >= arrays.length)
					break;
			}
			return ret;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	//********************
	//  ListIterator
	//********************
	public class ABLListIterator extends ABLIterator implements ListIterator<E> {
		
		public ABLListIterator() { 
			super();
		}
		
		@Override
		public void add(E e) {
			int addIndex = this.nextIndex();
		    // TBD
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public E previous() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void set(E e) {
			// TODO Auto-generated method stub
			
		}  
	}
}
