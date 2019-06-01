package lc;

import java.util.Arrays;


//https://leetcode.com/problems/3sum/
public class Q7 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int l, r;
        int currentDiff = Integer.MAX_VALUE;
        int closestSum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
                l = i + 1;
                r = nums.length-1;
                while (l<r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == 0) {
                        return 0;
                    }
                     else if (sum-target>0)
                        r--;
                    else
                        l++;
                    if (Math.abs(target - sum) < currentDiff){
                        currentDiff = Math.abs(target - sum);
                    }

                }
        }
        return target - currentDiff;
    }

    public static void main(String[] args) {
        Q7 q = new Q7();
        System.out.println(q.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
