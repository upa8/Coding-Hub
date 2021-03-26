package codingSites.leetcode;

public class MaxiumumSubarray {
    // INCORRECT
    public int maxSubArrayDP(int[] nums) {
        int totalElements = nums.length;
        // base conditions
        if (totalElements == 1)
            return nums[0];

        int[][] dp = new int[totalElements][totalElements];

        dp[0][0] = nums[0];
        int maxSum = nums[0];

        for (int indexR = 0; indexR < totalElements; indexR++) {
            for (int indexC = indexR + 1; indexC < totalElements; indexC++) {

                if (nums[indexC] >= maxSum) {
                    maxSum = nums[indexC];
                }

                dp[indexR][indexC] = dp[indexR][indexC - 1] + nums[indexC];

                if (dp[indexR][indexC] >= maxSum) {
                    maxSum = dp[indexR][indexC];
                }

                System.out.print(dp[indexR][indexC] + " ");
            }
            System.out.println();
        }

        return maxSum;
    }

    public int maxSubArray(int[] nums) {
        int size = nums.length;
        if (size == 1)
            return nums[0];
        int result = nums[0];

        int[] sum = new int[nums.length];
        sum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum[i] = Math.max(nums[i], sum[i - 1] + nums[i]);
            result = Math.max(result, sum[i]);
        }

        return result;
    }
}
