package me.xfly.algorithm.listnode;

public class FindFirstCommonNode {
    /**
     * 不用 hash 也不用记录长度，走到头接上另一个链表重新走一遍
     * 两个链表接上肯定一样长，这样他们会同时到达相同节点
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null|| pHead1 ==null){
            return null;
        }

        ListNode p1 = pHead1,p2 = pHead2;

        while (p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2) {
                if (p1 == null) {
                    p1 = pHead2;
                }

                if (p2 == null) {
                    p2 = pHead1;
                }
            }
        }

        return p1;
    }
}