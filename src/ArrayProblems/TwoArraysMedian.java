package ArrayProblems;

import java.util.Arrays;

public class TwoArraysMedian {

    /**
     * Given two sorted arrays arr1 and arr2, find the median of the array
     * after merging these two arrays.
     * @param args
     */
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,7};
        int[] arr2 = new int[]{4,5,6,8};
        int[] arr3 = new int[]{1,2,3};
        int[] arr4 = new int[]{4,5,8};
        System.out.println(Arrays.toString(mergeArrays(arr1,arr2)));
        System.out.println("Median of Array is " + calculateMedian(mergeArrays(arr1,arr2)));

    }

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int i=0;
        int j=0;
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] resultArray = new int[n1+n2];
        int k = 0;
        while(i < n1 && j < n2) {
            if(arr1[i] < arr2[j]){
                resultArray[k] = arr1[i];
                i++;
            }
            else {
                resultArray[k] = arr2[j];
                j++;
            }
            k++;
        }
        while(i < n1) {
            resultArray[k] = arr1[i];
            i++;
            k++;
        }
        while(j < n2) {
            resultArray[k] = arr2[j];
            j++;
            k++;
        }
        return resultArray;
    }

    public static double calculateMedian(int[] arr) {
        int n = arr.length;
        double medianOfArray;
        int middleIndex = (arr.length-1) / 2;
        if(n % 2 == 0) {
            medianOfArray = (arr[middleIndex] + arr[middleIndex+1]) / 2.0;
        }
        else {
            medianOfArray = arr[middleIndex];
        }
        return medianOfArray;
    }


}
