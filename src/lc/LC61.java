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
        if (head == null || head.next == null){
            return head;
        }
        ListNode ptr = head;
        k = getLength(head)%k;
        for (int i = 0; i< k; i++) {
            ptr = ptr.next;
        }
        while (ptr!= null){
            ListNode nextNode = ptr.next;
            ptr.next = head;
            head = ptr;
            ptr = nextNode;
        }

        return head;
    }
}

public class LC61 {
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        ListNode t = h;
        for(int i = h.val + 1; i<= 5; i++) {
            t.next = new ListNode(i);
            t = t.next;
        }

        Solution s = new Solution();
        s.rotateRight(h, 1);
    }
}
