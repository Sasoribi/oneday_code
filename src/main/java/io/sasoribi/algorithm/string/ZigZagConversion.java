package io.sasoribi.algorithm.string;


/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 */
public class ZigZagConversion {
    //6. Z 字形变换
    public String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder();
        int point = 0;
        boolean subside = false;
        
        //initial
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (!subside) {
                builders[point++].append(s.charAt(i));
            }
            
            //subside occasion
            if (subside) {
                builders[point--].append(s.charAt(i));
            }
            
            //reset
            if (point >= numRows) {
                point--;
            } else if (point < 0) {
                point++;
            }
            
            if (point == 0 || point == numRows - 1)
                subside = !subside;
        }
        
        //concat stringbuilders
        for (int i = 0; i < numRows; i++) {
            result.append(builders[i].toString());
        }
        return result.toString();
    }
}
