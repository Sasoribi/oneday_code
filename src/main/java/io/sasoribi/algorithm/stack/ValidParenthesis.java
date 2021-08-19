package io.sasoribi.algorithm.stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * 1.Open brackets must be closed by the same type of brackets.
 * 2.Open brackets must be closed in the correct order.
 */
public class ValidParenthesis {
    //#20
    
    
    
    //Too Complex
    @Deprecated
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        char[] stack = new char[chars.length];
        int j = 0;
        
        for (char c : chars) {
            if(j<0)
                return false;
            //stack push
            if (c == '(' || c == '{' || c == '[') {
                stack[j] = c;
                j++;
            }
            if (c == ')') {
                if (j > 0 && stack[j-1] != '(')
                    return false;
                else
                    j--;
            }
            if (c == '}') {
                if (j > 0 && stack[j-1] != '{')
                    return false;
                else
                    j--;
            }
            if (c == ']') {
                if (j > 0 && stack[j-1] != '[')
                    return false;
                else
                    j--;
            }
        }
        return j == 0;
    }
}
