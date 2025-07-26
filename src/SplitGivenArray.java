import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitGivenArray {

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6,7,8,9,14,10};
        int winSize = 3;
        System.out.println(Arrays.deepToString(splitArray(arr,winSize).toArray()));
        System.out.println(Arrays.deepToString(splitArrayBasic(arr,winSize).toArray()));
    }

    /**
     * Using List<List<Integer>> implementation
     * @param arr - input array
     * @param winSize - window size for splitting array
     * @return - List<List<Integer>>
     */
    public static List<List<Integer>> splitArray(int[] arr, int winSize) {

        //handling edge cases
        if(winSize == 0 || winSize >= arr.length) {
            return List.of(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        }
        List<List<Integer>> arrayList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>(winSize);
        int startIdx = 0;
        int endIdx = winSize;
        while(startIdx < arr.length) {
            if(startIdx == endIdx) {
                startIdx = endIdx;
                endIdx = endIdx + winSize;
                arrayList.add(intList);
                intList = new ArrayList<>(winSize);
                continue;
            }
            intList.add(arr[startIdx]);
            startIdx++;
        }
        arrayList.add(intList);
        return arrayList;
    }

    public static List<int[]> splitArrayBasic(int[] arr, int winSize) {

        //handling edge cases
        if(winSize == 0 || winSize >= arr.length) {
            return List.of(arr);
        }
        List<int[]> arrayList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>(winSize);
        int smallArr[] = new int[winSize];
        int startIdx = 0;
        int endIdx = winSize;
        int smallIdx = 0;
        while(startIdx < arr.length) {
            if(startIdx == endIdx) {
                startIdx = endIdx;
                endIdx = endIdx + winSize;
                arrayList.add(smallArr);
                smallArr = new int[winSize];
                smallIdx = 0;
                continue;
            }
            smallArr[smallIdx] = arr[startIdx];
            smallIdx++;
            startIdx++;
        }
        // If last array is partially filled, copy only the valid part
        if (smallIdx > 0) {
            int[] partial = new int[smallIdx];
            System.arraycopy(smallArr, 0, partial, 0, smallIdx);
            arrayList.add(partial);
        }
        return arrayList;
    }

    public static List<int[]> splitArrayOptimized(int[] arr, int winSize) {
        if (winSize <= 0 || winSize >= arr.length) {
            return List.of(arr);
        }

        List<int[]> result = new ArrayList<>();

        int index = 0;
        while (index < arr.length) {
            int size = Math.min(winSize, arr.length - index);
            int[] chunk = new int[size];
            System.arraycopy(arr, index, chunk, 0, size);
            result.add(chunk);
            index += winSize;
        }

        return result;
    }
}
