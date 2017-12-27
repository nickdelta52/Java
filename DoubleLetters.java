import java.util.Scanner;

   public class DoubleLetters
   {
      public static void main (String[] args)
      {
         Scanner scan = new Scanner(System.in);
         System.out.println("Enter a line of text");
         String inputStr = scan.nextLine();
         for(int j=0; j<inputStr.length(); j++)
         {
            if (Character.isLetter(inputStr.charAt(j)))
            
                  inputStr = inputStr.substring(0, j) + inputStr.charAt(j) + inputStr.substring(j, inputStr.length());           
            
            if(inputStr.charAt(j)=='!')
            
                 inputStr = inputStr.substring(0, j) + "!" + "!" + inputStr.substring(j, inputStr.length());   
          }
           
           System.out.println(inputStr);

     }
   }
        
        