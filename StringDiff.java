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
            
                  inputStr.charAt(j) = inputStr.charAt(j) + "" + inputStr.charAt(j);            
            
            if(inputStr.charAt(j)=='!')
            
                 inputStr.charAt(j) = '!' + "" + '!' + "" + '!'; 
   
           }
           System.out.println(inputStr);

     }
   }
        
        