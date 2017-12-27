package structures;

import comparators.ReverseIntegerComparator;
import java.util.Comparator;
import java.util.Iterator;

public class MinQueue<V> implements PriorityQueue<Integer, V> {
	ReverseIntegerComparator comp = new ReverseIntegerComparator();
	StudentArrayHeap<Integer, V> queue = new StudentArrayHeap<Integer, V>(comp);

	@Override
	public PriorityQueue<Integer, V> enqueue(Integer priority, V value) {
		queue.add(priority, value);
		return this;
	}

	@Override
	public V dequeue() {
		return queue.heap.remove(0).getValue();
	}

	@Override
	public V peek() {
		return queue.heap.get(0).getValue();
	}

	@Override
	public Iterator<Entry<Integer, V>> iterator() {
		return queue.heap.iterator();
	}

	@Override
	public Comparator<Integer> getComparator() {
		return comp;
	}

	@Override
	public int size() {
		return queue.size();
	}

	@Override
	public boolean isEmpty() {
		return (size()==0);
	}
}

