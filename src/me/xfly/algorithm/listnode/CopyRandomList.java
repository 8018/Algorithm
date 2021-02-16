package me.xfly.algorithm.listnode;

public class CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null || (head.next == null && head.random == null)) {
            return head;
        }

        RandomListNode p = head;
        RandomListNode t = head;

        //先把所有节点复制一边，并把复制的新节点放到原来节点后面

        while (p != null){
            RandomListNode q = new RandomListNode(p.label);
            q.next = p.next;
            p.next = q;
            p = q.next;
        }

        while(t != null){
            RandomListNode q = t.next;
            if(t.random != null){
                q.random = t.random.next;
            }
            t = q.next;
        }

        RandomListNode s = new RandomListNode(0);
        RandomListNode s1 = s;

        while(head != null){
            RandomListNode q = head.next;
            head.next = q.next;
            s.next = q;
            s = s.next;
            head = head.next;
        }

        return s1.next;
    }
}
