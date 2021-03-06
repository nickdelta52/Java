package guessme;

/**
 * A LinkedList-based implementation of the Guess-A-Number game
 */
public class LinkedListGame {

	// TODO: declare data members as necessary
	private LLIntegerNode guessListHead;
	private LLIntegerNode guessListTail;
	private LLIntegerNode candidateListHead;
	private LLIntegerNode candidateListTail;
	private int guess = 1000;
	private int numGuesses = 0;
	private int eliminatedCount = 9999;
	private boolean allNumbersMatch = false;

	/********************************************************
	 * NOTE: for this project you must use linked lists implemented by yourself.
	 * You are NOT ALLOWED to use Java arrays of any type, or any class in the
	 * java.util package (such as ArrayList).
	 *******************************************************/

	/********************************************************
	 * NOTE: you are allowed to add new methods if necessary, but DO NOT remove
	 * any provided method, and do NOT add new files (as they will be ignored by
	 * the autograder).
	 *******************************************************/

	// LinkedListGame constructor method
	public LinkedListGame() {
		guessListHead = null;
		guessListTail = guessListHead;
		for (int i = 1000; i < 10000; i++) {
			LLReference ref = insert(candidateListHead, candidateListTail, i);

			if (i == 1000)
				candidateListHead = ref.head;

			candidateListTail = ref.tail;

		}

	}

	// Resets data members and game state so we can play again
	public void reset() {
		candidateListHead = null;
		candidateListTail = candidateListHead;
		
		for (int i = 1000; i < 10000; i++) {
			LLReference ref = insert(candidateListHead, candidateListTail, i);

			if (i == 1000)
				candidateListHead = ref.head;

			candidateListTail = ref.tail;

		}
		guessListHead = null;
		guessListTail = guessListHead;
		guess = 1000;
		eliminatedCount = 9999;
		numGuesses = 0;
		allNumbersMatch = false;
	}

	// Returns true if n is a prior guess; false otherwise.
	public boolean isPriorGuess(int n) {
		return (contains(guessListHead, n) == true);

	}

	// Returns the number of guesses so far.
	public int numGuesses() {
		return numGuesses;
	}

	/**
	 * Returns the number of matches between integers a and b. You can assume
	 * that both are 4-digits long (i.e. between 1000 and 9999). The return
	 * value must be between 0 and 4.
	 * 
	 * A match is the same digit at the same location. For example: 1234 and
	 * 4321 have 0 match; 1234 and 1114 have 2 matches (1 and 4); 1000 and 9000
	 * have 3 matches (three 0's).
	 */
	public static int numMatches(int a, int b) {
		int count = 0;
		int num = 1000;
		int i = 0;
		while (i < 4) {
			if ((a / num) == (b / num)) {
				count++;
			}
			a = a % num;
			b = b % num;
			num = num / 10;
			i++;
		}

		return count;
	}// TODO

	/**
	 * Returns true if the game is over; false otherwise. The game is over if
	 * the number has been correctly guessed or if no candidate is left.
	 */
	public boolean isOver() {
		return (allNumbersMatch || eliminatedCount == 1001);
	}

	/**
	 * Returns the guess number and adds it to the list of prior guesses. The
	 * insertion should occur at the end of the prior guesses list, so that the
	 * order of the nodes follow the order of prior guesses.
	 */
	public int getGuess() {
		LLReference ref = insert(guessListHead, guessListTail, guess);

		if (guessListHead == null)
			guessListHead = ref.head;

		guessListTail = ref.tail;
		numGuesses++;
		return guess;
	}

	/**
	 * Updates guess based on the number of matches of the previous guess. If
	 * nmatches is 4, the previous guess is correct and the game is over. Check
	 * project description for implementation details.
	 * 
	 * Returns true if the update has no error; false if no candidate is left
	 * (indicating a state of error);
	 */
	public boolean updateGuess(int nmatches) {
		LLIntegerNode notEliminatedListHead = null;
		LLIntegerNode notEliminatedListTail = null;
		
		if (nmatches == 4) {
			allNumbersMatch = true;
			return allNumbersMatch;
		}

		LLIntegerNode newNode = null;
		newNode = candidateListHead;
		while (newNode != null) {
			if (numMatches(newNode.getInfo(), guess) == nmatches) {
				LLReference ref = insert(notEliminatedListHead, notEliminatedListTail, newNode.getInfo());

				if (notEliminatedListHead == null)
					notEliminatedListHead = ref.head;

				notEliminatedListTail = ref.tail;
				eliminatedCount--;
			}
			newNode = newNode.getLink();
		}

		if (notEliminatedListHead != null)
			guess = notEliminatedListHead.getInfo();

		candidateListHead = notEliminatedListHead;
		candidateListTail = notEliminatedListTail;

		notEliminatedListHead = null;
		notEliminatedListTail = null;

		return candidateListHead != null;
	}

	// Returns the head of the prior guesses list.
	// Returns null if there hasn't been any prior guess
	public LLIntegerNode priorGuesses() {
		return guessListHead;
	}

	/**
	 * Returns the list of prior guesses as a String. For example, if the prior
	 * guesses are 1000, 2111, 3222, in that order, the returned string should
	 * be "1000, 2111, 3222", in the same order, with every two numbers
	 * separated by a comma and space, except the last number (which should not
	 * be followed by either comma or space).
	 *
	 * Returns an empty string if here hasn't been any prior guess
	 */
	public String priorGuessesString() {
		String answer = "";
		LLIntegerNode newPointer = guessListHead;
		while (newPointer != null) {
			answer = answer + newPointer.getInfo() + ", ";
			newPointer = newPointer.getLink();
		}
		if (!answer.equals("")) {
			answer = answer.substring(0, answer.length() - 2);
		}
		return answer.trim();
	}

	public LLReference insert(LLIntegerNode head, LLIntegerNode tail, int guess) {
		LLIntegerNode newNode = new LLIntegerNode(guess);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setLink(newNode);
			tail = newNode;
		}
		LLReference reference = new LLReference(head, tail);
		return reference;
	}

	public boolean contains(LLIntegerNode head, int guess) {
		LLIntegerNode newPointer = head;
		while (newPointer != null) {
			if (guess == newPointer.getInfo())
				return true;
			else
				newPointer = newPointer.getLink();
		}
		return false;
	}

	private class LLReference {
		private LLIntegerNode head;
		private LLIntegerNode tail;

		private LLReference(LLIntegerNode head, LLIntegerNode tail) {
			this.head = head;
			this.tail = tail;
		}
	}
}
