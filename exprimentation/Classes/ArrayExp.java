import java.util.Arrays;

public class ArrayExp {

    public static void main(String[] args) {
        int[] number3 = {1, 2, 3, 4, 5};
        String[] names = {"Allen", "Samuel", "LeeKnow"};
        
        // Update name at index 2
        names[2] = "Lilian";
        
        // Print size of names array
        printArraySize(names);
        
        // Print all names
        printNames(names);
        
        // Print all numbers in number3
        printNumbers(number3);
        
        // Calculate and print the sum of number3
        int sum = calculateSum(number3);
        System.out.println("Sum: " + sum);
        
        // Print average of number3
        printAverage(sum, number3.length);
        
        // Find and print the index of the max value in number3
        int maxIndex = findMaxIndex(number3);
        System.out.println("Max index: " + maxIndex);
        
        // Check for target number and count its occurrences
        int target = 3;
        int[] targetResults = countTargetOccurrences(number3, target);
        System.out.println("Target found: " + (targetResults[0] == 1));
        System.out.println("Target count: " + targetResults[1]);
        
        // Reverse the array and print
        int[] reversed = reverseArray(number3);
        printArray(reversed);

        // Shift the array to the right and print
        shiftRight(number3);
        printArray(number3);

        median(number3);
        }

    // Prints the size of the array
    public static void printArraySize(String[] array) {
        System.out.println("Array size: " + array.length);
    }

    // Prints all elements of the names array
    public static void printNames(String[] names) {
        for (String name : names) {
            System.out.println(name);
        }
    }

    // Prints all elements of the number3 array
    public static void printNumbers(int[] number3) {
        for (int num : number3) {
            System.out.println(num);
        }
    }

    // Calculates and returns the sum of the elements in the array
    public static int calculateSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    // Prints the average of the elements in the array
    public static void printAverage(int sum, int length) {
        System.out.println("Average: " + (sum / (double) length));
    }

    // Finds and returns the index of the max element in the array
    public static int findMaxIndex(int[] array) {
        int max = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[max]) {
                max = i;
            }
        }
        return max;
    }

    // Counts occurrences of the target in the array and returns a boolean (found/not found) and the count
    public static int[] countTargetOccurrences(int[] array, int target) {
        int count = 0;
        boolean found = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                found = true;
                count++;
            }
        }
        return new int[] {found ? 1 : 0, count};
    }

    // Reverses the array and returns the reversed version
    public static int[] reverseArray(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }

    // Prints the elements of an array
    public static void printArray(int[] array) {
        System.out.print("Array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Shifts the array to the right by one position
    public static void shiftRight(int[] array) {
        if (array.length > 0){
            int last = array[array.length - 1];
            for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
            }
             array[0] = last;
        } else{
            return;
        }
        
    }
 
    // Shifts the array to the left by one position
    public static void shiftLeft(int[] array) {
        if (array.length > 0 ){
            int first = array[0];
            for (int i = 0; i <= array.length - 2; i++) {
            array[i] = array[i + 1];
            }
            array[array.length - 1] = first;   
        }else{
            return;
        } 
    
    }

    // Swaps two elements in the array
    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right]; 
        array[right] = temp;
    }

    // Reverses the array in-place (using swap method)
    public static void reverseArrayInPlace(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }

    //median
    public static double median(int[] array) {
        Arrays.sort(array);
    
        if (array.length % 2 == 0) {
             return (array[array.length / 2 - 1] +  array[array.length / 2]) / 2.0;
        } else {
            return array[array.length / 2];
            
        }

    }


    

}
    
