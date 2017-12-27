package sorters;

import java.util.Comparator;

import structures.SwapList;

public class HeapSorter<T> extends AbstractSorter<T> {

	public HeapSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
		for(int i =list.size()/2-1; i>=0; i--) { // heapify
		      bubbleDown(i, list.size());
			}
			 for(int j=list.size()-1; j>=1; j--) {
			 list.swap(0, j);
			 bubbleDown(0, j);
			 }
			 return list;
	}
	
	private int getLeftChildOf(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		} else
			return (2 * index + 1);
	}

	
	private int getRightChildOf(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		} else
			return (2 * index + 2);
	}
			

			 private void bubbleDown(int start, int end) 
			 {
				 if(end>getRightChildOf(start))
				 {
					if(list.compare(getLeftChildOf(start), getRightChildOf(start), comparator)<0)
					{
						if(list.compare(start, getRightChildOf(start), comparator)<0)
						{
							list.swap(start, getRightChildOf(start));
						bubbleDown(getRightChildOf(start), end);
						}
					}
					 else if(end>getLeftChildOf(start))
						{
							if(list.compare(start, getLeftChildOf(start), comparator)<0)
							{
								list.swap(start, getLeftChildOf(start));
								bubbleDown(getLeftChildOf(start), end);	
						}
					}
					else if(list.compare(start, getLeftChildOf(start), comparator)<0)
						{
							list.swap(start, getLeftChildOf(start));
						bubbleDown(getLeftChildOf(start), end);
						}
					}
				 }
				 
				
	}



