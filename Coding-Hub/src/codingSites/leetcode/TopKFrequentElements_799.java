package codingSites.leetcode;

import java.util.*;
// problem link - https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/799/
public class TopKFrequentElements_799 {
    class FrequentElement {
        int val;
        int frequency;

        FrequentElement(int val, int frequency) {
            this.val = val;
            this.frequency = frequency;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        if (nums.length == 1)
            return nums;

        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        PriorityQueue<FrequentElement> pq = new PriorityQueue<FrequentElement>((n1, n2) -> n2.frequency - n1.frequency);

        int totalElement = nums.length;
        // hashMap created
        for (int index = 0; index < totalElement; index++) {
            if (hm.containsKey(nums[index])) {
                int element = hm.get(nums[index]) + 1;
                hm.put(nums[index], element);
            } else {
                hm.put(nums[index], 1);
            }
        }

        for (Map.Entry<Integer, Integer> data : hm.entrySet()) {
            int number = data.getKey();
            int frequency = data.getValue();
            pq.add(new FrequentElement(number, frequency));
        }

        int result[] = new int[k];

        for (int index = 0; index < k; index++) {
            FrequentElement node = pq.poll();
            result[index] = node.val;
        }
        return result;
    }
}
