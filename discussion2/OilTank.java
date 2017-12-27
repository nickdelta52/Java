public class OilTank{

      // owner - tank capacity - price per gallon - gallons in tank
   private String owner;
   private int tankCapacity;
   private double price;
   private int gallonsInTank;
   
   public OilTank(String who, int capacity, double money, int gallons){
   owner = who;
   tankCapacity = capacity;
   price = money;
   gallonsInTank = gallons;
   
   }
   
   public String getOwner(){
      return owner;
     }
       
    public int getCapacity(){
       return tankCapacity;
    }
    
    public double getPrice(){
      return price;
     }
     
     public int getGallonsInTank(){
       return gallonsInTank;
     }
     
     public void setPrice(double newPrice){
         price = newPrice;
   }
 }
 
   
   
   
  