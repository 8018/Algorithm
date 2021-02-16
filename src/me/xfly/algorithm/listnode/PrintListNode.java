package me.xfly.algorithm.listnode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintListNode {
    public static void main(String[] args) {

    }

    /**
     * 借助栈，把链表「反转」过来
     */
    static List<Integer> printWithStack(ListNode node) {
        Stack<ListNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        List<Integer> result = new ArrayList<>();

        while (!stack.isEmpty()) {
            ListNode node1 = stack.pop();
            result.add(node1.val);
        }
        return result;
    }

    /**
     * 递归，本质上还是借助栈结构
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        ListNode pNode = listNode;

        if (pNode != null) {
            if (pNode.next != null) {
                list = printListFromTailToHead(pNode.next);
            }
            list.add(pNode.val);
        }

        return list;
    }
}