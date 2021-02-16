package me.xfly.algorithm.listnode;


import java.util.List;

public class ReverseKthGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode reversed = null;
        ListNode pre = head;
        ListNode next = head.next;

        ListNode subHead = head;
        ListNode subTail = null;

        while (next != null) {
            //注意 下标从1开始
            for (int i = 1;i<k;i++){
                pre = pre.next;
                if (pre == null){
                    break;
                }
                next = next.next;
            }

            if (pre != null){
                pre.next = null;
                ListNode temp = reverse(subHead);
                if (reversed == null) {
                    reversed = temp;
                }else{
                    subTail.next = temp;
                }

                subTail = subHead;
                subHead = next;
                pre = next;
                if (next!=null){
                    next = next.next;
                }
            }
        }

        if (subTail != null){
            subTail.next = subHead;
        }else{
            reversed = subHead;
        }

        return reversed;
    }

    public ListNode reverse(ListNode node) {
        ListNode reversed = null;
        ListNode pre = node;
        ListNode next = node.next;

        while (next != null) {
            pre.next = reversed;
            reversed = pre;
            pre = next;
            next = next.next;
        }
        pre.next = reversed;
        reversed = pre;
        return reversed;
    }
}