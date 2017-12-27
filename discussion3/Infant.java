     /**
    * This class defines the data and functionality that model an infant.    
    */
public class Infant{
  
     /**
    * The name of this infant    
    */
  private  String name;
       /**
    * The age of this infant in months    
    */
  private int age;  
  
  /**
 * Class constructor. Initializes an infant with a name and age in months.
 *
 * @param who  the name of this infant.
 * @param months the age in months of this infant.
 */
  public Infant(String who, int months){
    name = who;
    age = months;
  }
  
  /**
 * Returns the name of this infant.
 *
 * @return the name
 */
  public String getName(){
      return name;
  }
  
    /**
 * Returns the age of this infant.
 *
 * @return the age in months
 */
  public int getAge(){
      return age;
  }
 
   /**
 * Increments the current age of this infant by one month.
 *
 */ 
  public void addAnotherMonth(){
      age = age + 1;
  }
  
     /**
 * Returns a string representation of this infant.
 *
 * @return the name and age in a formatted string.
 */ 
  public String toString(){
      return "Infant name: "+name+", age (in months): "+age;
  }
}