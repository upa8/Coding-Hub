package codingSites.leetcode;

public class JumpGame807_DP_Medium {
    // Problem Link - https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/807/
    // Video - https://youtu.be/Zb4eRjuPHbM
    public static boolean canJump(int[] nums) {
        int lastGoodIndexPosition = nums.length -1;
        
        for(int index = nums.length -1 ; index >= 0; index--){
            if(index + nums[index] >= lastGoodIndexPosition) {
                lastGoodIndexPosition = index;
            }
        }
        return lastGoodIndexPosition == 0;
    }
    public static boolean canJumpI(int[] nums) {
        int rows = nums.length - 1;
        
        if(rows == 0) {
            return false;
        }

        if(rows == 1) {
            return true;
        }
        
        // max in the nums
        int max = 0;
        for(int index = 0; index< rows; index++){
            if(nums[index] >= max){
                max = nums[index];
            }
        }
        
        System.out.println("MAX "+ max);
        int colms = max+1;
        
        int dp[][] = new int[rows][colms];
        
        // fill base condition for colmns
        dp[0][0] = 0;
        int maxSteps = nums[0]; // for rows
        for(int index=1; index< colms; index++) {
            if(index <= maxSteps) {
                dp[0][index] = dp[0][index-1]+1;
            } else {
                dp[0][index] = dp[0][index-1];
            }    
        }
        
        // fill base condition for rows
        for(int index=1; index< rows; index++) {
            dp[index][0] = index;            
        }

        printArray(dp);
        System.out.println(" ________");
        
        // fil the dp
        for(int indexR = 1; indexR < rows; indexR++){
            int currentMaxSteps = nums[indexR];
            //System.out.println("Current Max Steps - " + currentMaxSteps);
            for(int indexC = 1; indexC < colms; indexC++){
                //System.out.println("Current Values " + indexC);
                if(currentMaxSteps >= indexC) {
                    dp[indexR][indexC] = dp[indexR][indexC-1] + 1;
                } else {
                    dp[indexR][indexC] = dp[indexR][indexC];
                }
                
                // reached to last pointer
                if(dp[indexR][indexC] == rows) {
                    System.out.println(dp[indexR][indexC]);
                    return true;
                }
            }
        }
        printArray(dp);
        System.out.println(" ________");
        //System.out.println("Reached here");
        return false;
    }

    public static void main (String[] args){
         int nums[] = new int[] {3,2,1,0,4};
        // System.out.println(canJump(nums));

        //int nums[] = new int[] {1,2};
        System.out.println(canJump(nums));
    }

    public static void printArray(int[][] input){
        int rows = input.length;
        int colms = input[0].length;
        for(int indexR = 0; indexR < rows; indexR++) {
            for(int indexC = 0; indexC < colms; indexC++){
                System.out.print(input[indexR][indexC]+ " ");
            }
            System.out.println("");
        }
    }

}
