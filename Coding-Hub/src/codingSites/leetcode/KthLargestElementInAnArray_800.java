package codingSites.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray_800 {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargestAnother(int[] nums, int k) {
        if(nums.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((n1,n2) -> n2-n1);
        int totalElements = nums.length;
        for(int index = 0; index < totalElements; index++) {
            pq.add(nums[index]);
        }
        
        for(int index = 0; index< k-1; index++) {
            pq.poll();
        }
        
        return pq.peek();
    }
}
