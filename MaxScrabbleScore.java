public class MaxScrabbleScore extends TextFileAccessor{
      
      private int maxScore = 0;
      private String maxLine;
      private int[] scores = new int[26]; 

      public MaxScrabbleScore(){
      super();
      scores[0] = 1;
      scores[1] = 3;
      scores[2] = 3;
      scores[3] = 2;
      scores[4] = 1;
      scores[5] = 4;
      scores[6] = 2;
      scores[7] = 4;
      scores[8] = 1;
      scores[9] = 8;
      scores[10] = 5;
      scores[11] = 1;
      scores[12] = 3;
      scores[13] = 1;
      scores[14] = 1;
      scores[15] = 3;
      scores[16] = 10;
      scores[17] = 1;
      scores[18] = 1;
      scores[19] = 1;
      scores[20] = 1;
      scores[21] = 4;
      scores[22] = 4;
      scores[23] = 8;
      scores[24] = 4;
      scores[25] = 10;     
      }
      

      protected void processLine(String word){
       
      String s = word.toUpperCase();
      int lineScore = 0; 
      int value = 0; 
      
       for(int k = 0; k<s.length(); k++){
         int scoreIndex = s.charAt(k) - 'A'; //subtracts A's ASCII value
         if ((scoreIndex >= 0)&& (scoreIndex <= 25)){
            value = scores[scoreIndex]; //If the character is a letter, get the letter score
         }
         else{
            value = 0;
         }
         if(k%4==0)
            value*=2;  //If the position of the character is divisible by 4, the score is doubled.
         else if((k%4==0)&&(k%9==0))
            value*=2; //If the position of the character is divisible by 4 and 9, the score is doubled.
         else if(k%9==0)
            value*=3; //If the position of the character is divisible by 9, the score is tripled.

                    
         lineScore = lineScore + value;
         }
         if (lineScore > maxScore){
            maxLine = word;
            maxScore = lineScore;
         }
      
      }
      public String getReportStr(){
      return("Max scrabble score: " + maxScore + " for this line: " + maxLine);
      }
   }