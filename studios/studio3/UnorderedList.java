package studio3;

import java.util.LinkedList;
import java.util.List;

public class UnorderedList<T extends Comparable<T>> implements PriorityQueue<T> {

	public List<T> list;
	
	public UnorderedList() {
		list = new LinkedList<T>();
	}
	
	@Override
	public boolean isEmpty() {
		//
		// FIXME
		//
		int size=list.size();
		if (size==0)
			return true;
		else
		return false;
	}

	@Override
	public void insert(T thing) {
		//
		// FIXME
		//
		list.add(thing);
		
	}

	@Override
	public T extractMin() {
		//
		// FIXME
		//
		int index = 0;
		T min = list.get(0);
		for(int j = 1; j <= list.size() - 1; j++){
			T n = list.get(j);
			if (min.compareTo(n)>0)
				index = j;
				min = list.get(index);
		}
		list.remove(index);
		
		return min;
	}

}
