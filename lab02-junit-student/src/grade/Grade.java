package grade;
public class Grade {
	
	// Score should be between 0 and 100
	private int score;
	
	// Constructor
	public Grade(int scr){
		score = scr;
	}
	
	public String getLetterGrade(){
		String grade = "";
		
		if(score >= 90){
			grade = "A";
		}
		if(score <= 89 && score >= 80){
			grade = "B";
		}
		if(score <= 79 && score >= 70){
			grade = "C";
		}
		if(score <= 69 && score >= 60){
			grade = "D";
		}
		if(score < 60){
			grade = "F";
		}
		
		return grade;		
	}
	
	public int getTotalScoreAndUpdateScore(int[] subScoresToAdd){
		int total = 0;
		
		for(int i = 0; i < subScoresToAdd.length; i++){
			total += subScoresToAdd[i];
		}
		
		// See is score is valid, i.e. between 0 and 100
		if(isValidScore(total)){
			score = total;
		}
		else{
			throw new IllegalArgumentException("Total score is not valid");
		}
		
		return total;
	}
	
	// Checks if score is valid, i.e. between 0 and 100
	public boolean isValidScore(int score){
		return (score >= 0 && score <= 100);
	}
	
	public int getScore(){
		return score;
	}
	
	public void setScore(int newScore){
		score = newScore;
	}
	

}
