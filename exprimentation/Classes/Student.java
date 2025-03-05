
public class Student extends Person { 
    private int gradeLevel;

    public Student(int gradeLevel, int age, String name){
        super(age, name);
        this.gradeLevel = gradeLevel;
    }

    public void setGradeLevel(int gradeLevel){
        this.gradeLevel = gradeLevel;
    }
    
    public int getGradeLevel(){
        return this.gradeLevel;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Grade level: " + this.gradeLevel);
    }
}