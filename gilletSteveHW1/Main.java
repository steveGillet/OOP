// Steve Gillet Homework 1 OOP

import java.lang.Math;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Circle TestCircle = new Circle();
        System.out.println("Enter the radius of TestCircle");
        TestCircle.setRadius(sc.nextDouble());
        System.out.println("The radius is: " + TestCircle.getRadius());
        System.out.println("The circumference is: " + TestCircle.Circumference());
        System.out.println("The area is: " + TestCircle.Area());

        String empN[] = new String[3];
        int empID[] = new int[3];
        String empP[] = new String[3];
        String position;
        for(int i = 0; i<3; i++){
            if(i == 0){
                position = "first";
            }
            else if(i == 1){
                position = "second";
            }
            else{
                position = "third";
            }
            empN[i] = JOptionPane.showInputDialog(null, "Enter the " + position + " employee name: ");
            empID[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the " + position + " employee ID number: "));
            empP[i] = JOptionPane.showInputDialog(null, "Enter the " + position + " employee position: ");
        }    
        Employee emp1 = new Employee(empN[0], empID[0], empP[0]);
        Employee emp2 = new Employee(empN[1], empID[1], empP[1]);
        Employee emp3 = new Employee(empN[2], empID[2], empP[2]);
        JOptionPane.showMessageDialog(null, "Employee 1 Information (Click OK)");
        emp1.getInfo();
        JOptionPane.showMessageDialog(null, "Employee 2 Information (Click OK)");
        emp2.getInfo();
        JOptionPane.showMessageDialog(null, "Employee 3 Information (Click OK)");
        emp3.getInfo();
    }  
}
class Circle{
    private double Radius;
    public void setRadius(double rad){
        if (rad > 0 && rad < 50){
            Radius = rad;
        }
        else{
            System.out.println("The radius entered is not a double between 0 and 50.");
        }
    }
    public double getRadius(){
        return Radius;
    }
    public double Area(){
        return Math.PI * Radius * Radius;
    }
    public double Circumference(){
        return Math.PI * Radius;
    }
}

class Employee{
    private String name;
    private int ID;
    private String position;
    public Employee(String name1, int ID1, String position1){
        name = name1;
        ID = ID1;
        position = position1;
    }
    public void getInfo(){
        JOptionPane.showMessageDialog(null, "The employee's name is " + name + ", their ID number is " + ID + ", and their position is " + position + ".");
    }
}