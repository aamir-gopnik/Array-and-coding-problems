package ArrayProblems;

public class SecondLargestElement {

    public static void main(String[] args) {
        int[] inputArr = {2,7,3,9,4,6,1,20};
        System.out.println(secondLargestElement(inputArr));
        System.out.println(secondLargestElement(null));


    }

    public static int secondLargestElement(int[] arr) {
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("Invalid array provided");
        }
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length-1; i++) {
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }
        }
        return secondLargest;
    }
}
