import java.util.Arrays;

public class RemoveDuplicatesFromArray {

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,2,3,3,3,4,4,5};
        int n = arr.length;
        System.out.println(Arrays.toString(removeDuplicatesInSortedArray(arr,n)));
        System.out.println(Arrays.toString(removeDuplicatesInPlace(arr,n)));

    }

    //solution using the O(n) space using a result array.
    public static int[] removeDuplicatesInSortedArray(int[] arr, int n) {
        int resultArr[] = new int[n];
        int i = 0;
        int k = 0;
        while(i < n-1) {
            int j = i + 1;
            if(arr[i] == arr[j]) {
                resultArr[k] = arr[i];
                while(arr[j] == arr[j+1]){
                    j++;
                }
                i = j;
            }
            else {
                resultArr[k] = arr[i];
                k++;
                i++;
            }
        }
        resultArr[k] = arr[i];
        return resultArr;
    }

    public static int[] removeDuplicatesInPlace(int[] arr, int n) {
        //arr = [1,2,2,3,3,3,4,4,5]
        int i = 0;
        int j = 1;
        while(j < n) {
            if(arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
                j++;
            }
            else {
                j++;
            }
        }
        return arr;
    }
}
