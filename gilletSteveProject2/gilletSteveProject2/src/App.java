import java.util.Scanner;

import java.util.Date;

import java.lang.Math;


public class App {
    static account accArr[] = new account[100];
    static order ordArr[] = new order[100];
    static Scanner sc = new Scanner(System.in);
    static int accountCounter = 1;
    static String[] securityQuestions = {"1. What is your favorite color?", "2. What city were you born in?", "3. What's the name of your first pet?", "4. What's the name of your first boyfriend/girlfriend?", "5. What band played the first concert you went to?"};
    static String tempID = null;
    static String tempPW = null;
    static double totalPrice = 0;
    static int[] basket = {0, 0, 0, 0, 0};
    static int orderNum = 0;
    static String[] productName = {"Peanut Butter", "Dog Treat", "Party Hat", "Cow Bones", "Milk"};
    static warehouse wh = new warehouse({0, 0, 0, 0, 0}, {10, 10, 10, 10, 10})
    public static void main(String[] args) throws Exception {
        accArr[0] = new account("1234", "1234", 2, "beans", "Sam", "22 Maygrove Ln", "2222111144443333");
        boolean loggedIn = false;
        int firstMenuSelection;
        int secondMenuSelection;
        while(true){
            System.out.println("Please select a number from the menu:");
            System.out.println("1: Log In");
            System.out.println("2: Create Account");
            firstMenuSelection = sc.nextInt();
            sc.nextLine();
            if(firstMenuSelection == 1){
                loggedIn = logon();
                if(loggedIn){
                    totalPrice = 0;
                    for(int i = 0; i < basket.length; i++) basket[i] = 0;
                }
            }
            else if(firstMenuSelection == 2) createAccount();
            while(loggedIn){
                System.out.println("Please select a number from the menu:");
                System.out.println("1: Select Items");
                System.out.println("2: Make Order");
                System.out.println("3: View Order");
                System.out.println("4: Log Out");
                secondMenuSelection = sc.nextInt();
                if(secondMenuSelection == 1) selectItems();
                else if(secondMenuSelection == 2) makeOrder();
                else if(secondMenuSelection == 3) viewOrder();
                else if(secondMenuSelection == 4) loggedIn = false;
            }
        }
    }
    public static void viewOrder(){
        System.out.println("Order Information:");
        System.out.println("Order Date: " + ordArr[orderNum - 1].date);
        System.out.println("Product Names:");
        for(int i = 0; i < productName.length; i++){
            if(ordArr[orderNum - 1].getQuantity()[i] > 0){
                System.out.println(productName[i]);
            }
        }
        System.out.println("Product Quantities:");
        for(int i = 0; i < ordArr[orderNum - 1].getQuantity().length; i++){
            if(ordArr[orderNum - 1].getQuantity()[i] > 0){
                System.out.println(ordArr[orderNum - 1].getQuantity()[i]);
            }
        }
        System.out.println("Total: $" + ordArr[orderNum - 1].getTotal());
    }
    public static void makeOrder(){
        int deliveryMethod;
        System.out.println("Would you like to receive your order 1. By mail ($3 delivery fee) or 2. Pick it up at the store (free)? 0 to cancel");
        deliveryMethod = sc.nextInt();
        sc.nextLine();
        if(deliveryMethod == 0) return;
        if(deliveryMethod == 1) totalPrice += 3;
        System.out.println("Your total is: $" + totalPrice);
        if(totalPrice <= accArr[accountNumber(tempID)].getCClimit()){
            int auth = (int) Math.round(Math.random() * 10000);
            ordArr[orderNum] = new order(tempID, basket, totalPrice, auth);
            System.out.println("Order confirmed. Your order authentication number is " + String.format("%04d", ordArr[orderNum].getAuth()));
            orderNum++;
        }
    }
    public static void selectItems(){
        int selection = -1;
        int quantity;
        while(selection != 0){
            double[] prices = {4.99, 8.49, 0.99, 2.99, 5.49};
            System.out.println("Menu             : Description                                             : Price  : Sales Price");
            System.out.println("-----------------:---------------------------------------------------------:--------:------------");
            System.out.println("1. Peanut Butter : A jar of peanut butter (crunchy)                        : $4.99  : $4.99");
            System.out.println("2. Dog Treat     : Delicious nuggets made of chicken for treating your dog : $8.99  : $8.49");
            System.out.println("3. Party Hat     : A colorful cardboard hat for a kids birthday party      : $0.99  : $0.99");
            System.out.println("4. Cow Bones     : Filled with delicious marrow, yummy!                    : $3.99  : $2.99");
            System.out.println("5. Milk          : Organic, farm-raised, no-hormone cow milk               : $5.49  : $5.49");
            System.out.println("-----------------:---------------------------------------------------------:--------:------------");
            System.out.println("Select an item number or 0 to exit:");
            selection = sc.nextInt();
            sc.nextLine();
            if(selection>0){
                System.out.println("Enter the quantity:");
                quantity = sc.nextInt();
                sc.nextLine();
                totalPrice += prices[selection - 1] * quantity;
                basket[selection - 1] += quantity;
            }
        } 
    }
    public static boolean logon(){
        int kickOut = 0;
        while(kickOut < 3){
            System.out.println("Login: Enter ID");
            tempID = sc.nextLine();
            System.out.println("Login: Enter PW");
            tempPW = sc.nextLine();
            String tempAnswer = null;
            if(idCheck(tempID)){
                if(accArr[accountNumber(tempID)].getpW().equals(tempPW)){
                    System.out.println(securityQuestions[accArr[accountNumber(tempID)].getSQ()]);
                    tempAnswer = sc.nextLine();
                    if(tempAnswer.equals(accArr[accountNumber(tempID)].getSA())){
                        System.out.println("Welcome Member!");
                        return true;    
                    }
                    else{
                        System.out.println("Invalid Answer");
                        kickOut = 3;
                    }
                }
                else{
                    System.out.println("Invalid PW");
                    kickOut++;
                }
            }
            else{
                System.out.println("Invalid ID");
                kickOut = 3;
            }
        }
        return false;
    }
    public static void createAccount(){
        boolean idValid = false;
        
        while(!idValid){
            System.out.println("Create Account: Enter ID");
            tempID = sc.nextLine();
            if(!idCheck(tempID)){
                System.out.println("new account created");
                idValid = true;
            }
            else{
                System.out.println("id already in use");
            }
        }

        boolean pwValid = false;
        while(!pwValid){
            System.out.println("Create Account: Enter PW (6 Letters, 1 Special Character, 1 Upper Case Letter)");
            tempPW = sc.nextLine();
            if(pwCheck(tempPW)){
                System.out.println("PW set");
                pwValid = true;
            }
            else{
                System.out.println("pw invalid");
            }
        }

        boolean infoValid = false;
        String name = null;
        String address = null;
        String ccNumber = null;
        while(!infoValid){
            System.out.println("Create Account: Enter Name, Address, and Credit Card Number");
            System.out.println("Name:");
            name = sc.nextLine();
            System.out.println("Address:");
            address = sc.nextLine();
            System.out.println("Credit Card Number:");
            ccNumber = sc.nextLine();
            if(name != null && address != null && ccNumber != null){
                System.out.println("Information Set");
                infoValid = true;
            }
            else{
                System.out.println("please enter valid information");
            }
        }
        
        int securitySelection = -1;
        String tempAnswer;
        boolean ssValid = false;

        while(!ssValid){
            System.out.println("Please select the number of the security question you would like:");
            for(int i = 0; i < securityQuestions.length; i++){
                System.out.println(securityQuestions[i]);
            }
            securitySelection = sc.nextInt() - 1;
            sc.nextLine();
            if(securitySelection >= 0 && securitySelection <= securityQuestions.length - 1){
                ssValid = true;
            }
            else{
                System.out.println("please enter a valid security question number");
            }
        }
        System.out.println("Please enter an answer for your security question:");
        tempAnswer = sc.nextLine();
        accArr[accountCounter] = new account(tempID, tempPW, securitySelection, tempAnswer, name, address, ccNumber);
        System.out.println(accArr[accountCounter].getSQ());
        System.out.println(accArr[accountCounter].getSA());
        accountCounter++;
    }
    public static boolean idCheck(String tempID){
        boolean check = false;
        for(int i = 0; i < 100; i++){
            if(accArr[i] != null){
                if(tempID.equals(accArr[i].getID())){
                    check = true;
                }
            }
        }
        return check;
    }
    public static int accountNumber(String tempID){
        for(int i = 0; i < 100; i++){
            if(accArr[i] != null){
                if(tempID.equals(accArr[i].getID())){
                    return i;
                }
            }
        }
        return -1;
    }
    public static boolean pwCheck(String tempPW){
        boolean check = false;
        if(tempPW.length() > 5){
            for(int i = 0; i < tempPW.length(); i++){
                if(tempPW.charAt(i) >= '0' && tempPW.charAt(i) <= '9'){
                    for(int j = 0; j < tempPW.length(); j++){
                        if(tempPW.charAt(j) >= 'A' && tempPW.charAt(j) <= 'Z'){
                            for(int k = 0; k < tempPW.length(); k++){
                                if(tempPW.charAt(k) >= '#' && tempPW.charAt(k) <= '&' || tempPW.charAt(k) == '@' || tempPW.charAt(k) == '*'){
                                    check = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return check;
    }
    public static boolean processOrder(){
        System.out.println("Please enter an order number to process: ");
        int order = sc.nextInt() - 1;
        sc.nextLine();
        int[] currOrder = ordArr[order].getQuantity();
        boolean inStock = true;
        for(int i = 0; i < currOrder.length; i++){
            if(currOrder[i] < wh.getItemsA()[i]){
                inStock = false;
            }
        }
        if(inStock == true){
            for(int i = 0; i < currOrder.length; i++){
                inStock = false;
            }    
        }
    }
}

class warehouse{
    private int[] itemsReserved;
    private int[] itemsAvailable;
    warehouse(int[] itemR, int[] itemA){
        itemsReserved = itemR;
        itemsAvailable = itemA;
    }
    public void setItemsR(int[] itemR){
        itemsReserved = itemR;
    }
    public void setItemsA(int[] itemA){
        itemsAvailable = itemA;
    }
    public int[] getItemsR(){
        return itemsReserved;
    }
    public int[] getItemsA(){
        return itemsAvailable;
    }
}

class order{
    public Date date = new Date();
    private String customerID;
    private int[] quantities;
    private double total;
    private int authNumber;
    order(String id, int[] quan, double tot, int auth){
        customerID = id;
        quantities = quan;
        total = tot;
        authNumber = auth;
        date = new Date();
    }
    public String getID(){
        return customerID;
    }
    public int[] getQuantity(){
        return quantities;
    }
    public double getTotal(){
        return total;
    }
    public int getAuth(){
        return authNumber;
    }
}

class account{
    private String iD;
    private String pW;
    private int securityQuestion;
    private String securityAnswer;
    private String name;
    private String address;
    private String ccNumber;
    private double ccLimit = 500;
    static int numObj = 0;
    {
        numObj++;
    }
    account(String id, String pw, int sq, String sa, String na, String add, String cc){
        iD = id;
        pW = pw;
        securityQuestion = sq;
        securityAnswer = sa;
        name = na;
        address = add;
        ccNumber = cc;
    }
    public void setID(String id){
        iD = id;
    }
    public void setPW(String pw){
        pW = pw;
    }
    public void setSQ(int SQ){
        securityQuestion = SQ;
    }
    public void setSA(String SA){
        securityAnswer = SA;
    }
    public void setName(String na){
        name = na;
    }
    public void setAddress(String add){
        address = add;
    }
    public void setCCnumber(String cc){
        ccNumber = cc;
    }
    public void setCClimit(double lim){
        ccLimit = lim;
    }
    public String getID(){
        return iD;
    }
    public String getpW(){
        return pW;
    }
    public int getSQ(){
        return securityQuestion;
    }
    public String getSA(){
        return securityAnswer;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String getCCnumber(){
        return ccNumber;
    }
    public double getCClimit(){
        return ccLimit;
    }
}