package codingSites.leetcode;

// problem Link - https://leetcode.com/problems/minimum-path-sum/

public class minimumPathSum64_dp_medium {

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int colms = grid[0].length;
        
        int dp[][] = new int[rows][colms];
        dp[0][0] = grid[0][0];
                             
        // fill base case - colms
        for(int index = 1; index < colms; index++) {
            dp[0][index] = dp[0][index-1] + grid[0][index];
        }
                             
        // fill base case - rows                     
        for(int index = 1; index < rows; index++) {
            dp[index][0] = dp[index-1][0] + grid[index][0];
        }                             
        
        // fill DP
        for(int indexR =1; indexR < rows ; indexR++) {
            for(int indexC = 1; indexC < colms; indexC++) {
                dp[indexR][indexC] = Math.min(
                    dp[indexR-1][indexC] + grid[indexR][indexC],
                    dp[indexR][indexC-1] + grid[indexR][indexC]
                );
            }
        }
                             
        return dp[rows-1][colms-1];
    }
    public static void main(String[] args){
        System.out.println("DP Problem");
    }
}