import java.io.*;

// Sravya Avadhuta worked with the following people on this project: Surbhi Bector
public class WordPercentages extends FileAccessor{
int[] count = new int[16];
private String [] words;
double [] percentages = new double[16];
private String fileName;
private double total;
private int sum;


public WordPercentages(String f) throws IOException {
   super(f);
   f = fileName;
   
}

public void processLine(String line){
    words = line.split("[,.;:?!() ]");
    for (int i = 0; i < words.length; i++){
      if (words[i].length() > 0 && words[i].length() < 15){
         count[words[i].length()]++;
         sum++;
      }
      else if(words[i].length() >= 15)
       { count[15]++;
       sum++;}
    }
    }
    
    public double getAvgWordLength(){
   int total = 0;
   for (int i = 0; i<count.length; i++) {
      total += count[i]*i;
   }
   return (double)total / sum;
}

    
    public double[] getWordPercentages(){
      for(double element: count)
      {
      for (int i = 0; i <percentages.length; i++) {
       percentages[i] = 100 * ((double)count[i]/sum);}
   }
   return percentages;
}



}