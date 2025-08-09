import java.util.Arrays;

public class MaxSumSubarray {

    public static void main(String[] args) {
        int[] arr = {-1,-1,-1,-2,-1};
        int n = arr.length;
        maxSumSubArrayBrute(arr,n);
        System.out.println("Using Kadane's Algo -> ");
        maxSumSubArray(arr,n);

    }

    public static void maxSumSubArrayBrute(int[] arr, int n) {
        int maxSum = Integer.MIN_VALUE;
        for( int i = 0; i < n; i++) {
            int currSum = 0;
            for(int j = i; j < n; j++) {
                currSum = currSum + arr[j];
                maxSum = Math.max(currSum, maxSum);
            }
        }
        System.out.println("Max sum is -> " + maxSum);
    }

    //Optimized solution-> Kadane's Algorithm
    public static void maxSumSubArray(int[] arr, int n) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int i = 0;
        while(i < n) {
            if(currSum < 0) {
                currSum = 0;
            }
            currSum = currSum + arr[i];
            maxSum = Math.max(maxSum, currSum);
            i++;
        }
        System.out.println(maxSum);
    }
}
