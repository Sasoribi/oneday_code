package io.sasoribi.algorithm.number;

/**
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 * <p>
 * Given an integer n, return true if n is an ugly number.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * Example 2:
 * <p>
 * Input: n = 8
 * Output: true
 * Explanation: 8 = 2 × 2 × 2
 * Example 3:
 * <p>
 * Input: n = 14
 * Output: false
 * Explanation: 14 is not ugly since it includes the prime factor 7.
 * Example 4:
 * <p>
 * Input: n = 1
 * Output: true
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 */
public class UglyNumber {
    //263. Ugly Number
    public boolean isUgly(int n) {
        if (n == 1)
            return true;
        if (n <= 0)
            return false;
        //n%2==0 -> 获得另一个因数继续判断是否为丑数
        if (n % 2 == 0)
            return isUgly(n / 2);
        if (n % 3 == 0)
            return isUgly(n / 3);
        if (n % 5 == 0)
            return isUgly(n / 5);
        return false;
    }
}
