package io.sasoribi.algorithm.string;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {
    
    /**
     * 纵向扫描
     *
     * @param strs
     *
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs[0].isEmpty())
            return "";
        
        int strsl = strs.length;
        int strl = strs[0].length();
        char needle;
        
        for (int i = 0; i < strl; i++) {
            needle = strs[0].charAt(i);
            for (int j = 1; j < strsl; j++) {
                if (i == strs[j].length() || needle != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
