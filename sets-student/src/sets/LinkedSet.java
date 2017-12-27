package sets;

import java.util.Iterator;

/**
 * A LinkedList-based implementation of Set
 */

/********************************************************
 * NOTE: Before you start, check the Set interface in
 * Set.java for detailed description of each method.
 *******************************************************/

/********************************************************
 * NOTE: for this project you must use linked lists
 * implemented by yourself. You are NOT ALLOWED to use
 * Java arrays of any type, or any Collection-based class 
 * such as ArrayList, Vector etc. You will receive a 0
 * if you use any of them.
 *******************************************************/

/********************************************************
 * NOTE: you are allowed to add new methods if necessary, but do NOT add new
 * files (as they will be ignored).
 *******************************************************/

public class LinkedSet<E> implements Set<E> {
	private LinkedNode<E> head = null;

	// Constructors
	public LinkedSet() {
	}

	public LinkedSet(E e) {
		this.head = new LinkedNode<E>(e, null);
	}

	private LinkedSet(LinkedNode<E> head) {
		this.head = head;
	}

	private LinkedSet(E e, LinkedNode<E> node) {
		LinkedNode<E> newHead = new LinkedNode<E>(e, node);
		head = newHead;
	}

	@Override
	public int size() {
		int count = 0;
		LinkedNode<E> newPointer = head;
		while (newPointer != null) {
			count++;
			newPointer = newPointer.getNext();
		}
		return count;
	}

	@Override
	public boolean isEmpty() {
		return (this.size() == 0);
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedNodeIterator<E>(this.head);
	}

	@Override
	public boolean contains(Object o) {
		LinkedNode<E> newPointer = head;
		while (newPointer != null) {
			if (o == newPointer.getData())
				return true;
			else
				newPointer = newPointer.getNext();
		}
		return false;
	}

	@Override
	public boolean isSubset(Set<E> that) {
		int count = 0;
		for (E element : this) {
			if (that.contains(element)){
				count++;
			}
		}
		
		if (this.size() == count){
			return true;
		}
		
		return false;
	}

	@Override
	public boolean isSuperset(Set<E> that) {
		int count = 0;
		for (E element : that) {
			if (this.contains(element)){
				count++;
			}
		}
		
		if (that.size() == count){
			return true;
		}
		
		return false;
	}

	@Override
	public Set<E> adjoin(E e) {
		if (this.contains(e)) {
			return this;
		}

		LinkedNode<E> newPointer = new LinkedNode<E>(e, head);
		LinkedSet<E> newSet = new LinkedSet<E>(newPointer);
		//head=newPointer;
	
		return newSet;
	}

	@Override
	public Set<E> union(Set<E> that) {
		Set<E> set = new LinkedSet<E>();
		if(that.size()==0)
		{return this;}
		if(this.size()==0)
		{return that;}
		for (E element : that) {
			set = set.adjoin(element);
		}
		for (E element : this) {
			set = set.adjoin(element);
		}
		return set;
	}

	@Override
	public Set<E> intersect(Set<E> that) {
		Set<E> set = new LinkedSet<E>();
		for (E element : that)
			if (this.contains(element) == true) {
				set = set.adjoin(element);
			}
		return set;
	}

	@Override
	public Set<E> subtract(Set<E> that) {
		Set<E> set = new LinkedSet<E>();
		
		
		
		for (E element : this)
			if (that.contains(element) == false) {
				set = set.adjoin(element);
			}
		return set;
	}

	@Override
	public Set<E> remove(E e) {
		Set<E> set = new LinkedSet<E>();
		for (E element : this) {
			if (element != e) {
				set = set.adjoin(element);
			}
		}

		return set;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object o) {
		if (!(o instanceof Set)) {
			return false;
		}
		Set<E> that = (Set<E>) o;
		return this.isSubset(that) && that.isSubset(this);
	}

	@Override
	public int hashCode() {
		int result = 0;
		for (E e : this) {
			result += e.hashCode();
		}
		return result;
	}
}
