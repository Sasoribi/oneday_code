package io.sasoribi.algorithm.number;

/**
 * Given an integer x, return true if x is palindrome integer.
 * <p>
 * An integer is a palindrome when it reads the same backward as forward.
 * For example, 121 is palindrome while 123 is not.
 * <p>
 * Example 1:
 * <p>
 * Input: x = 121
 * Output: true
 * Example 2:
 * <p>
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121.
 * From right to left, it becomes 121-.
 * Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Example 4:
 * <p>
 * Input: x = -101
 * Output: false
 * <p>
 * Constraints:
 * <p>
 * -2^31 <= x <= 2^31 - 1
 * <p>
 * Follow up: Could you solve it without converting the integer to a string?
 */
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }
    
    //#9 回文数
    public static boolean isPalindrome(int x) {
        if (x >= 0 && x <= 9)
            return true;
        if (x < 0 || x % 10 == 0)
            return false;
        int digit;
        int tmp = 0;
        while (x > 0 && tmp <= Integer.MAX_VALUE / 10) {
            
            digit = x % 10;
            tmp = tmp * 10 + digit;
            
            if (tmp == x)
                return true;
            
            x /= 10;
            
            if (tmp == x)
                return true;
        }
        return false;
    }
}
