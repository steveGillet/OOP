public class negativeDeposit extends Exception{
    public negativeDeposit()
   {
      super("Error: Negative Deposit");
   }

   public negativeDeposit(double amount)
   {
      super("Error: Negative Deposit: " + amount);
   }
}