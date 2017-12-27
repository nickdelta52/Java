package guessme;

/**
 * This class defines a linked list node storing an integer.
 * Use primitive type int (do not use wrapper class Integer)
 * You must provide the following methods:
 * - a constructor
 * - a setInfo method and a getInfo method
 * - a setLink method and a getLink method
 */
public class LLIntegerNode {
	private int nodeValue;
	private LLIntegerNode link;
	
	public LLIntegerNode(int inputValue)
	{
		nodeValue = inputValue;
	}
	
	public int getInfo()
	{
		return nodeValue;
	}

	public void setInfo(int info) 
	{ 
		nodeValue = info; 
    }
	
	public LLIntegerNode getLink()
	{
		return link;
	}
	
	public void setLink(LLIntegerNode link)
	{
		this.link = link;
		
	}
}

