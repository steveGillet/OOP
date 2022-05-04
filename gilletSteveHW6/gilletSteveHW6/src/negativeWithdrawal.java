public class negativeWithdrawal extends Exception{
    public negativeWithdrawal()
   {
      super("Error: Negative Withdrawal");
   }

   public negativeWithdrawal(double amount)
   {
      super("Error: Negative Withdrawal: " +
            amount);
   }
}