public class Surprise{
  
  private String secret;
  private int n;
  private int m;
 
  public Surprise(int a, int b, String s){
    n = a;
    m = b;
    secret = s;
  }
 
  public int getN(){return n;}
  public int getM(){return m;}
 
  public void setN(int a){n = a;}
  public void setM(int b){m = b;}
 
  public void revealSecret(){
      /* body of method is top secret! */
  }
}