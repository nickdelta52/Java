package hangman;

/**
* The Array implementation of the GameModel interface.
*/
public class ArrayGameModel implements GameModel {

    /** The acceptable characters. */
    private static final String ALPHABET="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /** hung state */
    private int state = 0;
    private String wordToGuess;
    private char [] guessedChars;
    private int guessIndex = 0;
	private int countCorrectGuess = 0;
    private char [] dashes;
    /**
        * Creates a new ArrayGameModel object.
        * 
        * guessWord the word to guess
        */
    public ArrayGameModel(String guessWord) {
    	wordToGuess = guessWord;
    	guessedChars = new char [11];
    	dashes = new char [wordToGuess.length()];
    	for(int i = 0; i<dashes.length; i++) //dashes for initial hangman state
    	{
    		dashes[i] = '_';
    	}
    }

    public boolean isPriorGuess(char guess) {
    	for(int i=0; i<guessedChars.length; i++) //going through the array of guessed characters to see if guess is a guessed character
        {if(guess==guessedChars[i])
        	return true;
        }
    		
    	return false;
        
    }

    public int numberOfGuesses() {
        return state;
    }

    public boolean isCorrectGuess(char guess) {
    	boolean check = false; 
    	for(int i = 0; i< wordToGuess.length(); i++)
    	 {
    		if (wordToGuess.charAt(i) == guess) //checking if the word has the guess (character)
    			{
    			countCorrectGuess++; //counting the number of correct guesses
    			check=true;
    		    }
    	 }
    	if (isPriorGuess(guess)==false && check==false) //state is increased if its a prior guess and check is false (not correct)
		{state++;}
    	return check;
    	
    }



    public boolean doMove(char guess) {
       if (isCorrectGuess(guess)==true && isPriorGuess(guess)==false) 
       { 	
       		for(int i = 0; i<wordToGuess.length(); i++) //going through the word to guess
       		{
       			if(wordToGuess.charAt(i) == guess) 
       			{
       				dashes[i] = guess; //replacing dashes with guess in hangman state at the correct position
       			}
            }
       		guessedChars[guessIndex] = guess; //adding guess into the guessed characters array if its correct
       		if (guessIndex<10)
  			{guessIndex++;}
        	return true;
       }
       else
       {
    	   guessedChars[guessIndex] = guess; //adding guess into the guessed characters array if its not correct
      		if (guessIndex<10)
      			{guessIndex++;}
       		return false;
       }
    }

    public boolean inWinningState() { //if all the letters in the word to guess are guessed
        if (countCorrectGuess == wordToGuess.length())
        	{return true;}
        	else
        	{ return false;}
    }

    public boolean inLosingState() {
        if (countCorrectGuess < wordToGuess.length() && state==10) //if state is 10 and not all the letters in the word to guess are guessed
        	return true;
        else
        	return false;

    }

    public String toString() { //giving hangman state
     String answer = "";
     for(int i = 0; i<dashes.length; i++)
    	 {answer = answer + dashes[i] + " ";}
         answer = answer.substring(0,answer.length()-1);
        return answer.trim();
    }

    public String previousGuessString() { //string of the guessed characters array
       if(guessedChars.length==0)
    	   return "[]";
       else 
    	{String guessString = "";
    	for(int i=0; i<guessedChars.length-2; i++)
       { guessString = guessString + guessedChars[i] + ", ";   }
      return ("[" + guessString.substring(0, guessString.length()-2) + "]");}
      
    }
    public int getState() {
    	return state;
    }
    

    public String getWord() {
        return wordToGuess;
        
    }
}
