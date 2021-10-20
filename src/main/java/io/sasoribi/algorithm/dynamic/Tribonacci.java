package io.sasoribi.algorithm.dynamic;

/**
 * 泰波那契序列Tn定义如下：
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数n，请返回第 n 个泰波那契数Tn 的值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 * <p>
 * 输入：n = 25
 * 输出：1389537
 */
public class Tribonacci {
    //1137. 第 N 个泰波那契数
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        
        int temp;
        int pp = 0;
        int p = 1;
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            temp = result;
            result += pp + p;
            p = pp;
            pp = temp;
        }
        return result;
    }
}
