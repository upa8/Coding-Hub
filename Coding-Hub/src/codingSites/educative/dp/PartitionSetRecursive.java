package codingSites.educative.dp;

/*
    Given a set of positive numbers, find if we can partition it into two subsets such that the sum of elements in both the subsets is equal.

    Example 1: #
    Input: {1, 2, 3, 4}
    Output: True
    Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}
    Example 2: #
    Input: {1, 1, 3, 4, 7}
    Output: True
    Explanation: The given set can be partitioned into two subsets with equal sum: {1, 3, 4} & {1, 7}
    Example 3: #
    Input: {2, 3, 4, 6}
    Output: False
    Explanation: The given set cannot be partitioned into two subsets with equal sum.
*/

public class PartitionSetRecursive {
    /*
     * Algorightm -  
     * for each number 'i' create a new set which INCLUDES number 'i' if
     * it does not exceed 'S/2', and recursively process the remaining numbers
     * create a new set WITHOUT number 'i', and recursively process the remaining
     * items return true if any of the above sets has a sum equal to 'S/2',
     * otherwise return false
     * 
     * Complexity Analysis - The time complexity of the above algorithm is exponential
     * O(2^n)O(2 ​n ​​ ), where ‘n’ represents the total number. The space
     * complexity is O(n)O(n), this memory which will be used to store the recursion
     * stack
     */

    // Recursive Solution
    static boolean canPartition(int[] num) {

        int sum = 0;
        int totalElements = num.length;
        for (int index = 0; index < totalElements; index++) {
            sum += num[index];
        }
        if (sum % 2 != 0) {
            return false;
        }

        return canPartitionRecursive(num, sum, 0);
    }

    // Recursive Solution
    static boolean canPartitionRecursive(int[] num, int sum, int currentIndex) {
        // base check
        if (sum == 0) {
            return true;
        }

        if (num.length == 0 || currentIndex >= num.length) {
            return false;
        }

        if (num[currentIndex] <= sum) {
            if (canPartitionRecursive(num, sum - num[currentIndex], currentIndex + 1)) {
                return true;
            }
        }
        return canPartitionRecursive(num, sum, currentIndex + 1);
    }

    public static void main(String[] args) {
        PartitionSetRecursive ps = new PartitionSetRecursive();
        int[] num = { 1, 2, 3, 4 };
        System.out.println(ps.canPartition(num));
        num = new int[] { 1, 1, 3, 4, 7 };
        System.out.println(ps.canPartition(num));
        num = new int[] { 2, 3, 4, 6 };
        System.out.println(ps.canPartition(num));
    }
}