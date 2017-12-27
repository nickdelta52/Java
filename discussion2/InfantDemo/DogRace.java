import java.util.*;
public class DogRace{

   private Random generator = new Random();
   private Dog fido = new Dog('F');


   public int spin(){
      return generator.nextInt(6)+1;
      }
      
      public static void main(String [] args){
      DogRace game = new DogRace();
      game.draw();
      }
      }
    