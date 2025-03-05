public class Person2 extends Object {
    private int age;
    private String name;
    
    public Person2(int age, String name){
        this.age = age;
        this.name = name;
    }   

    public void setAge(int age){
        this.age = age;
    }
  
    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return this.age;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return " Age: " + this.getAge() + " Name: " + this.getName();
    } 

    @Override
    public boolean equals(Object obj){
        Person2 p = (Person2)obj;
        return this.name.equals(p.name) && this.age == p.age;

    }
    
}