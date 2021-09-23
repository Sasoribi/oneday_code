package io.sasoribi.algorithm.calculate;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        new GenerateParentheses().generateParenthesis(3);
    }
    
    //22. 括号生成
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        
        int count = n * 2;
        
        recursiveInvoke(temp, n, n, 0, result);
        
        return result;
    }
    
    private void recursiveInvoke(StringBuilder temp, int leftBrace, int rightBrace, int index, List<String> result) {
        if (leftBrace > rightBrace) {
            return;
        }
        
        if (rightBrace == 0 && leftBrace == 0) {
            result.add(temp.toString());
            return;
        }
        if (leftBrace > 0) {
            temp.append('(');
            --leftBrace;
            recursiveInvoke(temp, leftBrace, rightBrace, index + 1, result);
            temp.deleteCharAt(temp.length() - 1);
            leftBrace++;
        }
        if (rightBrace > 0) {
            temp.append(')');
            --rightBrace;
            recursiveInvoke(temp, leftBrace, rightBrace, index + 1, result);
            temp.deleteCharAt(temp.length() - 1);
        }
        
        
    }
}
