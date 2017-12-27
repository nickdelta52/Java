package stack;


/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List structure
 * to allow for unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {
	
	private LLNode<T> head = null;
	private int topIndex = 0;
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T pop() throws StackUnderflowException {
		
			if(isEmpty())
					{throw new StackUnderflowException();}
			    	else
			    		{T temp = head.getData();
				head = head.getNext();
			    return temp;}
			}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T top() throws StackUnderflowException {
		if(isEmpty())
		{	throw new StackUnderflowException();}
    	else return head.getData();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
    return(size() == 0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		int count = 0;
		LLNode<T> newPointer = head;
		while (newPointer != null) {
			count++;
			newPointer = newPointer.getNext();
		}
		return count;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void push(T elem) {
		LLNode<T> newNode = new LLNode<T>(elem);
	    newNode.setNext(head);
	    head = newNode; 
 
    
	}

}
