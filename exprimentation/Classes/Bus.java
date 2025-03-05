
public class Bus{
    private int no_of_stops;
    private int current_stop;
    private int moving_for;
    public Bus (int stops){
        this.no_of_stops = stops;
        this.current_stop = 1;
        this.moving_for = 1;

    }
    public int getCurrentStop(){
        return current_stop;
    }
    public void move(){
        current_stop  += moving_for;
        if (current_stop == 1 || current_stop == this.no_of_stops){
            moving_for *= -1;
        }
    }
    
}



