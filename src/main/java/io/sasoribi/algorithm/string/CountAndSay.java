package io.sasoribi.algorithm.string;

/**
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * <p>
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 */
public class CountAndSay {
    //38. 外观数列
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String recursive = countAndSay(n - 1);

        char[] chars = recursive.toCharArray();
        StringBuilder results = new StringBuilder();

        //计算字符tick
        int tick = 0;
        for (int i = 0; i < chars.length; i++) {
            tick++;
            if (i == chars.length - 1 || chars[i] != chars[i + 1]) {
                results.append(tick).append(chars[i]);
                //写入字符后清0,tick
                tick = 0;
            }
        }
        return results.toString();
    }
}
