package me.xfly.algorithm.listnode;


import org.junit.Test;

import java.util.*;

public class ReverseKthGroupII {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reversed = new ListNode(-1);
        ListNode reversedTail = reversed;

        ListNode firstHead = head;

        while (head != null) {
            ListNode firstTail = cutIntoTwoHalf(head, k);
            if (firstTail == null) {
                break;
            }

            ListNode secondHead = firstTail.next;
            firstTail.next = null;
            reverse(firstHead);

            reversedTail.next = firstTail;
            reversedTail = firstHead;
            head = secondHead;
            firstHead = head;
        }

        reversedTail.next = firstHead;

        return reversed.next;
    }

    public ListNode cutIntoTwoHalf(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode firstTail = dummy;
        for (int i = 1; i <= k; i++) {
            firstTail = firstTail.next;
            if (firstTail == null) {
                dummy.next = null;
                return null;
            }
        }
        dummy.next = null;
        return firstTail;
    }

    public void reverse(ListNode node) {
        ListNode reversed = null;
        ListNode head = node;

        while (head != null) {
            ListNode temp = head.next;
            head.next = reversed;
            reversed = head;
            head = temp;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0; i <= n; ++i) {
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

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> memo = new HashMap();

        for(String str:strs){
            String key = getSortedStr(str);
            List<String> list = memo.getOrDefault(key,new ArrayList<>());
            list.add(str);
            memo.put(key,list);
        }

        return new ArrayList<List<String>>(memo.values());
    }

    public String getSortedStr(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    @Test
    public void test(){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }
}