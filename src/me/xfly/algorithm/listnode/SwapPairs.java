package me.xfly.algorithm.listnode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode temp = newHead;

        while (temp.next!= null && temp.next.next!=null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;

            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return newHead.next;
    }
}