package codingSites.leetcode;

import java.util.HashMap;
import java.util.Map;

// problem link - https://leetcode.com/problems/two-sum/

public class TwoSum001 {
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        int totalElements  = nums.length;
        for(int index = 0; index < totalElements ; index++) {
            hm.put(nums[index], index);
        }

        // find the target
        for(int index = 0; index < totalElements; index++) {
            int complement = target-nums[index];
            if(hm.containsKey(complement) && hm.get(complement) != index) {
                return new int[] {index, hm.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String[] args) {
        int input[] = new int[] {2,7,11,15};
        int target = 9;
        System.out.println(twoSum(input, target));
    }
}
