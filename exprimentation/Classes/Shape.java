
public abstract class Shape {
    public String color;

    public Shape(String color){
        this.color = color;
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void displayInfo(){
        System.out.println("The color is "+ this.color);
    }

    public abstract double calculateArea();
    
}