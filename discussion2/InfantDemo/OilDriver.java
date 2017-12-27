public class OilDriver{

  public static void main(String[] args){
    // owner - tank capacity - price per gallon - gallons in tank
    OilTank hankTank = new OilTank("Hank",300,3.59,200);
    System.out.println(hankTank.getCapacity());
    System.out.println(hankTank.getPrice());
    hankTank.setPrice(3.64);
    System.out.println(hankTank.getGallonsInTank());
  }
}
