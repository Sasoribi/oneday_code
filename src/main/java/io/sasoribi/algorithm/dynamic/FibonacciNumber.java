package io.sasoribi.algorithm.dynamic;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
 * 也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 */
public class FibonacciNumber {
    
    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        
        int fn = 0,temp;
        int ans = 1;
        for (int i = 2; i < n + 1; i++) {
            temp = ans;
            ans += fn;
            fn = temp;
        }
        return ans;
    }
    
    //fib->recursive->rough
    public int fib_bad(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        
        return fib(n - 1) + fib(n - 2);
    }
}
