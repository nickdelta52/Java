public class DairyFarm extends Farm{
 private int cowCount;
 private int milkProduction;
 public DairyFarm(String w, int a, int c, int m){
 super(w,a);
 cowCount = c;
 milkProduction = m;
 }
 public int getCowCount()
 {return cowCount;}
 public void setCowCount(int c)
 { cowCount = c;}
 public int getMilkProduction() 
 {return milkProduction;}
 public void setMilkProduction(int m)
 { milkProduction = m;}
 }
