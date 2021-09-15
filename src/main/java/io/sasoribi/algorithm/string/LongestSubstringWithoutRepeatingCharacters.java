package io.sasoribi.algorithm.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abba"));
    }
    
    //3. 无重复字符的最长子串 SetImpl->可用Map保存字符串位置,节省Latest指针遍历时间
    public int lengthOfLongestSubstring_Set(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Set<Character> cache = new HashSet<>();
        
        int latest = 0;
        int front = 1;
        int maxSubLength = 0;
        char l = s.charAt(latest);
        cache.add(l);
        
        while (front < s.length()) {
            char r = s.charAt(front);
            
            // 当前子串中存在快指针字符
            if (cache.contains(r)) {
                maxSubLength = Math.max(front - latest, maxSubLength);
                
                while ((l = s.charAt(latest++)) != r) {
                    cache.remove(l);
                }
                
                front++;
                cache.add(r);
                continue;
            }
            
            front++;
            cache.add(r);
        }
        //Flush Cache
        maxSubLength = Math.max(front - latest, maxSubLength);
        
        return maxSubLength;
    }
    
    //Map实现
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Map<Character, Integer> cache = new HashMap<>();
        
        int latest = 0;
        int front = 1;
        int maxSubLength = 0;
        cache.put(s.charAt(0), 0);
        
        while (front < s.length()) {
            char r = s.charAt(front);
            
            // 当前子串中存在快指针字符
            if (cache.containsKey(r)) {
                maxSubLength = Math.max(front - latest, maxSubLength);
                latest = Math.max(cache.get(r) + 1,latest);
            }
            cache.put(r, front);
            front++;
        }
        //Flush Cache
        maxSubLength = Math.max(front - latest, maxSubLength);
        
        return maxSubLength;
    }
}
