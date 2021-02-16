package me.xfly.algorithm.listnode;

public class PalindromeListCheck {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode firstEnd = endOfFirstHalf(head);
        ListNode secondHalf = reverseList(firstEnd.next);

        ListNode p1 = head;
        ListNode p2 = secondHalf;

        boolean result = true;

        while (result && p2 != null) {
            if (p1.val != p2.val){
                result = false;
            }
            p1= p1.next;
            p2 = p2.next;
        }
        firstEnd.next = reverseList(secondHalf);
        return result;
    }

    public ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null, curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}
