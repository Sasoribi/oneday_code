package io.sasoribi.algorithm.search.number;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31- 1],
 * then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned)
 */
public class ReveseInteger {
    //#7
    
    public static int reverse(int x) {
        int dum = 0;
        int digit;
        
        while (x != 0) {
            if (dum < Integer.MIN_VALUE / 10 || dum > Integer.MAX_VALUE / 10) {
                return 0;
            }
            //利用10余数获取尾位
            digit = x % 10;
            //消除尾位
            x /= 10;
            dum = dum * 10 + digit;
        }
        return dum;
    }
    
    // 时间复杂度高,代码复杂
    @Deprecated
    public static int reverseDeprecate(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        if (chars.length >= 10 && (chars[chars.length - 1] > '2' || chars[chars.length - 2] > '1')) {
            return 0;
        }
        char tmp;
        int j = 0;
        int i = 0;
        if (x < 0) {
            i++;
            j++;
        }
        
        for (; i < chars.length / 2 + j; i++) {
            tmp = chars[i];
            chars[i] = chars[chars.length - 1 - i + j];
            chars[chars.length - 1 - i + j] = tmp;
        }
        try {
            return Integer.parseInt(String.valueOf(chars));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    public static void main(String[] args) {
        reverseDeprecate(-2147483412);
    }
}
