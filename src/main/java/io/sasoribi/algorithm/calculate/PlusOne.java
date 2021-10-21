package io.sasoribi.algorithm.calculate;

public class PlusOne {
    public static void main(String[] args) {
        new PlusOne().plusOne(new int[]{9});
    }
    
    //66. Plus One
    public int[] plusOne(int[] digits) {
        
        int min = digits.length - 1;
        if ((digits[min] + 1) != 10) {
            digits[min]++;
            return digits;
        }
        
        
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
            
            if (i == 0) {
                int[] ans = new int[min + 2];
                ans[0] = 1;
                return ans;
            }
        }
        return null;
    }
}
