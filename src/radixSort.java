import java.util.*;

class radixSort{
/**
 * takes in an array and returns false if there are no odd numbers and false if it finds an odd number in it
 * @param arr
 * @return
 */
public static boolean detectOdd(int arr[]){
    boolean temp = false;
        for (int i = 0; i < arr.length && temp !=true; i++) {
            if(arr[i] % 2 == 0){
            
            }else{
                temp = true;
            }

        }
        return temp;
}
/**
 * gets the maximum in a given array and returns it
 * @param arr
 * @return
 */
public static int getMax(int arr[]){
    int max = arr[0];
    for(int i = 0; i < arr.length;i++){
        if(arr[i] > max){
            max = arr[i];
        }
    }
    return max;
}
/**
 * takes in an array and prints it
 * @param arr
 */
public static void printArray(int arr[]){
   
    for (int i = 0; i < arr.length; i++) {
        System.out.print( arr[i] + " ");
    }
   System.out.println();
}
/**
 * the countSort method takes in the array to be sorted and the numsPlace that the Radix Sort is currently at and it sorts
 * the array based on the current numbers place starting with the ones place
 * 
 * @param arr
 * @param numsPlace
 */
public static void countSort(int arr[], int numsPlace){
    ArrayList<Integer> bucket
            = new ArrayList<Integer>(10);
    for (int i = 0; i < 10; i++) {
        bucket.add(i,0);
    }
    
    int temp;
    int[] output;
    output = new int[arr.length];
    Arrays.fill(output,0);

    for(int i = 0;i < arr.length;i++){
        temp = (arr[i]/numsPlace) % 10;
        int temp1 = bucket.get(temp) + 1;
        bucket.set(temp,temp1);
    }
    for (int i = 0; i < bucket.size(); i++) {
        int num;

        if(i>0){
            num = bucket.get(i-1) + bucket.get(i);
            bucket.set(i,num);
        }
    }
    
    for (int i = arr.length - 1; i >= 0; i--) {
        output[bucket.get((arr[i] / numsPlace) % 10) - 1] = arr[i];
        bucket.set((arr[i] / numsPlace) % 10,bucket.get((arr[i] / numsPlace) % 10) - 1);
    }
        
    
    
    for (int i = 0; i < output.length; i++) {
        arr[i] = output[i];
    }
    
}
/**
 * performRadixSort method takes in an input array it then calls the getMax method to find the maximum in the array.
 * Prints the array once before checking if there are odd numbers if there are odds it will abort if not it will call the
 * countSort method for as many numbers places as there are in the maximum number. It will start with the ones place sort 
 * everything based on that value then increment upwards until every nums place of the max value is sorted.
 *  It performs the Radix Sort then prints the final array.
 * @param arr
 */
public static void performRadixSort(int arr[]){
    int max = getMax(arr);
    System.out.print("Input for Radix sort is: ");
    printArray(arr);
    if (detectOdd(arr)){
        System.out.println("***Odd Detected. Terminating Program.***");
        System.exit(1);
    }
    for (int numsPlace = 1; max / numsPlace > 0; numsPlace *= 10){
            countSort(arr, numsPlace);
        }
        System.out.print("Output for Radix sort is: ");
    printArray(arr);
    }
public static void main(String[] args) {
    int[] input1 = {24, 12, 4, 366, 45, 66, 8, 14};
    int[] input2 = {24, 2, 4, 466, 48, 66, 8, 44};
    int [] input3 = {222,444,1234,5556,12,6,8,10,5};
    /*Main method to run the program to test, input sent to performRadix sort will be printed 
    then checked for odds, then sorted and printed again. if odd number is found program will be aborted
    */
    performRadixSort(input3);

}








}