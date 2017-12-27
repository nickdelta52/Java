package structures;


import java.util.NoSuchElementException;



public class Queue<T> implements UnboundedQueueInterface<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size = 0;
	private Queue<T> queue;

	public Queue() {		
            this.head = null;
            this.tail = null;
    }
	
	public Queue(Queue<T> other) {
		    Node<T> newNode = other.head;
            while(newNode!=null)
            {
            	this.enqueue(newNode.data);
            	newNode = newNode.next;
            }  
            
	}
	
	@Override
	public boolean isEmpty() {
           return(size==0);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void enqueue(T element) {
		size++;
      Node<T> newNode = new Node<T>(element);
		
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

	@Override
	public T dequeue() throws NoSuchElementException {
            if(isEmpty())
            {
            	throw new NoSuchElementException();
            }
            Node<T> newNode = head;
            head = head.next;
            size--;
            return newNode.data;         
	}

	@Override
	public T peek() throws NoSuchElementException {
		if(isEmpty())
		{	throw new NoSuchElementException();}
    	else return head.data;

	}

	
	@Override
	public UnboundedQueueInterface<T> reversed() {
		queue = new Queue<T>();
		Node<T> newNode = this.head;
		while(newNode!=null)
		{
			queue.size++;
		    Node<T> newNode2 = new Node<T>(newNode.data);
		    if(queue.head == null)
		    {
		    	queue.head = newNode2;
		    }
		    else
		    {
		    	newNode2.next = queue.head;
		    	queue.head = newNode2;
		    }
			newNode = newNode.next;
		}
		
			return queue;
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

