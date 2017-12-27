public class Car extends Vehicle{

  String makerName;
  String model;
  double engineLiters;
  String VIN;
  String year;
  double luggageCap;
  double passengerCap;
  
  public Car(String make, String model, double engSz, String id, String year, double lugCap, double passCap){
    super(make, model, engSz, id, year);
    luggageCap = lugCap;
    passengerCap = passCap;
  }
  
 // super.getMake();
//  super.getModel();
//  super.getYear();
//  super.getEngineLiters();
//  super.getVIN(); 
 
  public double getLuggageCap(){
  return luggageCap;
  }
  
  public double getPassengerCap(){
  return passengerCap;
  }
  
  public String toString(){
  return makerName+" " + model +" " + engineLiters+ " " + VIN + " " + year + ", " + luggageCap + ", " + passengerCap;
   }
   }