

public class Phone {
    
    private String type;
    private String brand;
    private int battery_level;
    private int memory_used;
    


    public Phone(String type, String brand) {
        this.type = type;
        this.brand = brand;
        this.battery_level = 100;
        this.memory_used = 0;
    }

    public String getType(){
        return this.type;
    }

    public void setType(String newType){
        this.type = newType;
    }

    public String getBrand(){
        return this.brand;
    }

    public void setBrand(String newBrand){
        this.type = newBrand;
    }

    public int getBattery(){
        return this.battery_level;
    }

    public void setBattery(int newBattery){
        this.battery_level = newBattery;
    }

    public int getMemory(){
        return this.memory_used;
    }

    public void setMemory(int newMemory){
        this.memory_used = newMemory;
    }


    public void displayInfo() {
        System.out.println("Brand: " + this.brand + " Type: " + this.type + " battery level: " + this.battery_level + this.memory_used);
        this.lowBattery();
    }

    public void reduceBattery() {
        if (this.battery_level > 0) {
            this.battery_level--;
        } else {
            System.out.println("Battery is empty");
        }
    }

    public void charge(int charging) {
        if (charging < 0) {
            System.out.println(" no negative");
            return;
        }
        while (charging > 0){
            this.battery_level ++;
            charging -- ;
        }
        
        if (this.battery_level > 100) {
            this.battery_level = 100;
        }
    }

    public void lowBattery(){
        if (this.battery_level <= 5){
            System.out.println("Low battery! Charge now");
        }
        if (this.battery_level <1){
            System.out.println("No battery...");
        }
    }
    
    public void openApp(int apps){
        if (memory_used < 10 && apps > 0){
            memory_used ++;
            apps --;

        } else {
            System.err.println("You can't open more than 10 apps");
        }

    }


}
