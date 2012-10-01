package ch21.ex07;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.ListIterator;

public class Stack {
	private List<Object> list;
	
    public Stack() {
        list = new ArrayList<Object>();
    }
    
    public void push(Object obj) {
        list.add(obj);
    }
    
    public boolean empty() {
    	if (list.size() == 0) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public Object pop() throws IndexOutOfBoundsException, EmptyStackException {
    	if (empty()) 
    		throw new EmptyStackException();
    	
        int index = list.size() - 1;
        Object obj = list.get(index);
        list.remove(index);
        return obj;
    }
    
    public Object peek() throws EmptyStackException{
    	if (empty()) 
    		throw new EmptyStackException();
    	
        int index = list.size() - 1;
        Object obj = list.get(index);
        return obj;
    }
    
    public int search(Object o){
    	if (empty()) 
    		return -1;
    	int count = 1;
    	ListIterator<Object> ite = list.listIterator(list.size());
    	while (ite.hasPrevious()) {
    		Object obj = ite.previous();
    		if (obj.equals(o)) {
    			return count;
    		}
    		++count;
    	}
    	return -1;
    }
}
