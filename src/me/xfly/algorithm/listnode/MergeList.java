package me.xfly.algorithm.listnode;

public class MergeList {
    ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode curr = result;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                curr.next = list2;
                list2 = list2.next;
                curr = curr.next;
            } else {
                curr.next = list1;
                list1 = list1.next;
                curr = curr.next;
            }
        }

        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }

        return result.next;
    }

    ListNode merge(ListNode list1,ListNode list2){
        if (list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        if(list1.val > list2.val){
            list2.next = merge(list1,list2.next);
            return list2;
        }else{
            list1.next = merge(list1.next,list2);
            return list1;
        }
    }
}
