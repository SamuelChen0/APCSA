
public class Car{
    public static Car samuel_car;
    int no_of_seats;
    String brand;

    public Car(int no_of_seats, String brand){
        this.no_of_seats = no_of_seats;
        this.brand = brand;
    }
    public void displayInfo(){
        System.out.println(" Brand: " + this.brand + " No. of seats: " + this.no_of_seats);
    }
}    

