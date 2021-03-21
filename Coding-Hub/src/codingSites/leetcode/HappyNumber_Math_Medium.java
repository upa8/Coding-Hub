package codingSites.leetcode;

import java.util.*;

public  class HappyNumber_Math_Medium {
    public boolean isHappy(int n) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        while(true) {
            if(hm.containsKey(n)) {
                break;
            } else {
                hm.put(n, 0);
                n = digitSquareSum(n);
                if(n == 1) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public int digitSquareSum(int num) {
        int result = num;
        int digitSquareSum = 0;
        while(result>=10) {
            int lastDigit = result % 10;
            digitSquareSum += (lastDigit * lastDigit);
            result = result / 10;
        }
        
        digitSquareSum += (result*result);
        
        return digitSquareSum;
    }
    
}