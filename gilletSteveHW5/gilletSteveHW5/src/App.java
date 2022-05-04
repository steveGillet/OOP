public class App {
    public static void main(String[] args) throws Exception {
        Building b1 = new Building();
        Car c1 = new Car();
        Bicycle bike1 = new Bicycle();
        carbonFootprint carbon;

        carbon = b1;
        carbon.getCarbonFootprint(199);
        
        carbon = c1;
        carbon.getCarbonFootprint(2000);
        
        carbon = bike1;
        carbon.getCarbonFootprint(9);

        shipTest s = new shipTest();
    }
}

class shipTest{
    shipTest(){
        description[] d = new description[6];
        Yacht y1 = new Yacht("SS Minnow Johnson", "1999", "Sam Jack");
        Yacht y2 = new Yacht("Red Dragon", "2002", "Johnathon Donathon");
        String[] cities1 = {"Houston","Bangkok", "Hong Kong", "Taiwan"};
        CruiseShip cru1 = new CruiseShip("Big Boy", cities1, 2000);
        String[] cities2 = {"San Antonio", "New York", "Tokyo", "Maui"};
        CruiseShip cru2 = new CruiseShip("Little Man", cities2, 3000);
        CargoShip car1 = new CargoShip("Big Willy", 4500, "Los Angeles", "Moscow");
        CargoShip car2 = new CargoShip("Big Ben", 2300, "Paris", "London");

        d[0] = y1;
        d[1] = y2;
        d[2] = cru1;
        d[3] = cru2;
        d[4] = car1;
        d[5] = car2;

        for(int i = 0; i < d.length; i++){
            d[i].describeShip();
        }
    }
}

interface carbonFootprint{
    void getCarbonFootprint(int carbon);
}

class Building implements carbonFootprint {
    public void getCarbonFootprint(int carbon){
        System.out.println("This buildings carbon footprint is: " + carbon);
    }
}

class Car implements carbonFootprint {
    public void getCarbonFootprint(int carbon){
        System.out.println("This cars carbon footprint is: " + carbon);
    }
}

class Bicycle implements carbonFootprint {
    public void getCarbonFootprint(int carbon){
        System.out.println("This bicycles carbon footprint is: " + carbon);
    }
}

interface description{
    void describeShip();
}

class Yacht implements description {
    private String name;
    private String year;
    private String owner;

    Yacht(String n, String y, String o){
        name = n;
        year = y;
        owner = o;
    }

    public void setName(String n){
        name = n;
    }
    public void setYear(String y){
        year = y;
    }
    public void setOwner(String o){
        owner = o;
    }

    public String getName(){
        return name;
    }
    public String getYear(){
        return year;
    }
    public String getOwner(){
        return owner;
    }

    public void describeShip(){
        System.out.println("The " + name + " was built in " + year + " and belongs to " + owner + ".");
    }
}

class CruiseShip implements description {
    private String name;
    private String[] cities;
    private int passengers;

    CruiseShip(String n, String[] c, int p){
        name = n;
        cities = c;
        passengers = p;
    }

    public void setName(String n){
        name = n;
    }
    public void setcities(String[] c){
        cities = c;
    }
    public void setPassengers(int p){
        passengers = p;
    }

    public String getName(){
        return name;
    }
    public String[] getcities(){
        return cities;
    }
    public int getPassengers(){
        return passengers;
    }

    public void describeShip(){
        System.out.println("The " + name + " carries " + passengers + " passengers and visits: ");
        for(int i = 0; i < cities.length; i++){
            System.out.println(cities[i]);
        }
    }
}

class CargoShip implements description {
    private String name;
    private int tonnage;
    private String portDep;
    private String portDest;

    CargoShip(String n, int t, String pDep, String pDest){
        name = n;
        tonnage = t;
        portDep = pDep;
        portDest = pDest;
    }

    public void setName(String n){
        name = n;
    }
    public void settonnage(int t){
        tonnage = t;
    }
    public void setPortDep(String pDep){
        portDep = pDep;
    }
    public void setPortDest(String pDest){
        portDest = pDest;
    }

    public String getName(){
        return name;
    }
    public int getTonnage(){
        return tonnage;
    }
    public String getPortDep(){
        return portDep;
    }
    public String getPortDest(){
        return portDest;
    }

    public void describeShip(){
        System.out.println("The " + name + " can carry " + tonnage + " tons and departs from " + portDep + " and arrives at " + portDest + ".");
    }
}