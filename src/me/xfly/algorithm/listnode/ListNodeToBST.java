package me.xfly.algorithm.listnode;

import me.xfly.algorithm.tree.TreeNode;

public class ListNodeToBST {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        new ListNodeToBST().sortedListToBST(node1);
    }


    public TreeNode sortedListToBST(ListNode head) {
        //int length = getLength(head);
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) return null;

        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);

        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;

    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;

        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    ListNode globalHead;
    public TreeNode sortedListToBST2(ListNode head) {
        globalHead = head;
        int length = getLength(head);
        return buildTree(0,length-1);
    }

    public int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ++ret;
            head = head.next;
        }
        return ret;
    }

    public TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.value = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }
}
