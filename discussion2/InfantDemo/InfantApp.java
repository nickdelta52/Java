public class InfantApp{
  
  public static void main (String[] args){
    Infant infantOne = new Infant("Lizzie",4);
    String curName = infantOne.getName();
    int curAge = infantOne.getAge();
    System.out.println("This kid's name is " + curName);
    System.out.println("This kid's age is " + infantOne.getAge());
    System.out.println("This kid is now " + curAge + " months old.");
    Infant infantTwo = new Infant("Maizy",8);
    String name = infantTwo.getName();
    int age = infantTwo.getAge();
    System.out.println("Another kid's name is " + name);
    System.out.println("Another kid's age is " + age);
    Infant infantThree = new Infant("Carlitos",3);
    String name3 = infantThree.getName();
    int age3 = infantThree.getAge();
    System.out.println("Yet another kid's name is " + name3);
    System.out.println("Yet another kid's age is " + age3);


  }
}