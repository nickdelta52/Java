package structures;

import java.util.Iterator;

public class RecursiveList<T> implements ListInterface<T> {
	private int size;
	private Node<T> head;
	private Node<T> tail; 
	

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new LinkedNodeIterator<T>(head);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ListInterface<T> insertFirst(T elem) {
		if (elem==null)
		{
			throw new NullPointerException();
		}
		else
		{
			size++;
			 if (head == null){ 
			        head = new Node<T>(elem, null);
			        tail = head;
			 }
			    else {
			        Node<T> newNode = new Node<T>(elem);
			        newNode.next = head;
			        head = newNode;
		}
	}
	return this;
	}	
		

	@Override
	public ListInterface<T> insertLast(T elem) {
		if (elem==null)
		{
			throw new NullPointerException();
		}
		else
		{
		size++;
       Node<T> newNode = new Node<T>(elem);
		
		if (head==null) 
		{	
			head = newNode;
			tail = newNode;	
		}
		
		else
		{
			 tail.next = newNode;
			 tail = newNode;
		}
		}
		return this;
	}

	@Override
	public ListInterface<T> insertAt(int index, T elem) {
		int count = 0;
		if (elem==null)
		{
			throw new NullPointerException();
		}
		if(index<0 || index>size())
		{
			throw new IndexOutOfBoundsException();
		}
		if(index==0){
			insertFirst(elem);
		}
		else if(index==this.size()){
			insertLast(elem);
		}
		else
		{
			recursion(head, index, elem, count);
		}
		return this;
		
	}
	
	private void recursion(Node<T> front, int index, T elem, int count)
	{
		if(count==index-1)
		{
		   Node<T> newNode = new Node<T>(elem);
		   size++;
		   newNode.next = front.next;
		   front.next = newNode;
		}
		else
		{
			count++;
		front = front.next;
		recursion(front, index, elem, count);
		}
	}
	

	@Override
	public T removeFirst() {
	
		 if(head==null)
		    {
		    	throw new IllegalStateException();
		    }
		    else
		    {
		    	T data = head.data;
				Node<T> newNode = head;
		    	size--;
		    	head=head.next;
		    	newNode.next = null;
		    	return data;	
		    }
	}

	@Override
	public T removeLast() {
		
		int count = 0;
		if(isEmpty())
	    {
	    	throw new IllegalStateException();
	    }
		else if(head == tail){
			T data = tail.data;
			head = null;
			tail = null;
			size--;
			return data;
		}
		 else
		    {
			 T data = tail.data;
		     removeRecursion(head);
		     return data;	
		    }
		    
	}
	private void removeRecursion(Node<T> node)
	{
		
		if(node.next.next == null){
			node.next = null;
			tail = node;
			size--;
		}
		else{
			 removeRecursion(node.next);
		}
	}

	@Override
	public T removeAt(int i) {
		int count = 1;
		if(i<0 || i>=size)
		{
			throw new IndexOutOfBoundsException();
		}
		if(i == 0)
		{
			removeFirst();
		}
		if(i == size)
		{
			removeLast();
		}
		
		return removeAt(head, i, count);
	}
	
	private T removeAt(Node<T> front, int index, int count)
	{
		
		if(count==index)
		{
		 T temp = front.next.data;
		 front.next = front.next.next;
		   size--;
		   return temp;
		}
		else
		{
			count++;
		front = front.next;
		return removeAt(front, index, count);
		}
		
	}

	@Override
	public T getFirst() {
		if(isEmpty()){
			throw new IllegalStateException();
		}
		return head.data;
	}

	@Override
	public T getLast() {
		if(isEmpty()){
			throw new IllegalStateException();
		}
		return tail.data;
	}

	@Override
	public T get(int i) {
		
		if(i<0 || i>=size)
		{
			throw new IndexOutOfBoundsException(); 
		}
		if(i == 0){
			return head.data;
		}
		if(i == size-1)
			return tail.data;
		int count = 0;
		return getRecursion(head, i, count);
		}
	
	private T getRecursion(Node<T> newNode, int i, int count)
	{
		if(count==i)
		{
		   return newNode.data;
		}
		else
		{
		return getRecursion(newNode.next, i, count+1);
		}
	}

	@Override
	public boolean remove(T elem) {
		
		
		if(elem == null)
		{throw new NullPointerException();}
			else if(isEmpty()){
					return false;
			}
		if(this.getFirst().equals(elem)){
			this.removeFirst();
			return true;
		}
	
		return removeRecur(elem, head);
		
	}
	private boolean removeRecur(T elem, Node<T> newNode)
	{
		
		if(newNode.next == null){
			return false;
		}
		boolean a = false;
		if(newNode.next.data.equals(elem))
	{
		newNode.next = newNode.next.next; 
		a = true;
		size--;
		return a;
	}
	
	else
	{
	newNode = newNode.next;
	return removeRecur(elem, newNode);
	}
	
	}
	


	@Override
	public int indexOf(T elem) {
		if(elem == null)
		{throw new NullPointerException();}
		int count = 0;
		return recurIndexOf(head, count, elem);
		
	}
	
	private int recurIndexOf(Node<T> front, int count, T elem)
	{
		
		if(front == null){
			return -1;
		}
		if (elem.equals(front.data))
			return count;
		else
			count++;
			front = front.next;
			return recurIndexOf(front, count, elem);
			
	}

	@Override
	public boolean isEmpty() {
		return (size==0);
	}
}
	class Node<T> {
		public T data;
		public Node<T> next;
		public Node(T data) { this.data=data;}
		public Node(T data, Node<T> next) {
			this.data = data; this.next=next;
	}
	}


