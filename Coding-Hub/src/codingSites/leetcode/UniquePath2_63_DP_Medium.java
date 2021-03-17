package codingSites.leetcode;

// https://leetcode.com/problems/unique-paths-ii/
public class UniquePath2_63_DP_Medium {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int colms = obstacleGrid[0].length;
        
        if(obstacleGrid[rows-1][colms-1] == 1 || obstacleGrid[0][0] == 1 ) {
            return 0;
        }
        // handle edge condition
        if(rows == 0 || colms == 0) {
            return 0;
        }
        
        if((rows == 1 || colms == 1) && obstacleGrid[0][0] == 1) {
            return 0;
        }
        
        if((rows == 1 || colms == 1) && obstacleGrid[0][0] == 0) {
            return 1;
        }
        
        int dp[][] = new int[rows][colms];
        // fill base conditions for colms
        dp[0][0] = 1;
        for(int index = 1; index < colms; index++) {
            if(obstacleGrid[0][index] == 0){
                dp[0][index] = dp[0][index-1];
            } else {
                dp[0][index] = 0;
            }
        }
        // fill base conditions for rows
        for(int index = 1; index < rows; index++) {
            if(obstacleGrid[index][0] == 0){
                dp[index][0] = dp[index-1][0];
            } else {
                dp[index][0] = 0;
            }
        }
        // fill the dp
        for(int indexR = 1; indexR < rows; indexR++){
            for ( int indexC = 1; indexC < colms; indexC++) {
                int topElementPathCount = dp[indexR - 1][indexC];
                int leftElementPathCount = dp[indexR][indexC -1];
                if(obstacleGrid[indexR][indexC] == 1) {
                    dp[indexR][indexC] = 0;
                } else {
                    dp[indexR][indexC] = topElementPathCount + leftElementPathCount;
                }
            }
        }
        
        return dp[rows-1][colms-1];
    }
}
