public class TwodArray {

    public static int sum(int[][] array) {
      
        int sum = 0;

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                sum = sum + array[row][col];
            }
        }

        return sum;

    }

    public static int max(int[][]array) {
        
        int max = Integer.MIN_VALUE;

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if (array[row][col] > max ){
                    max = array[row][col];
                }
            }
        }
        
        return max;

    }

    public static void check(int[][]array , int num){

        boolean exists = false;
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if (array[row][col] == num ){
                    exists = true;
                } 
            }
        }
        System.out.println(exists);

    }
    

    public static int[][] transpose(int[][] array){
        int n = array.length;
       
        int[][] transposed = new int[n][n];
    
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                transposed[col][row] = array[row][col];
            }
        }
    
        return transposed;


    }
    public static void main( String[] args){
        int[][] array = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int sum = TwodArray.sum(array);
        System.out.println("Sum : " + sum);

      
        int max = TwodArray.max(array);
        System.out.println("Maximum : " + max);

        int numToCheck = 5;
        System.out.println("Checking if " + numToCheck + " exists in the array");
        TwodArray.check(array, numToCheck);
        
  
        int[][] transposed = TwodArray.transpose(array);
        System.out.println("Transposed array:");
        for (int i = 0; i < transposed.length; i++) {
            for (int j = 0; j < transposed[i].length; j++) {
                System.out.print(transposed[i][j] + " ");
            }
            System.out.println();
        }

        

    }

}