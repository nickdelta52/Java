public class BankingDriver{
   public static void main (String[] args){
       BankAccount nicksAcct = new BankAccount("Nick", 450, 550);
       BankAccount carolsAcct = new BankAccount("Carol", 600, 700);
       nicksAcct.printReport();
       carolsAcct.printReport();
       int nicksCheck = nicksAcct.getCheckMoney();
       int nicksSave = nicksAcct.getSaveMoney();
       int nicksSum = nicksCheck + nicksSave;
       int carolsSum = carolsAcct.getCheckMoney() + carolsAcct.getSaveMoney();
       System.out.println("Total money in all accounts: $" + (nicksSum+carolsSum));
       nicksAcct.makeCheckingDeposit(100);
       nicksAcct.printReport();
       nicksAcct.makeCheckingWithdrawal(nicksCheck);
       nicksAcct.makeSavingsWithdrawal(nicksSave);
       carolsAcct.makeCheckingDeposit(nicksCheck+nicksSave);
       nicksAcct.printReport();
       carolsAcct.printReport();
    
    }
  }