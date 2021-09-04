package io.sasoribi.algorithm.calculate;

/**
 * Given a non-negative integer x, compute and return the square root of x.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated,
 * and only the integer part of the result is returned.
 * <p>
 * Note:You are not allowed to use any built-in exponent function or operator,
 * such as pow(x, 0.5) or x ** 0.5.
 */
public class Sqrtx {
    public static void main(String[] args) {
        System.out.println(new Sqrtx().mySqrt(2147395599));
    }
    
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int mid = 0;
        //prevent int overflow
        long result = 0;
        
        while (left < right) {
            mid = left + (right - left >>> 1);
            result = (long) mid * mid;
            
            if (result == x) {
                return mid;
            }
            
            if (result < x) {
                if ((long) (mid + 1) * (long) (mid + 1) > x) {
                    return mid;
                }
                left = mid + 1;
            }
            
            if (result > x) {
                right = mid - 1;
            }
        }
        return left;
    }
}
