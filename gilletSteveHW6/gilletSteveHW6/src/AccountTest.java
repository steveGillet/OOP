/**
   This program demonstrates how the BankAccount
   class constructor throws custom exceptions.
*/

public class AccountTest
{
   public static void main(String [] args)
   {
      try{
         BankAccount account = new BankAccount(100.0);
         try
         {
            account.deposit(200.00);
         }
         catch(negativeDeposit e)
         {
            System.out.println(e.getMessage());
         }
         try
         {
            account.withdraw(400.00);
         }
         catch(negativeWithdrawal | negativeBalance e)
         {
            System.out.println(e.getMessage());
         }
      }
      catch(NegativeStartingBalance e){
         System.out.println(e.getMessage());
      }
   }
}