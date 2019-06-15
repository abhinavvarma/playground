package lc;

class ListNode {
 
    int val;
 
    ListNode next;
 

    ListNode(int x) {
        val = x;
    }

    public String toString() {
        return String.valueOf(val);
    }
}

public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode adv = head;
        for (int i = 0; i < n; i++) {
            adv = adv.next;
        }
        ListNode cur = head;
        while (adv.next!=null)
        {
            cur = cur.next;
            adv = adv.next;
        }
        cur.next = cur.next.next;
        return head;
    }
}
