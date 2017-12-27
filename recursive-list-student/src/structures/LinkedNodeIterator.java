package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedNodeIterator<T> implements Iterator<T> {
	Node<T> head;
	Node<T> newest;

	// Constructors
	public LinkedNodeIterator(Node<T> head) {
		this.head = head;
		newest = head;
	}

	@Override
	public boolean hasNext() {
		if (newest !=  null) {
			return true;
		}
		return false;
	}

	@Override
	public T next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		
		T temp = newest.data;
		newest = newest.next;
		return temp;
	}

	@Override
	public void remove() {
		// Nothing to change for this method
		throw new UnsupportedOperationException();
	}
}

