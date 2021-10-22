package io.sasoribi.algorithm.calculate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {
    //229. 求众数 II-
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length / 3;
        for (int num : nums) {
            Integer current = map.get(num);
            if (current != null) {
                map.put(num, ++current);
            } else {
                current = 1;
                map.put(num, 1);
            }
            if (current - length == 1)
                ans.add(num);
        }
        
        return ans;
    }
}
