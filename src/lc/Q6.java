package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


//https://leetcode.com/problems/3sum/
public class Q6 {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<String, List<Integer>> res = new HashMap<>();
        Arrays.sort(nums);
        int l, r;
        for (int i = 0; i < nums.length - 2; i++) {
                l = i + 1;
                r = nums.length-1;
                while (l<r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == 0) {
                        res.put(String.format("%s%s%s", nums[i], nums[l], nums[r]), Arrays.stream(new int[]{nums[i], nums[l], nums[r]})
                                .boxed().collect
                                (Collectors
                                .toList
                                ()));
                        l++;
                        r--;
                    }
                     else if (sum>0)
                        r--;
                    else
                        l++;

                }
        }
        return new ArrayList<>(res.values());
    }

    public static void main(String[] args) {
        Q6 q = new Q6();
        q.threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}
