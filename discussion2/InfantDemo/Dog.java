public class Dog{

private int position;
private char symbol;

public Dog(char symbol){
this.symbol = symbol;
this.position = 0;

  public static void main(String [] args){
      DogRace game = new DogRace();
      for(int i=0; i<20; i++){
      System.out.println(game.spin());
      
      }
      
}
public void move(){
}

public void drawPath(int size){
for(int i = 0; i<size; i++){
if(position==i){
System.out.print(symbol);}
else{
System.out.println('*');}
}
}}