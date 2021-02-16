package me.xfly.algorithm.listnode;

public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        ListNode flag = dummy;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (flag.next.val != curr.next.val){
                flag = flag.next;
                curr = curr.next;
            }else{
                while (curr != null && curr.next!= null && flag.next.val == curr.next.val){
                    curr = curr.next;
                }
                flag.next = curr.next;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}