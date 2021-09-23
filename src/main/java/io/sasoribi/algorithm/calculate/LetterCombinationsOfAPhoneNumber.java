package io.sasoribi.algorithm.calculate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinationsOfAPhoneNumber {
    //17. 电话号码的字母组合
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.isEmpty())
            return result;
        
        Map<Character, char[]> characterMap = constructMap();
        
        char[] numsArray = digits.toCharArray();
        
        StringBuilder builder = new StringBuilder();
        
        recursiveInvoke(builder, result, 0, numsArray, characterMap);
        return result;
    }
    
    private void recursiveInvoke(StringBuilder builder, List<String> result, int i,
                                 char[] numsArray, Map<Character, char[]> characterMap) {
        if(i == numsArray.length){
            result.add(builder.toString());
            return;
        }
        
        char num = numsArray[i];
        char[] chars = characterMap.get(num);
        
        for (char cc : chars) {
            builder.append(cc);
            recursiveInvoke(builder, result, i+1, numsArray, characterMap);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
    
    private Map<Character, char[]> constructMap() {
        Map<Character, char[]> numsMap = new HashMap<>();
        numsMap.put('2', new char[]{'a', 'b', 'c'});
        numsMap.put('3', new char[]{'d', 'e', 'f'});
        numsMap.put('4', new char[]{'g', 'h', 'i'});
        numsMap.put('5', new char[]{'j', 'k', 'l'});
        numsMap.put('6', new char[]{'m', 'n', 'o'});
        numsMap.put('7', new char[]{'p', 'q', 'r', 's'});
        numsMap.put('8', new char[]{'t', 'u', 'v'});
        numsMap.put('9', new char[]{'w', 'x', 'y', 'z'});
        return numsMap;
    }
}
