package ArrayProblems;

import java.util.Arrays;

public class RightShiftZeroes {

    /*
     * Right shift all zeroes in integer array while preserving the order of non-zero elements
     */

    public static void main(String[] args) {

        int[] arr = {1,2,3,0,0,4,0,1,0};
        //result array will be {1,2,3,4,1,0,0,0,0};
        int[] arr2 = {0,1,0,3,0,2,0,4};
        System.out.println(Arrays.toString(rightShiftOptimal(arr)));
        System.out.println(Arrays.toString(rightShiftZeroesBruteForce(arr)));

        System.out.println(Arrays.toString(rightShiftOptimal(arr2)));
        System.out.println(Arrays.toString(rightShiftZeroesBruteForce(arr2)));

    }

    public static int[] rightShiftOptimal(int[] inputArray) {
        int size = inputArray.length;
        int j = 0;
        for (int i = 0; i < size; i++) {
            if(inputArray[i] != 0)
            {
                inputArray[j] = inputArray[i];
                j++;
            }
        }

        while(j < size){
            inputArray[j] = 0; j++;
        }

        return inputArray;
    }

    //Time complexity = O(n + n) => O(n)
    //Space complexity = O(n) => temp array used
    public static int[] rightShiftZeroesBruteForce(int[] arr) {
        int size = arr.length;
        int[] temp = new int[size];
        int j = 0;
        for(int i = 0; i < size; i++) {
            if(arr[i] != 0) {
                temp[j] = arr[i];
                j++;
            }
        }

        //Copy back to original array
        for(int i = 0; i < size; i++) {
            arr[i] = temp[i];
        }

        return arr;
    }

}
