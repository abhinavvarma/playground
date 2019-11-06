package lc;

import utils.Display;


public class LC34 {
    private int searchExtreme(int[] nums, int target, int l, int h, boolean left) {
        int i = -1, m;
        while (l<h) {
            m = l+(h-l)/2;
            if (nums[m] == target) {
                i=m;
                if (left) {
                    h = m-1;
                } else {
                    l = m+1;
                }
            } else if (nums[m]<target) {
                l = m+1;
            } else if (nums[m]>target) {
                h = m-1;
            }
        }
        return i;
    }

    public int[] searchRange(int[] nums, int target) {
        int l = 0, h = nums.length - 1, m;
        return new int[] {
                searchExtreme(nums, target, l, h, true),
                searchExtreme(nums, target, l, h, false)
        };
    }

    public static void main(String[] args) {
        LC34 s = new LC34();
        Display.print(s.searchRange(new int[]{5,7,7,8,8,810}, 8));
    }
}
