package sets;

import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedNodeIterator<E> implements Iterator<E> {
	LinkedNode<E> head;
	LinkedNode<E> newest;

	// Constructors
	public LinkedNodeIterator(LinkedNode<E> head) {
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
	public E next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		
		E temp = newest.getData();
		newest = newest.getNext();
		return temp;
	}

	@Override
	public void remove() {
		// Nothing to change for this method
		throw new UnsupportedOperationException();
	}
}
