package me.xfly.algorithm.listnode;

import java.util.Random;

public class CloneRandomList {
    public RandomListNode Clone(RandomListNode pHead) {
        RandomListNode p = pHead;
        RandomListNode t = pHead;
        while (p != null) {
            RandomListNode q = new RandomListNode(p.label);
            q.next = p.next;
            p.next = q;
            p = q.next;
        }
        while (t != null) {
            RandomListNode q = t.next;
            if (t.random != null)
                q.random = t.random.next;
            t = q.next;

        }
        RandomListNode s = new RandomListNode(0);
        RandomListNode s1 = s;
        while (pHead != null) {
            RandomListNode q = pHead.next;
            pHead.next = q.next;
            s.next = q;
            s = s.next;
            pHead = pHead.next;


        }
        return s1.next;
    }

    public RandomListNode clone(RandomListNode head) {
        RandomListNode p = head;
        RandomListNode t = head;

        while (p != null) {
            RandomListNode q = new RandomListNode(p.label);
            q.next = p.next;
            p.next = q;
            p = q.next;
        }

        while (t != null) {
            RandomListNode q = t.next;
            if (t.random!=null){
                q.random = t.random.next;
            }
            t = q.next;
        }

        RandomListNode newHead = new RandomListNode(-1);
        RandomListNode temp = newHead;

        while (head != null) {
            RandomListNode q = head.next;
            head.next = q.next;
            temp.next = q;
            temp = temp.next;
            head = head.next;
        }

        return newHead.next;
    }
}
