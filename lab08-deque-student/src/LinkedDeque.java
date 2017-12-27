import java.util.NoSuchElementException;

import structures.T;
import structures.RecursiveList.Node;

public class LinkedDeque<T> implements Deque<T> {

	private DLNode<T> head;
	private DLNode<T> tail;
	
	@Override
	public void addToFront(T element) {
		head = new DLNode<T>(element, head, null);
		if(head.next == null) {
			tail = head;
		}
		else {
			head.next.prev = head;
		}
	}

	@Override
	public T removeFront() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		T data = head.data;
		if(head.next != null) {
			head = head.next;
			head.prev = null;
		}
		else {
			head = null;
			tail = null;
		}
		return data;
	}

	@Override
	public T first() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return head.data;
	}

	@Override
	public void addToRear(T element) {
    DLNode<T> newNode = new DLNode<T>(element);
		
		if (head==null) 
		{	
			head = newNode;
			tail = newNode;	
		}
		
		else
		{
			 tail.next = newNode;
			 newNode.prev = tail;
			 tail = newNode;
			 
		}
		}
	

	@Override
	public T removeRear() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		T data = tail.data;
		if(tail.prev != null) {
			tail = tail.prev;
			tail.next = null;
		}
		else
		{
			head = null;
			tail = null;
		}
			
		return data;
	}

	@Override
	public T last() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return tail.data;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

}