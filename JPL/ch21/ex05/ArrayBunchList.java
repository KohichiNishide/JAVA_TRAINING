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
	
	@Override
	public ListIterator<E> listIterator() {
		return new ABLListIterator();
	}
	
	//********************
	//  ListIterator
	//********************
	public class ABLListIterator implements ListIterator<E> {
		private int off; // リストの先頭からのオフセット
		private int array; // 現在処理している配列
		private int pos; // 現在の配列内の位置
		boolean isForbiddenSet = false;
		public ABLListIterator() { 
			off = 0;
			array = 0;
			pos = 0;
			for (array = 0; array < arrays.length; array++) {
				if (arrays[array].length > 0)
					break;
			}
		}
		
		@Override
		//指定された要素をリストに挿入します (任意のオペレーション)。
		//要素は、next によって返される次の要素があればその要素の直前、および previous によって返される次の要素があればその要素の直後に挿入されます。
		//リストに要素がない場合は、新しい要素がリストの唯一の要素になります。新しい要素は、暗黙のカーソルの前に挿入されます。
		//後続の next の呼び出しは影響を受けず、後続の previous の呼び出しは新しい要素を返します。
		//この呼び出しは、nextIndex または previousIndex の呼び出しによって返される値を 1 増やします。 
		public void add(E e) {
			//TBD
			isForbiddenSet = false;
			throw new UnsupportedOperationException();
		}

		@Override
		//リストを逆方向にトラバースしたときに、リスト反復子がさらに要素を持っている場合に true を返します。
		//つまり、previous の呼び出しが例外をスローすることなく要素を返す場合は、true を返します。 
		public boolean hasPrevious() {
			return off + pos > 0;
		}

		@Override
		//リストの前の要素を返します。
		//このメソッドは、リストを逆方向に反復するために繰り返し呼び出される場合と、前後に移動するために next の呼び出しと組み合わされる場合があります。
		//next と previous の呼び出しを交互に行うと、繰り返し同じ要素が返されます。 
		public E previous() {
			if (!hasPrevious())
				throw new NoSuchElementException();
			E ret = arrays[array][pos--];
			while(pos < 0){
				off -= arrays[array--].length;
				pos = arrays[array].length - 1;
			}
			isForbiddenSet = true;
			return ret;
		}

		@Override
		// 次に previous を呼び出したときに返されることになる要素のインデックスを返します。リスト反復子がリストの先頭にある場合は -1 を返します。 
		public int previousIndex() {
			if (hasPrevious())
				return off + pos -1;
			else
				return -1;
		}

		@Override
		//next または previous から最後に返された要素を指定された要素で置き換えます (任意のオペレーション)。
		//この呼び出しは、前回の next または previous の呼び出し以降に ListIterator.remove と ListIterator.add のどちらも呼び出されていない場合にだけ行うことができます。 
		public void set(E e) {
			if (isForbiddenSet)
				throw new IllegalStateException();
			arrays[array][pos] = e;
		}

		@Override
		//リストを順方向にトラバースしたときに、リスト反復子がさらに要素を持っている場合に true を返します。
		//つまり、next の呼び出しが例外をスローすることなく要素を返す場合は、true を返します。 
		public boolean hasNext() {
			return off + pos < size();
		}

		@Override
		//リスト内の次の要素を返します。
		//このメソッドは、リストを反復するために繰り返し呼び出される場合と、前後に移動するために previous の呼び出しと組み合わされる場合があります。
		//next と previous の呼び出しを交互に行うと、繰り返し同じ要素が返されます。
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
			isForbiddenSet = true;
			return ret;
		}
		
		@Override
		//次に next を呼び出したときに返されることになる要素のインデックスを返します。リスト反復子がリストの末尾にある場合はリストのサイズを返します。 
		public int nextIndex() {
			if (hasNext())
				return off + pos + 1;
			else
				return size();
		}

		@Override
		//next または previous によって返された最後の要素をリストから削除します (任意のオペレーション)。
		//この呼び出しは next または previous の呼び出しごとに 1 回だけ行うことができます。
		//この呼び出しは、前回の next または previous の呼び出し以降に ListIterator.add が呼び出されていない場合にだけ行うことができます。 
		public void remove() {
			// TBD
			isForbiddenSet = false;
			throw new UnsupportedOperationException();
		}  
	}
}
