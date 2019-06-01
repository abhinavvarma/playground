package lc;

public class LC26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length==0)
            return 0;
        int w = 0;
        for (int i = 0; i<nums.length; i++) {
            if (nums[w] != nums[i])
                nums[++w] = nums[i];
        }
        return w + 1;
    }
}
