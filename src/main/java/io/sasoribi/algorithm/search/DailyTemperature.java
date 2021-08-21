package io.sasoribi.algorithm.search;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 请根据每日 气温 列表 temperatures，重新生成一个列表，
 * 要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出:[1,1,4,2,1,1,0,0]
 * 示例 2:
 * <p>
 * 输入: temperatures = [30,40,50,60]
 * 输出:[1,1,1,0]
 * 示例 3:
 * <p>
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * <p>
 * 提示：
 * <p>
 * 1 <=temperatures.length <= 105
 * 30 <=temperatures[i]<= 100
 */
public class DailyTemperature {
    
    public static void main(String[] args) {
        Arrays.stream(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})).forEach(System.out::println);
    }
    
    //#剑指OFFER:038 单调栈---寻找栈中匹配的最大/最小值
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int[] stack = new int[temperatures.length];
        int size = 0;
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (size != 0 && temperatures[stack[size - 1]] <= temperatures[i]) {
                size--;
            }
            result[i] = size == 0 ? 0 : stack[size - 1] - i;
            stack[size++] = i;
        }
        return result;
    }
}
