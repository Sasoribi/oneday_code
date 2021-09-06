package io.sasoribi.algorithm.number;

import java.util.HashMap;
import java.util.Map;

public class RanTen {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(1,0);
        map.put(2,0);
        map.put(3,0);
        map.put(4,0);
        map.put(5,0);
        map.put(6,0);
        map.put(7,0);
        map.put(8,0);
        map.put(9,0);
        map.put(10,0);
        for (int i = 0; i < 10000; i++) {
            map.put((int) (Math.random() * 7 + 1),map.get((int)(Math.random() * 7) + 1) + 1);
            
        }
        System.out.println(map);
    }
    public int rand10() {
        
    return 0;
    }
    public int ran7(){
        return (int) Math.round(Math.random() * 7) + 1;
    }
}
