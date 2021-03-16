package codingSites.leetcode;

// https://leetcode.com/problems/unique-paths/
public class uniquePath62_dp_medium {
    public int uniquePaths(int m, int n) {
        
        if(m == 1 || n == 1) {
            return 1;
        }
        
        int dp[][] = new int[m][n];
        // base conditions - rows
        for(int index = 0; index < m; index++){
            dp[index][0] = 1;
        }
        // base conditions - columns
        for(int index = 0; index < n; index++){
            dp[0][index] = 1;
        }
        
        // fill the dp
        for(int rows = 1; rows < m; rows++) {
            for(int colms = 1; colms < n; colms++) {
                dp[rows][colms] = dp[rows-1][colms] + dp[rows][colms-1];
            }
        }
        
        return dp[m-1][n-1];
    }
}
