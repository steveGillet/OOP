// Steve Gillet Homework 2 OOP

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        
        OverloadingTest OverloadingTest = new OverloadingTest();
        OverloadingTest.overTest();
        CarTest CarTest = new CarTest();
        CarTest.carTest();

    }  
}

class OverloadingTest{
    public void overTest(){
    Overloading OverloadingTest = new Overloading(); 
    System.out.println(OverloadingTest.max(50,20,5));
    System.out.println(OverloadingTest.max("300",400));
    System.out.println(OverloadingTest.max('a',50));
    System.out.println(OverloadingTest.max("30",10));
    System.out.println(OverloadingTest.max('x',90));
    System.out.println(OverloadingTest.max(20,40,10));
    }
}

class CarTest{
    public void carTest(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Input the make: ");
    String make = sc.nextLine();
    System.out.println("Input the model: ");
    String model = sc.nextLine();
    System.out.println("Input the year: ");
    int year = sc.nextInt();    
    Car chevy = new Car(make, model, year);
    chevy.show();
    Car ford = new Car();
    ford.show(); 
    sc.close();
    }
}

class Overloading{
    public int max(int a, int b, int c){
        int max = a;
        if(b > max) max=b;
        if(c > max) max=c;
        return max;
    }
    public int max(char a, int b){
        int max = a;
        if(b > max) max=b;
        return max;
    }
    public int max(String str, int a){
        int max = Integer.parseInt(str);
        if(a > max) max=a;
        return max;
    }
}

class Car{
    private String make;
    private String model;
    private int year;
    Car(String makeC, String modelC, int yearC){
        make = makeC;
        model = modelC;
        year = yearC;
    }
    Car(){
        make = "Ford";
        model = "Explorer";
        year = 2000;
    }
    public void show(){
        System.out.println("The make of the car is: " + make);
        System.out.println("The model of the car is: " + model);
        System.out.println("The year of the car is: " + year);
    }    
}
