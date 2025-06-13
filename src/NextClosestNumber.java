import java.util.*;

public class NextClosestNumber {

    public static void main(String[] args) {
        String num = "1234";
        findCombinations(num);

    }
    //1234
    //1234 -> [1,2,3,4,12,13,14,23,24,34,123,124,134,234,1234]
    //Apply recursion and backtracking to achieve this solution.

    public static void findCombinations(String numStr) {
        List<Integer> numList = new ArrayList<>();
        int len = numStr.length();
        for (int start = 0; start < len; start++) {
            StringBuilder sb = new StringBuilder();
            for (int end = start; end < len; end++) {
                sb.append(numStr.charAt(end));
                numList.add(Integer.parseInt(sb.toString()));
            }
        }
        /*for (int i = 0; i < numStr.length(); i++) {
            for (int j = i; j < numStr.length(); j++) {
                String subStr = numStr.substring(i, j + 1);
                numList.add(Integer.parseInt(subStr));
            }
        }*/

        System.out.println(numList);
    }


    private static void permute(String prefix, String remaining, Set<Integer> result) {
        if (remaining.isEmpty()) {
            result.add(Integer.parseInt(prefix)); // Convert and add the number
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            String newPrefix = prefix + remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            permute(newPrefix, newRemaining, result);
        }
    }

}
