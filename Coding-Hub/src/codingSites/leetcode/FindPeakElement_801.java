package codingSites.leetcode;

import java.util.*;
// https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/801/

public class FindPeakElement_801 {
    public class PeekNumber {
        int val;
        int index;
        
        PeekNumber(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    
    public int findPeakElement(int[] nums) {
        if(nums.length == 0) return 0;
        
        PriorityQueue<PeekNumber> pq = new PriorityQueue<PeekNumber>((n1,n2) -> n2.val - n1.val);
        int totalElement = nums.length;
        
        for(int index = 0; index < totalElement; index++) {
            PeekNumber node = new PeekNumber(nums[index], index);
            pq.add(node);
        }
        
        return pq.peek().index;
    }
}
