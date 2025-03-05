

public class Fibonnaci {
    
    public static int f(int n ){
        if( n == 0){
            return 0;
        } 
        if( n == 1){
            return 1;
        }
        return (f(n-1) + f(n-2));
    }

    public int sumArray(int[]arr, int n){
        if(n == 0){
            return arr[0];
        }
         return arr[n]+sumArray(arr, n-1);
    }
}
