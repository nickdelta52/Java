import java.util.Stack;

public class LeftRightSorter {
	
	public Stack<String> left;
	public Stack<String> right;
	
	public LeftRightSorter() {
		left = new Stack<String>();
		right = new Stack<String>();
	}
	
	public void shiftLeft() {
		// move top element of right to the top of left
		left.push(right.pop());	
	}
	
	
	public void shiftRight() {
		// move top element of left to the top of right
		right.push(left.pop());
	}
	
	
	public void makeRoom(String w) {
		// shift elements as needed until w can be legally pushed onto left
		while(!left.isEmpty())
		{
			if(w.compareTo(left.peek())<0)
			{
				shiftRight();
			}
			else
				break;
			
		}	
	}
	
	
	public void loadStacks(Stack<String> words) {
		// move all the strings from the given stack 'words' into left and right, 
		// maintaining conditions 1-3 discussed in the handout
		
		while(!words.isEmpty())
		{
			makeRoom(words.peek());
			left.push(words.pop());
			while(!right.isEmpty())
			{
				shiftLeft();
			}
		}
		
		
	}
	
	public String wordAt(int n) {
		// returns the nth string in alphabetical order among those stored
		// in the left and right stacks (assume zero-based indexing: the
		// 1st word has index n=0, etc)
		while(!left.isEmpty())
		{
		  shiftRight();
		}
		
		for(int i = 0; i<n; i++)
		{
			shiftLeft();
		}

	 return right.peek();
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		
		
		
		
	}
	//----------------------------------------
	
	
	public void printStacks() {
		System.out.println("Left:");
		for (int i = left.size() - 1; i >= 0; i -= 1) 
			System.out.println("\t" + left.get(i));
		System.out.println("Right:");
		for (int i = right.size() - 1; i >= 0; i -= 1) 
			System.out.println("\t" + right.get(i));		
	}	
}
