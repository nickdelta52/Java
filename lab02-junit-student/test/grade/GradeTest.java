package grade;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import grade.Grade;

public class GradeTest {
	
	private Grade grade;
	
	@Before
	public void before(){
		grade = new Grade(0);
	}
	
	@Test
	public void getScore(){
		assertEquals(0, grade.getScore());
	}
	
	@Test
	public void testGetTotalScoreAndUpdateScore(){
		int[] subScoresToAdd = {30,20,50};
		assertEquals(100, grade.getTotalScoreAndUpdateScore(subScoresToAdd));
		
		// Try another set of subscores
		subScoresToAdd = new int[]{30,22};
		assertEquals(52, grade.getTotalScoreAndUpdateScore(subScoresToAdd));
		subScoresToAdd = new int[]{30, 40, 10};
		assertEquals(80, grade.getTotalScoreAndUpdateScore(subScoresToAdd));

		// TODO: FILL IN
		// Test these new subscores using assertEquals(expected, actual)
		// start line
		
		// YOUR CODE HERE
		
		//end line
	}
	
	@Test
	public void testGetLetterGrade(){
		grade = new Grade(95);
		assertEquals("A", grade.getLetterGrade());
		grade = new Grade(85);
		assertEquals("B", grade.getLetterGrade());
		grade = new Grade(75);
		assertEquals("C", grade.getLetterGrade());
		grade = new Grade(65);
		assertEquals("D", grade.getLetterGrade());
		grade = new Grade(30);
		assertEquals("F", grade.getLetterGrade());
		
		// TODO: FILL IN
		// Test a couple more values and make sure getLetterGrade returns the expected letter
		// start line
		
		// YOUR CODE HERE
				
		//end line
	}
	
	@Test
	public void testIsValidScore(){
		assertTrue(grade.isValidScore(50));
		assertFalse(grade.isValidScore(150));
		// TODO: FILL IN
		// Test the isValidScore method
		// Hint: Use assertTrue and assertFalse instead of assertEquals. 
		// Also, note isValidScore(int score) takes in an int as a parameter
		// start line
		
		// YOUR CODE HERE
				
		//end line
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testGetTotalScoreIllegalArgumentException(){
		int [] numbers = {30, 40, 59};
		grade.getTotalScoreAndUpdateScore(numbers);
		
		
		// TODO: FILL IN
		// Test that an invalid array of subscores (i.e. adding up to not between 0 and 100) throws an exception
		// Note you do not need to use assertEquals in this one
		// The "test" comes from the "expected = IllegalArgumentException.class" line above
		// The test is expecting this exception, so it will pass if the exception is thrown and fail otherwise
		// start line
		
		// YOUR CODE HERE
				
		//end line
	}

}
