public class Player{

private static String name;
private static boolean canWalk;
private static boolean canRun;
private static double health;

public Player(String name, boolean canWalk, boolean canRun){
this.name = name;
this.canWalk = canWalk;
this.canRun = canRun;
}

public String toString(){
return this.name + ":for(int k=1;k<=60;k++)
 {if(k%7==0)
   {System.out.println(k);}
} canWalk: " + this.canWalk +
                   " canRun " + this.canRun +
                   " health " + this.health;

