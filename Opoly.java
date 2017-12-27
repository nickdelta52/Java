import java.util.*;
public class Opoly{
private int position;
private int boardSize;
private int reward = 100;
private int move;
private Random rand;

public Opoly(int size){
   boardSize = size;
   rand = new Random();
}

public Opoly(int bSize, int seed){
   boardSize = bSize;
   this.rand = new Random(seed); 
}

   public void playGame(){
      drawBoard();
      spinAndMove();
      if(!isGameOver())
         {playGame();}
      else
      {drawBoard();
      displayReport();}
    }
    
   public void spinAndMove(){
      int randNum = spin();
      move(randNum);
   }
   
   public int spin(){
    move++;
    return rand.nextInt(4)+1;
   }
   
   public void move(int num){
   
      if((position+num)>(boardSize-1))
      {reward = reward+100;}
      
      position = (position + num) % boardSize;
      
      if(move>0 && move%10 == 0)
      {reward = reward-50;} 
      
      if(position == (boardSize-1))
      {position = position-3;} 
      
      if(position %7==0)
      {reward = reward*2;}
   
   }
   
   public boolean isGameOver(){
   return (reward>=1000);
   
   }
   
   public void drawBoard(){     
      for(int k=0; k<=boardSize-1; k++){
         if((k)==(position))
            System.out.print('o');
         else 
            System.out.print('*');
      }
      
      System.out.print(" " + reward);
      System.out.println();
   }
   
   public void displayReport(){
   System.out.println("game over");
   System.out.println("rounds of play: " + move);
   System.out.println("final reward: " + reward);
   
   }




}