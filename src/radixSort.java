import java.util.Scanner;
class radixSort{
public static int getMax(int arr[]){
    int max = arr[0];
    for(int i = 0; i < arr.length;i++){
        if(arr[i] > max){
            max = arr[i];
        }
    }
    return max;
}
public static void countSort(int arr[]){
    int[] bucket = new int[10];
    for(int i = 0;i < arr.length;i++){
        
        
        
    }
    System.out.println(bucket);
}
public static void main(String[] args) {
    int[] input1 = {24, 12, 4, 366, 45, 66, 8, 14};
    int[] input2 = {24, 2, 4, 466, 48, 66, 8, 44};
    

}








}