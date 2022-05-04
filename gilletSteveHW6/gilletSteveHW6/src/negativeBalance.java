public class negativeBalance extends Exception{
    public negativeBalance()
   {
      super("Error: Insufficient Balance");
   }

   public negativeBalance(double amount)
   {
      super("Error: Withdrawal Exceeds Balance: " +
            amount);
   }
}
