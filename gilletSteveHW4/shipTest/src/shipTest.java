public class shipTest {
    public static void main(String[] args) throws Exception {
        ship shipArr[] = new ship[6];
        shipArr[0] = new ship("SS Minnow", "1999");
        shipArr[1] = new ship("Little Bastard", "2012");
        shipArr[2] = new cruiseShip("Backpage", "2019", 2000);
        shipArr[3] = new cruiseShip("Big Papa", "1994", 500);
        shipArr[4] = new cargoShip("Bundt Cake", "2012", 35);
        shipArr[5] = new cargoShip("Buy Me Food", "2009", 600);
        for(int i = 0; i < shipArr.length; i++){
            System.out.println(shipArr[i].toString());
        }
    }
}

class ship{
    protected String name;
    protected String year;
    ship(String name, String year){
        this.name = name;
        this.year = year;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getYear() {
        return year;
    }
    public String toString() {
        return "The " + name + " was built in " + year + ".";
    }
}

class cruiseShip extends ship{
    private int maxPass;
    cruiseShip(String name, String year, int max){
        super(name, year);
        maxPass = max;
    }
    public void setMaxPass(int max){
        maxPass = max;
    }
    public int getMaxPass(){
        return maxPass;
    }
    public String toString(){
        return "The " + name + " holds " + maxPass + " passengers.";
    }
}

class cargoShip extends ship{
    private int capacity;
    cargoShip(String name, String year, int cap){
        super(name, year);
        capacity = cap;
    }
    public void setCapacity(int cap){
        capacity = cap;
    }
    public int getCapacity(){
        return capacity;
    }
    public String toString(){
        return "The " + name + " holds " + capacity + " tons.";
    }
}