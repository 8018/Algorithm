package me.xfly.algorithm;

import me.xfly.algorithm.listnode.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();

        while (l1 != null){
            deque1.offerLast(l1.val);
            l1 = l1.next;
        }

        while (l2 != null){
            deque2.offerLast(l2.val);
            l2 = l2.next;
        }

        ListNode ans = null;
        int carry = 0;

        while(!deque1.isEmpty()  || !deque2.isEmpty() || carry != 0){
            int x = deque1.isEmpty() ? 0 :deque1.removeLast();
            int y = deque2.isEmpty() ? 0 :deque2.removeLast();
            int temp = x + y + carry;
            carry = temp / 10;
            temp = temp%10;
            ListNode node = new ListNode(temp);
            node.next = ans;
            ans = node;
        }

        return ans;
    }

    public void test(){
        addTwoNumbers(ListNode.getListNode(),ListNode.getListNode());
    }
}
