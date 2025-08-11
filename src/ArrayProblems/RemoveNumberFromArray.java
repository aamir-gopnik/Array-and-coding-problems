package ArrayProblems;

import java.util.Arrays;

public class RemoveNumberFromArray {

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,2};
        int num = 2;
        System.out.println(Arrays.toString(removeGivenNumberInPlace(arr,num)));
    }

    public static int[] removeGivenNumberInPlace(int[] arr, int num) {
        int k = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != num) {
                arr[k] = arr[i];
                k++;
            }
        }
        for(int i = 0; i < k; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
        return arr;
    }
}
