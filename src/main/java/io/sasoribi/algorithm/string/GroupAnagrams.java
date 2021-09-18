package io.sasoribi.algorithm.string;

import java.util.*;


/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 * <p>
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 * <p>
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 */
public class GroupAnagrams {
    public static void main(String[] args) {
    }
    
    //49. 字母异位词分组
    public List<List<String>> groupAnagrams(String[] strs) {
    
        List<String> tempList;
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] point = str.toCharArray();
            Arrays.sort(point);
            tempList = map.computeIfAbsent(new String(point), k -> new ArrayList<>());
            tempList.add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
    
    //超时答案
    public List<List<String>> groupAnagrams_timeout(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        
        List<String> tempList = new ArrayList<>();
        boolean[] checked = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (checked[i]) {
                continue;
            }
            char[] point = strs[i].toCharArray();
            Arrays.sort(point);
            tempList.add(strs[i]);
            checked[i] = true;
            for (int j = i + 1; j < strs.length; j++) {
                if (checked[j]) {
                    continue;
                }
                
                char[] cmp = strs[j].toCharArray();
                Arrays.sort(cmp);
                
                //相同时放入tempList
                if (String.copyValueOf(cmp).equals(String.copyValueOf(point))) {
                    tempList.add(strs[j]);
                    checked[j] = true;
                }
                //不同时应该也保存下来(利用Map,不然会导致同一个字符串多次排序)
            }
            
            result.add(new ArrayList<>(tempList));
            tempList.clear();
        }
        return result;
    }
}
