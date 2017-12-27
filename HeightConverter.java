//Sravya Avadhuta 30373128

public class HeightConverter{
  
  public static void main (String[] args){
    
    double conversionFactor = 2.54;
    String name = "Sravya Avadhuta";
    int age = 18;
    int myHeightInches = 63;
    double myHeightCM = conversionFactor*myHeightInches;
    System.out.println(name);
    System.out.println("age: " + age);
    System.out.println("height: " + myHeightInches + " inches");
    System.out.println("height: " + myHeightCM + " cm");   
    
  }
  
}