public class Test{
public static void main(String [] args)
   {String a = "Hello Dave";
   System.out.print(deleteCharAt(a, 1));
}

   public static String deleteCharAt (String inputStr, int num){
   return(inputStr.substring(0,num)+inputStr.substring(num+1,inputStr.length()));   
}
}//end class