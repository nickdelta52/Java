package sorters;

import java.util.Comparator;

import structures.SwapList;

public class QuickSorter<T> extends AbstractSorter<T> {

	public QuickSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
			 recQuickSort(0, list.size()-1);
			 return list;
			}
	
	protected void recQuickSort(int low, int high) {
		 if(low < high) {
		 int p = partition(low, high); // p is split point
		 recQuickSort(low, p-1);
		 recQuickSort(p+1, high);
		 }
		}
	
	public int partition(int low, int high) {
		 
		 int storeIndex = low;
		 int j = 0;
		 list.swap((high+low)/2, high);
		 for(j=low; j<=high-1; j++) {
			 if(list.compare(j, high, comparator) <= 0) {
		 list.swap(j, storeIndex);
		 storeIndex++;
		 }
		 }
		 list.swap(storeIndex, high);
		 return storeIndex;
		}
	}


