package largeinteger;

import largeinteger.LLNode;

/** The LargeInteger class
 *  This class represents a large, non-negative integer using a linked list.
 *  Each node stores a single digit. The nodes represent all digits in *reverse* order:
 *  the least significant digit is the first node, and the most significant the last node.
 *  For example, 135642 is represented as 2->4->6->5->3->1 in that order.
 */
public class LargeInteger {
	private LLNode<Integer> head;	// head of the list
	private int size;
	private LLNode<Integer> tail;// size (i.e. number of digits)
	
	// Returns size
	public int size(){
		return size; }
	// Returns the linked list (used only for JUnit test purpose)
	public LLNode<Integer> getList() 
	{ return head; }
	
	public LargeInteger() {
		head = null; size = 0;
		tail = null;
	}
	
	/** Constructor that takes a String as input and constructs the linked list.
	 *  You can assume that the input is guaranteed to be valid: i.e. every character
	 *  in the string is between '0' and '9', and the first character is never '0'
	 *  (unless '0' is the only character in the string). You can use input.charAt(i)-'0'
	 *  to convert the character at index i to the integer value of that digit.
	 *  Remember: the list nodes must be in reverse order as the characters in the string.
	 */
	public LargeInteger(String input) {
		for(int i = 0; i<input.length(); i++)
		{
			LLNode <Integer>newNode = new LLNode<Integer>(input.charAt(i)-'0', this.head);
			head = newNode;
			size++;
		}
	  
	}
	
	/** Divide *this* large integer by 10 and return this.
	 *  Assume integer division: for example, 23/10 = 2, 8/10 = 0 and so on.
	 */
	public LargeInteger divide10() {
		if(size==1)
		{
		   head.data = 0;
		   size=1;
		   return this;
		}
		else
		{
		 head = head.link;
		 size--;
		 return this;
		}
	}
		 
	
	/** Multiply *this* large integer by 10 and return this.
	 *  For example, 23*10 = 230, 0*10 = 0 etc.
	 */
	public LargeInteger multiply10() {
		if(head.data==0)
		{return this;}
		else
		{LLNode<Integer>newNode = new LLNode();
		 newNode.data = 0;
		 newNode.link = this.head;
		 head = newNode;
		 size++;
		 return this;
		}
	}
	
	/** Returns a *new* LargeInteger object representing the sum of this large integer
	 *  and another one (given by that). Your code must correctly handle cases such as
	 *  the two input integers have different sizes (e.g. 2+1000=1002), or there is a
	 *  carry over at the highest digit (e.g. 9999+2=10001).
	 */
	public LargeInteger add(LargeInteger that) {
		LargeInteger number = new LargeInteger();
		LLNode<Integer> newNode1 = this.head;
		LLNode<Integer>newNode2 = that.head;
		int num = 0;
		int carry = 0;
		boolean stop = false;
		while(stop != true)
		{	
			int a = 0;
			int b = 0;
			if(newNode1!=null)
			{
				a = newNode1.data;
				newNode1 = newNode1.link;
				
			}
				
			if(newNode2!=null)
			{
				b = newNode2.data;
				newNode2 = newNode2.link;
			}
			
			num = a + b + carry;
			carry=0;
			 if(num>9)
		      {
		    	  carry = 1;
		    	  num=num%10;  
		      }
			 
			 LLNode<Integer> newNode3 = new LLNode<Integer>(num,null);
			 if(number.head==null)
			 {
				 number.head = newNode3;
                 number.tail = number.head;		 
				 
			 }
			 else
			 {
			   number.tail.link = newNode3;
			   number.tail = newNode3;	 
			 }
			 number.size++;
			 
			 
			if(newNode1 == null && newNode2 == null && carry==0)
			{
				stop = true;
			}
		}
		return number;
	}
	
	/** Returns a new LargeInteger object representing the result of multiplying
	 *  this large integer with a non-negative integer x. You can assume x is either
	 *  a positive integer or 0. Hint: you can use a loop and call the 'add' method
	 *  above to accomplish the 'multiply'.
	 */
	public LargeInteger multiply(int x) {
		LargeInteger number = new LargeInteger();
		if(x==0)
		{
		LLNode<Integer> newNode = new LLNode(0, null);
		number.head = newNode;
		number.size =1;
		return number;
		}
		
		if(x==1)
		{
			LLNode<Integer> newNode = new LLNode(head.data, head.link);
			number.head = newNode;
			number.size = this.size;
			return number;
			
		}
		else 
		{
			LLNode<Integer> newNode = new LLNode(head.data, head.link);
			number.head = newNode;
			number.size = this.size;
			for(int i = 1; i<x; i++)
			{			
				number = add(number);
				
			}
			return number;
		}
		
	}

	/** Recursive method that converts the list referenced by curr_node back to
	 *  a string representing the integer. Think about what's the base case and
	 *  what it should return. Then think about what it should return in non-base case.
	 *  Hint: refer to the 'printing a list backwards' example we covered in lectures.
	 */
	private String toString(LLNode<Integer> curr_node) {
		String output = "";
		LLNode<Integer> newNode = curr_node;
		if(newNode.link==null)
		{
			return newNode.data + "";
		}
		       output = newNode.data + "";
				newNode = newNode.link;
			
			return toString(newNode) + output;
			
	}
	
	/** Convert this list back to a string representing the large integer.
	 *  This is a public method that jump-starts the call to the recursive method above.
	 */
	public String toString() {
		return toString(head);
	}
	
	// Recursive method to compute factorial
	public static LargeInteger factorial(int n) {
		if(n==0) return new LargeInteger("1");
		return factorial(n-1).multiply(n);
	}
	
	// Recursive method to compute power
	public static LargeInteger pow(int x, int y) {
		if(y==0) return new LargeInteger("1");
		return pow(x, y-1).multiply(x);
	}
}
