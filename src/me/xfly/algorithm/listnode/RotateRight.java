package me.xfly.algorithm.listnode;

public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode oldTail = head;

        int n;
        for (n = 1; oldTail.next != null; n++) {
            oldTail = oldTail.next;
        }
        oldTail.next = head;

        ListNode newTail = head;

        for (int i = 0; i < n - k % n - 1; i++){
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;

        newTail.next = null;
        return newHead;
    }
}
