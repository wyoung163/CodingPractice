package Algorithm.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Concept {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int target = scan.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scan.nextInt();
        }

        int result = binarySearch(arr, target, 0, n-1);
        
        if(result == -1){
            System.out.println("none");
        } else {
            System.out.println(result + 1);
        }
    }
    public static int binarySearch(int arr[], int target, int start, int finish){
        if(finish <= start) return -1;
        int mid = (start + finish) / 2;
        if(arr[mid] == target) return mid;

        if(target < arr[mid]){
            return binarySearch(arr, target, start, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, finish);
        }
    }
}
