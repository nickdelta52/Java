public class Vehicle{
  String model;
  double engineLiters;
  String VIN;
  String year;
  String makerName;
  
  public Vehicle(String make, String model, double engSz, String id, String year){
   makerName = make;
    this.model = model;
    engineLiters = engSz;
    VIN = id;
    this.year=year;  
}
  
 public String getMake(){
    return makerName;
  }
  
  public String getModel(){
    return model;
  }
  
  public String getYear(){
    return year;
  }
  public double getEngineLiters(){
     return engineLiters;
  }
  
  public String getVIN(){
     return VIN;
  }
  
    }