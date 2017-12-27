public class Troll {

   private String name; 
   private int age;
   private static double DEFAULT_STRENGTH_LEVEL=100.0;
   private double strengthLevel;
   private String weapon;
	 
   public Troll(String name, int age, String weapon) {
      this.name=name;
      this.age=age;
      this.weapon=weapon;
      strengthLevel=DEFAULT_STRENGTH_LEVEL;
   } 

  public String getName(){
     return name;
  }
  
  public int getAge(){
    return age;
  }

  public void die(){
	  strengthLevel = 0;
  }

  public boolean isAlive(){
	  return (strengthLevel>0);
   }

  public void setStrengthLevel(int newLevel){
       strengthLevel = newLevel;
   }

   public String toString()  {
	  return name+" age: "+age+" weapon: "+weapon+" strength level: "+strengthLevel;
   }
   
}
   
   

