package studio3;

public class OrderedArray<T extends Comparable<T>> implements PriorityQueue<T> {

	public T[] array;
	private int size;
	private int index;
	
	@SuppressWarnings("unchecked")
	public OrderedArray(int maxSize) {
		array = (T[]) new Comparable[maxSize];
		size = 0;
		
	}
	
	@Override
	public boolean isEmpty() {
		//
		// FIXME
		//
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
		if (size ==0){
			array[0] = thing;
			size++;
		}
		else{ 
			if(thing.compareTo(array[0])<0){
			index =0;
			}
			else if(thing.compareTo(array[size-1])>0){
				index = size;
			}
			else{
					for(int i = 0;i <= size - 2; i++){
						if(thing.compareTo(array[i])>0 && thing.compareTo(array[i+1])<0){
						index = i+1;
					}
				}
			}
			size++;
			for (int i=size-1; i > index; i--){
				array[i]=array[i-1];
			}
			array[index] = thing;
		}	
	}
	
	@Override
	public T extractMin() {
		//
		// FIXME
		//
		T min=array[0];
		for(int j = 0;j <= size-2; j++){
			array[j] = array[j+1];
		}
		size--;
		return min;
	}

}
