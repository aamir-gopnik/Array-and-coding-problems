package EasyCodingProblems;

// Leetcode 67
public class SumOfBinaryStrings {

    public static void main(String[] args) {
        String s1 = "1011";
        String s2 = "0101";

        sumOfBinaryStrings(s1,s2);

    }

    public static void sumOfBinaryStrings(String s1, String s2) {
        int n1 = s1.length()-1;
        int n2 = s2.length()-1;
        int carry = 0, base = 2;
        StringBuilder result = new StringBuilder();
        while(n1 >= 0 || n2 >= 0) {
            int t1 = 0, t2 = 0, sum;
            if(n1 >= 0) {
                t1 = s1.charAt(n1--) - '0';
            }
            if(n2 >= 0) {
                t2 = s2.charAt(n2--) - '0';
            }
            sum = t1 + t2 + carry;
            if(sum >= base) {
                sum = sum - base;
                carry = 1;
            }
            else {
                carry = 0;
            }
            result.append(sum);
        }
        if(carry == 1)
            result.append(carry);
        System.out.println(result.reverse());
    }
}
