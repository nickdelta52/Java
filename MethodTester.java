public class MethodTester{
  public static void main(String args[]){
  boolean test1 = isVowel('a');
  boolean test2 = isVowel('b');
  boolean test3 = isVowel('e');
  boolean test4 = isVowel('s');
  System.out.println(test1+" " test2+ " " + test3 + " " + test4 + " " );
  System.out.println("true false true false");
  }
  Player p = new Player("Joe", true, false);
  Player newp = new Player("Sean", true, false);
  System.out.println(p);
  System.out.println(newp);
  }
  
  public static boolean isVowel (char toCheck){
  toCheck = Character.toLower
  return false;
  }
  
  public static String replaceVowels(String word){
  for(int k=0;k<word.length();k++)
  {if (word.charAt(k) = 'a' || word.charAt(k) = 'e' || word.charAt(k) = 'i' || word.charAt(k) = 'o' || word.charAt(k) = 'u')
    {word.charAt(k) = '*';}}
    }
    }
