package lc;

import utils.Display;


public class LC31 {
    public static void main(String[] args) {
        /*
        3,2,1
        4,7,3,2
         */
        LC31 s = new LC31();
        int[] nums = { 1,5,1 };
        s.nextPermutation(nums);
        Display.print1dArray(nums);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int i = nums.length - 2;

        // find the first decreasing element
        while (i >= 0 && nums[i] > nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        i++;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}