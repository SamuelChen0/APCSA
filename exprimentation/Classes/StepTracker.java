
public class StepTracker{
    private int activeDays;
    private double average;
    private int goal;
    private int n;
    private double sum;
    public StepTracker (int goal){
        this.activeDays = 0;
        this.average = 0.0;
        this.goal = goal;
        this.n = 0;
    }
    public void addDailySteps(int steps){
    	if (steps >= goal){
            this.activeDays += 1;
        }
        this.n += 1;
        this.sum += steps;

        
    }
    public double averageSteps(){
        if (this.n == 0){
            return 0.0;
        }else{
            this.average = this.sum / this.n;
            return this.average;
        }
        
    }
    public int activeDays(){
        return this.activeDays;
    }
}


