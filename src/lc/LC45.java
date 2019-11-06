package lc;

import java.sql.SQLOutput;
import java.util.Arrays;


class MinJumps {
    int[] nums;

    public MinJumps(int[] nums) {
        this.nums = nums;
    }

    private int getMaxReachable(int i) {
        if (i>=nums.length)
            return -1;
        return nums[i] + i;
    }

    private boolean isReachable(int i) {
        return (getMaxReachable(i) >= nums.length-1);
    }

    public int jump() {
        if (nums.length<2) {
            return 0;
        }
        int[] mins = new int[nums.length];
        mins[nums.length-1] = 0;
        for (int i=nums.length-2; i>=0; i--) {
            int min = mins[i+1];
            for (int j = i+2;j<=getMaxReachable(i)&&j<nums.length;j++) {
                if (mins[j]<min) {
                    min = mins[j];
                }
            }
            mins[i] = min + 1;
        }
        return mins[0];
    }
}

class MinJumps2 {
    public int jump(int[] nums) {
        // memo[i] : steps from i to n-1, init with INT_MAX
        int[] memo = new int[nums.length];
        Arrays.fill(memo, Integer.MAX_VALUE);
        return dfs(nums, 0, memo);
    }
    // next step is jump: from index to n-1;
    public int dfs(int[] nums, int index, int[] memo){
        // get from memo[]
        if (memo[index] != Integer.MAX_VALUE) return memo[index];
        // stop condition n-1;
        if (index == nums.length-1) {
            memo[index] = 0;
            return 0;
        }
        // pruning: if this step's field < last step's, then meaningless, skip it; Just for 92th test case, or will TLE
        if (index > 0 && nums[index] < nums[index-1]) return memo[index];
        // greedy variable jump ways to next valid step, get min from n-1;
        for (int i = 1; i <= nums[index] && index+i < nums.length; i++){
            if (dfs (nums, index+i, memo) != Integer.MAX_VALUE &&
                    dfs (nums, index+i, memo)+1 < memo[index])
                memo[index] = dfs(nums, index+i, memo) + 1;
        }
        // return mini step or ust INT_MAX;
        return memo[index];
    }
}


public class LC45 {

    public static void main(String[] args) {
        int a[] = new int[]{2,3,1,1,4};
        MinJumps2 m = new MinJumps2();
        System.out.println(m.jump(a));

    }
}
