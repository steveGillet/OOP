import java.util.Scanner;

public class gilletSteveHW3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the length of the room: ");
        double len = sc.nextDouble();
        System.out.println("Please enter the width of the room: ");
        double w = sc.nextDouble();
        roomDimension rD = new roomDimension(len, w);
        System.out.println("Please enter the price of the carpeting: ");
        double price = sc.nextDouble();
        roomCarpet rC = new roomCarpet(rD, price);
        System.out.println(rC.toString());

        //////////////////////////////////////////////////////////////////////

        int choice = 0;

        while(choice != 4){
        System.out.println("Geometry Calculator");
        System.out.println("1. Calculate the Area of a Circle");
        System.out.println("2. Calculate the Area of a Rectangle");
        System.out.println("3. Calculate the Area of a Triangle");
        System.out.println("4. Quit");
        System.out.println("Enter your choice(1-4):");
        choice = sc.nextInt();
        if(choice == 1){
            System.out.println("Please enter the radius: ");
            double radius = sc.nextDouble();
            double area = geometry.areaCircle(radius);
            if(area >= 0) System.out.println("The area of the circle is " + area);
        }
        else if(choice == 2){
            System.out.println("Please enter the length and width: ");
            double length = sc.nextDouble();
            double width = sc.nextDouble();
            double area = geometry.areaRectangle(length, width);
            if(area >= 0) System.out.println("The area of the rectangle is " + area);
        }
        else if(choice == 3){
            System.out.println("Please enter the base and height: ");
            double base = sc.nextDouble();
            double height = sc.nextDouble();
            double area = geometry.areaTriangle(base, height);
            if(area >= 0) System.out.println("The area of the triangle is " + area);
        }
        else if(choice == 4) continue;
        else System.out.println("Error. Your selection must be an integer from 1 to 4.");
        }    
        sc.close();
    }
}

class roomDimension{
    private double length;
    private double width;
    roomDimension(double len, double w){
        length = len;
        width = w;
    }
    public double getArea(){
        return length * width;
    }
    public String toString(){
        return "The size of the carpet is " + getArea() + " and the cost is " + roomCarpet.getTotalCost() + ".";
    }
}

class roomCarpet{
    private static roomDimension size;
    private static double carpetCost;
    roomCarpet(roomDimension dim, double cost){
        size = dim;
        carpetCost = cost;
    }
    public static double getTotalCost(){
        return carpetCost * size.getArea();
    }
    public String toString(){
        return size.toString();
    }
}

class geometry{
    public static double areaCircle(double r){
        if(r < 0) System.out.println("Error, the radius cannot be negative.");
        return Math.PI * r * 2;
    }
    public static double areaRectangle(double len, double w){
        if(len < 0 || w < 0) System.out.println("Error, the length and width cannot be negative.");
        return len * w;

    }
    public static double areaTriangle(double base, double height){
        if(base < 0 || height < 0) System.out.println("Error, the base and height cannot be negative.");
        return base * height / 2;
    }
}