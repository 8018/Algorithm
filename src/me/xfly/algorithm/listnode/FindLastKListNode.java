package me.xfly.algorithm.listnode;

public class FindLastKListNode {
    public static void main(String[] args) {

    }

    /**
     * 注意，添加哨兵节点这个做法非常巧妙
     * 如果不添加哨兵节点，快指针前进几步，是不是倒数第 K 可能就会产生混乱
     */
    static ListNode findLastKthNode(ListNode node,int k){
        if(node == null || k <=0 ){
            return null;
        }

        ListNode fast = new ListNode(-1);
        fast.next = node;
        ListNode slow = fast;

        for (int i = 0;i<k;i++){
            fast = fast.next;
            if (fast == null){
                return null;
            }
        }

        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    /**
     * 删除倒数第 K 个节点
     * 注意删除和查找倒数第 K 个节点的不同
     * 删除是要找到倒数第 K 个节点的前一个节点，然后前节点要断开和后节点之间的关系
     */
    public static ListNode removeKthFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < k; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
