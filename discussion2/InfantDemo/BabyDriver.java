public class BabyDriver{

      
   public static void main(String...args){
   Baby myBaby = new Baby("Lizzie", 4);
   String name = myBaby.getName();
   name = "Billy";
   myBaby.setName(name);
   }
   }