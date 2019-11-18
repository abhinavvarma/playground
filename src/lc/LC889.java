package lc;

import utils.arrays.Boxing;

import java.util.Arrays;
import java.util.List;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
class LC889 {
    private boolean isInRange(int s, int v, int e) {
        return s <= v && v <= e;
    }
    
    private boolean isInRange(int s, int v1, int v2, int e) {
        return isInRange(s, v1, e) && isInRange(s, v2, e);
    }

    private TreeNode construct(List<Integer> pre, List<Integer> post, int preS, int preE, int postS, int postE) {
        if (preE-preS < 0)
            return null;
        TreeNode head = new TreeNode(pre.get(preS));
        int leftPreS = preS + 1;
        if (leftPreS<=preE) {
            int leftPostS = postS;
            int leftPostE = post.indexOf(pre.get(leftPreS));
            int leftCount = leftPostE - leftPostS + 1;
            int leftPreE = leftPreS + leftCount - 1;
            int rightPreS = leftPreE + 1;
            int rightPostE = postE - 1;
            int rightPostS = leftPostE + 1;
            int rightPreE = preE;
            if (isInRange(preS, leftPreS, leftPreE, preE) && isInRange(postS, leftPostS, leftPostE, postE))
                head.left = construct(pre, post, leftPreS, leftPreE, leftPostS, leftPostE);
            if (isInRange(preS, rightPreS, rightPreE, preE) && isInRange(postS, rightPostS, rightPostE, postE))
                head.right = construct(pre, post, rightPreS, rightPreE, rightPostS, rightPostE);
        }
        return head;
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return construct(Arrays.asList(Boxing.toInteger1DArray(pre)), Arrays.asList(Boxing.toInteger1DArray(post)), 0, pre.length-1, 0, post.length - 1);
    }

    public static void main(String[] args) {
        LC889 l = new LC889();
        l.constructFromPrePost(
                new int[]{1,2,4,5,3,6,7},
                new int[]{4,5,2,6,7,3,1}
                );
    }
}