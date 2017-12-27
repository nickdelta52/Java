package structures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;


public class StudentArrayHeap<P, V> extends AbstractArrayHeap<P, V> {
	

	protected StudentArrayHeap(Comparator<P> comparator) {
		super(comparator);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	protected int getLeftChildOf(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		} else
			return (2 * index + 1);
	}

	@Override
	protected int getRightChildOf(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		} else
			return (2 * index + 2);
	}

	@Override
	protected int getParentOf(int index) {
		if (index < 1) {
			throw new IndexOutOfBoundsException();
		}
		return (index - 1) / 2;
	}

	@Override
	protected void bubbleUp(int index) {
		int hole = index;
		int parent = (hole - 1) / 2;
		while ((hole > 0) && this.comparator.compare(heap.get(hole).getPriority(), heap.get(parent).getPriority()) > 0) {
			this.swap(hole, parent);
			hole = parent;
			parent = (parent - 1) / 2;
		}

		heap.set(hole, heap.get(hole));
	}

	@Override
	protected void bubbleDown(int index) {
		 int largerChild, hole=index, left=getLeftChildOf(index), right=getRightChildOf(index);
		 while (left < heap.size()) { // at least 1 child
		 if (right <= heap.size()-1 && this.comparator.compare(heap.get(left).getPriority(), heap.get(right).getPriority()) < 0)
		 largerChild = right;
		 else
		 largerChild = left;
		 if (this.comparator.compare(heap.get(hole).getPriority(), heap.get(largerChild).getPriority()) >= 0)
		 break;
		 this.swap(hole, largerChild);
		 hole = largerChild;
		 left = (hole*2)+1;
		 right = (hole*2)+2;
		}
	}
}
