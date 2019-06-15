package lc;

class Solution {
    private int getLength(ListNode head) {
        int c = 0;
        while (head!=null) {
            head = head.next;
            c++;
        }

        return c;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0){
            return head;
        }
        int n = getLength(head);
        k = k % n;
        if (k==0) {
            return head;
        }
        ListNode ptr = head;
        for (int i = 1; i < n-k; i++) {
            ptr = ptr.next;
        }
        ListNode rotHead = ptr.next;
        ptr.next = null;
        ptr = rotHead;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = head;

        return rotHead;
    }
}

public class LC61 {
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        ListNode t = h;
        for(int i = h.val + 1; i<= 2; i++) {
            t.next = new ListNode(i);
            t = t.next;
        }

        Solution s = new Solution();
        s.rotateRight(h, 2);
    }
}
