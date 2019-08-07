package lc;

import java.sql.SQLOutput;


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


public class LC45 {
    static int minJumps(int a[], int cur) {
        int cnt = 0;


        int maxJi = cur;
        if (maxJi >= a.length-1)
            return cnt;
        for (int i=cur;i <= cur+a[cur]; i++) {
            if(a[i]>=a[maxJi])
                maxJi = i;
        }
        cur = maxJi;
        cnt++;
        return -1;
    }

    public static void main(String[] args) {
        int a[] = new int[]{2, 1};
        MinJumps m = new MinJumps(a);
        System.out.println(m.jump());

    }
}
