package me.xfly.algorithm.listnode;

public class ReverseListNode {
    public static void main(String[] args) {
        ListNode nod1 = new ListNode(1);
        ListNode nod2 = new ListNode(2);
        ListNode nod3 = new ListNode(3);
        ListNode nod4 = new ListNode(4);
        ListNode nod5 = new ListNode(5);
        ListNode nod6 = new ListNode(6);
        ListNode nod7 = new ListNode(7);
        ListNode nod8 = new ListNode(8);
        ListNode nod9 = new ListNode(9);

        nod1.next = nod2;
        nod2.next = nod3;

        nod3.next = nod4;
        nod4.next = nod5;

        nod5.next = nod6;
        nod6.next = nod7;
        nod7.next = nod8;
        nod8.next = nod9;

        reverseList(nod1);
    }

    /**
     * 三个节点做辅助
     * 一个指向前面已经反转过的节点（返回值）
     * 一个指向当前节点
     * 一个指向下一个节点
     */
    static ListNode reverseListNode(ListNode node){
        if (node == null||node.next == null){
            return node;
        }
        ListNode result = null,curr = node,next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = result;
            result = curr;
            curr = next;
        }
        return result;
    }

    public static ListNode reverseList(ListNode head){
        if(head == null|| head.next == null){
            return head;
        }
        //1、递归 一条道走到黑，最后 newHead 指向旧链表尾部
        //最后返回的也是 newHead
        //注意 参数是 head.next 也就是说这段代码执行之后会有两个链表，一个旧的 一个新的
        ListNode newHead = reverseList(head.next);
        //2、非常巧妙 next.next 也就是新链表的尾巴指向自己
        head.next.next = head;
        //3、自己的尾巴断开
        head.next = null;
        //2，3 两行代码完成一个节点的反转
        return newHead;
    }
}
