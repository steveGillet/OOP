public class paymentTest {
    public static void main(String[] args) throws Exception {
        payment cashPay1;
        cashPay1 = new cashPayment(100);
        cashPayment cashPay2 = new cashPayment(3500);
        cashPay1.paymentDetails();
        cashPay2.paymentDetails();
        creditCardPayment ccPay1 = new creditCardPayment(200, "Steve", "10/22", 4444555522221111L);
        creditCardPayment ccPay2 = new creditCardPayment(560, "Sam", "04/24", 1111333377778888L);
        ccPay1.paymentDetails();
        ccPay2.paymentDetails();
    }
}

class payment{
    protected double amount;
    public void setAmount(double am){
        amount = am;
    }
    public double getAmount(){
        return amount;
    }
    public void paymentDetails(){
        System.out.println("The size of the payment is $" + amount + ".");
    }
}

class cashPayment extends payment{
    cashPayment(double am){
        setAmount(am);
    }
    public void paymentDetails(){
        System.out.println("The payment is $" + amount + " cash.");
    }
}

class creditCardPayment extends payment{
    private String name;
    private String expDate;
    private long ccNumber;
    creditCardPayment(double am, String nm, String ed, long ccn){
        name = nm;
        expDate = ed;
        ccNumber = ccn;
        setAmount(am);
    }
    public void paymentDetails(){
        System.out.println("The payment is $" + amount + " from a credit card. The name on the card is " + name + ", the credit card number is " + ccNumber + ", and the expiration date is " + expDate + ".");
    }
}