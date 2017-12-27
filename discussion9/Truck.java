public class Truck extends Vehicle {

  String makerName;
  String model;
  double engineLiters;
  String VIN;
  String year;
  double maxWeight;
  String color;
  
  
  public Truck(String make, String model, double engSz, String id, String year, double maxWt, String shade){
    super(make, model, engSz, id, year);
    maxWeight = maxWt;
    shade = color;
  }
  
 // super.getMake();
//  super.getModel();
//  super.getYear();
//  super.getEngineLiters();
//  super.getVIN(); 
 
  public double getMaxWeight(){
     return maxWeight;
  }
  
   public String toString(){
  return makerName+" " + model +" " + engineLiters+ " " + VIN + " " + color + " " + year + ", " + maxWeight;
   } 
 }