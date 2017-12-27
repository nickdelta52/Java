/* 
* This class creates and works with infant objects.
*
*/
public class InfantMain {
	public static void main(String[] args) {
      Infant infant1, infant2;
      String name1 = "Fuzzy";
		int age1 = 6;
      infant1 = new Infant(name1,age1);
      System.out.println(infant1.toString());
	}
}