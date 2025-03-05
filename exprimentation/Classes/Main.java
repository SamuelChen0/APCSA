
public class Main{
    public static void main(String[] args) {
        Car samuel_car = new Car(5, "Tesla");
        System.out.print(samuel_car.no_of_seats);
        System.out.print(samuel_car.brand);
        samuel_car.displayInfo();

        Car allen_car = new Car(5,"Audi");
        System.out.print(allen_car.no_of_seats);
        System.out.print(allen_car.brand);
        allen_car.displayInfo();

        Car lilian_car = new Car(11,"BMW");
        System.out.print(lilian_car.no_of_seats);
        System.out.print(lilian_car.brand);
        lilian_car.displayInfo();

        Car serena_car = new Car(1,"Lexus");
        System.out.print(serena_car.no_of_seats);
        System.out.print(serena_car.brand);
        serena_car.displayInfo();

        Phone samuel_phone = new Phone("iPhone 12","Apple" );
        samuel_phone.displayInfo();
        samuel_phone.reduceBattery();
        samuel_phone.displayInfo();
        
        
        Phone myPhone = new Phone("iPhone 16", "Apple");
        myPhone.displayInfo();
        myPhone.reduceBattery();
        myPhone.displayInfo();
        myPhone.charge(5);
        myPhone.displayInfo();
        myPhone.openApp(11);

        // myPhone.type = "iPhone 15";
        System.out.println(myPhone.getType());
        System.out.println(myPhone.getBrand());
        System.out.println(myPhone.getBattery());
        System.out.println(myPhone.getMemory());
        myPhone.displayInfo();


        VendingMachine vendingMachine = new VendingMachine(5,5,5,5,5,5);

        System.out.println(vendingMachine.machine());

        vendingMachine.buyItem("Chocolate");
        vendingMachine.buyItem("Brownie");
        vendingMachine.buyItem("Milo");

        System.out.println(vendingMachine.machine());

        System.out.println("Total Revenue: " + vendingMachine.getTotalRevenue());

        vendingMachine.restock(5, 2, 3);

        System.out.println(vendingMachine.machine());

        vendingMachine.buyItem("Chocolate");
        vendingMachine.buyItem("Milo");

        System.out.println(vendingMachine.machine());

        System.out.println("Total Revenue: " + vendingMachine.getTotalRevenue());

      

        //bus

        Bus bus1 = new Bus(3);
        System.out.println(bus1.getCurrentStop());
        bus1.move();
        System.out.println(bus1.getCurrentStop());
        bus1.move();
        System.out.println(bus1.getCurrentStop());
        bus1.move();
        System.out.println(bus1.getCurrentStop());
        bus1.move();
        bus1.move();
        System.out.println(bus1.getCurrentStop());
        System.out.println(bus1.getCurrentStop());
        Bus bus2 = new Bus(5);
        System.out.println(bus1.getCurrentStop());
        System.out.println(bus2.getCurrentStop());

        //tr
        StepTracker tr = new StepTracker(10000);
        System.out.println(tr.activeDays());
        System.out.println(tr.averageSteps());
        tr.addDailySteps(9000);
        tr.addDailySteps(5000);
        System.out.println(tr.activeDays());
        System.out.println(tr.averageSteps());
        tr.addDailySteps(13000); 
        System.out.println(tr.activeDays());
        System.out.println(tr.averageSteps());
        tr.addDailySteps(23000);
        tr.addDailySteps(1111); 
        System.out.println(tr.activeDays());
        System.out.println(tr.averageSteps());

        //grade name age
        Student student = new Student(10, 15, "Samuel");
        student.displayInfo();
        
        student.setGradeLevel(11);
        student.setAge(16);
        student.setName("Samuel");
        student.displayInfo();

    }
}