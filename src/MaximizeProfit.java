import java.util.HashMap;
import java.util.Map;

public class MaximizeProfit {

    public static void main(String[] args) {
        /*int[] input1 = {4,1,5,5,7};
        int[] input2 = {-1,10,15,10,-4};*/
        int[] input1 = {3,6,3};
        int[] input2 = {10,15,10};
        int result = maxProfit(input1,input2,input1.length);
        System.out.println("Max profit is -> " + result);

        //input is the profit earned from selling items from input 1
        //write code to maximize the profit and keep in mind if item is sold for consecutive days
        //then only single day profit will be considered.
    }

    public static int maxProfit(int[] input1, int[] input2, int input3) {
        Map<Integer, Integer> profitMap = new HashMap<>();
        Integer prevProduct = null;
        for(int i = 0; i < input3; i++) {
            int productId = input1[i];
            int profit = input2[i];
            if(prevProduct == null || prevProduct != productId) {
                profitMap.put(productId, profitMap.getOrDefault(productId,0) + profit);
            }
            prevProduct = input1[i];
        }

        System.out.println("Map after each product profit -> " + profitMap);
        System.out.println("Map Values -> " + profitMap.values());
        int maximumProfit = 0;
        for(Integer i : profitMap.values()) {
           if(i > 0)
           {
               maximumProfit += i;
           }
        }
        return maximumProfit;
    }

    public static int maxNum(int a, int b) {
        return Math.max(a, b);
    }
}
