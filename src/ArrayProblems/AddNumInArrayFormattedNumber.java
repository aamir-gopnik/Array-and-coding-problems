package ArrayProblems;

import java.util.Arrays;

public class AddNumInArrayFormattedNumber {

    public static void main(String[] args) {
        int[] arr = {1,2,6};
        int num = 4;
        int[] newArr = AddNumber(arr, num);
        System.out.println(Arrays.toString(newArr));


    }

    /**
     * In the given array eg {1,2,3} add a number so that array becomes {1,2,3,4}
     * {9} -> {1,0}
     * {9,9} -> {1,0,0}
     * @param arr
     */
    public static int[] AddNumber(int[] arr, int num) {
        int n = arr.length;
        int i = n-1;
        int carry = num, decimalBase = 10;
        while(i >= 0) {
            int sum = arr[i] + carry;
            if(sum >= decimalBase) {
                sum = sum - decimalBase;
                arr[i] = sum;
                carry = 1;
                if(i == 0) {
                    int[] newArray = new int[n+1];
                    newArray[0] = carry;
                    System.arraycopy(arr,0, newArray, 1,n);
                    arr = newArray;
                }
            }
            else {
                arr[i] = sum;
                carry = 0;
            }
            i--;
        }
        return arr;
    }
}
