package ch04.ex04;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * String�^�̗v�f���\�[�g����LinkedList�Ɋi�[����R���N�V�����N���X
 * �g�p���Ă���C���^�[�t�F�[�X��List��Set�B
 */
public class OriginalList implements Iterable<String>{
	 List<String> list = new LinkedList<String>();
	 
	 /** �v�f���\�[�g������Ń��X�g�Ɋi�[����B�������A���ɓ���������̗v�f���i�[����Ă���ꍇ��Add����Ȃ��B*/
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
	 
	 /** �^����ꂽindex�̗v�f���擾���� */ 
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
