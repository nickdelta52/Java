package fizzbuzz;

public class FizzBuzz {
	private final int fizzNumber;
	private final int buzzNumber;

	/**
	 * Construct an object that can compute fizzbuzz values for a game of 
	 * Fizz and Buzz.
	 * 
	 * @param fizzNumber: an integer between 1 and 9
	 * @param buzzNumber: an integer between 1 and 9
	 */
	public FizzBuzz(int fizzNumber, int buzzNumber) {
		this.fizzNumber = fizzNumber;
		this.buzzNumber = buzzNumber;
	}

	/**
	 * Returns the fizzbuzz value for n. The rules are:
	 * - if n is divisible by fizzNumber, or contains the digit fizzNumber, return "fizz" 
	 * - if n is divisible by buzzNumber, or contains the digit buzzNumber, return "buzz"
	 * - however, if both the above conditions are true, you must return "fizzbuzz"
	 * - if none of the above conditions is true, return the number itself.
	 *
	 * For example, getValue(1) returns "1".
	 * 
	 * @param n: a positive integer
	 * @return the fizzbuzz value, as a String
	 */
	public String getValue(int n) {
		boolean fizz = false;
		boolean buzz = false;
		String number = n + "";
		if((number.indexOf(fizzNumber+"")!=-1)&&(number.indexOf(buzzNumber+"")!=-1))
			{
			fizz = true;
		    buzz = true;
			}
			if(number.indexOf(fizzNumber+"")!=-1)
			{
			  fizz = true;
			}
			
		if(number.indexOf(buzzNumber+"")!=-1)
			{
			buzz = true;
			}
		
		if (n % (fizzNumber*buzzNumber) == 0) 
		{
			fizz = true;
			buzz = true;
		}
		
		if (n % fizzNumber == 0) 
		{
		   fizz = true;
		}

		if (n % buzzNumber == 0) 
		{
			buzz = true;
		}
		
		    if(fizz == true && buzz == true)
		    {
		    	return "fizzbuzz";
		    }
		    
		    if(fizz==true)
		    {
		    	return "fizz";
		    }
		    
		    if(buzz == true)
		    {
		    	return "buzz";
		    }
			return Integer.toString(n); // return the number itself as a String
	}

	/**
	 * Returns an array of the fizzbuzz values from start to end, inclusive.
	 * 
	 * For example, if the fizz number is 3 and buzz number is 4,
	 * getValues(2,6) should return an array of Strings:
	 * 
	 * {"2", "fizz", "buzz", "5", "fizz"}
	 * 
	 * @param start
	 *            the number to start from; start > 0
	 * @param end
	 *            the number to end at; end >= start
	 * @return the array of fizzbuzz values
	 */
	public String[] getValues(int start, int end) {
		String [] array = new String[(end-start)+1];
		for(int i = 0; i<array.length; i++)
		{array[i] = getValue(i+start);}
		return array;
	}
}
