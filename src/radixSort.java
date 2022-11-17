import java.io.*;
import java.util.*;

class radixSort{
public static boolean detectOdd(int arr[]){
    boolean temp = false;
        for (int i = 0; i < arr.length && temp !=true; i++) {
            if(arr[i] % 2 == 0){
            
            }else{
                temp = false;
            }

        }
        return temp;
}
public static int getMax(int arr[]){
    int max = arr[0];
    for(int i = 0; i < arr.length;i++){
        if(arr[i] > max){
            max = arr[i];
        }
    }
    return max;
}
public static void printArray(int arr[]){
   
    for (int i = 0; i < arr.length; i++) {
        System.out.print( arr[i] + " ");
    }
   System.out.println();
}
public static void countSort(int arr[], int numsPlace){
    ArrayList<Integer> bucket
            = new ArrayList<Integer>(10);
    for (int i = 0; i < bucket.size(); i++) {
        bucket.set(i,0);
    }
    int temp;
    int[] output;
    output = new int[arr.length];
    Arrays.fill(output,0);

    for(int i = 0;i < arr.length;i++){
        temp = arr[i] % numsPlace;
        bucket.set(temp,bucket.get(temp) + 1);
        if(i > 0){
            bucket.set(i, bucket.get(i) + bucket.get(i-1));
        }
    }
    for (int i = 0; i < bucket.size(); i++) {
        if(bucket.get(i) > 0){
        
        output[bucket.get((arr[i] / numsPlace) % 10) - 1] = arr[i];
        bucket.set(i,bucket.get(i)- 1);
        }
    }
    for (int i = 0; i < output.length; i++) {
        arr[i] = output[i];
    }
}
public static void performRadixSort(int arr[]){
    int max = getMax(arr);
    for (int numsPlace = 1; max / numsPlace > 0; numsPlace *= 10){
            countSort(arr, numsPlace);
        }
    printArray(arr);
    }
    // TODO somethings broken here
    

public static void main(String[] args) {
    int[] input1 = {24, 12, 4, 366, 45, 66, 8, 14};
    int[] input2 = {24, 2, 4, 466, 48, 66, 8, 44};
    if (detectOdd(input1)){
        System.out.println("***Even Detected. Terminating Program.***");
        System.exit(1);
    }else{
        
        performRadixSort(input1);
    
    }

}








}