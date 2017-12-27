package sorters;

import java.util.Comparator;

import structures.SwapList;

public class InsertionSorter<T> extends AbstractSorter<T> {

	public InsertionSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}


	@Override
	public SwapList<T> sort() {

		int out, in;
		 for(out=1; out<list.size(); out++){ // dividing line
		 in = out; // start shifts at out
		 while(in>0 && list.compare(in, in-1, comparator)<0) {
		 list.swap(in, in-1); // shift right until the
		 in--;
		 }}
		 return list;
}
}