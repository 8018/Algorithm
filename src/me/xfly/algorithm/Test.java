package me.xfly.algorithm;

import me.xfly.algorithm.listnode.ListNode;
import me.xfly.algorithm.tree.TreeNode;

import java.util.*;

public class Test {

    public static void main(String args[]) {

        /*String s1 = "古时的风筝";
        String s4 = "古时的风筝";
        String a = "古时的";
        String s2 = new String(a + "风筝");
        String s3 = new String(a + "风筝");
        System.out.println(s1 == s2); // false
        System.out.println(s2 == s3);  // false
        System.out.println(s1 == s4);  // true*/

        /*ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);

        ListNode node1 = new ListNode(4);
        node1.next = new ListNode(5);
        node.next.next.next = node1;

        removeNthFromEnd(node,1);*/


        /*int[] nums = {1,2,3};
        new Test().subsets(nums);*/

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);

    }


    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);


    }

    /*List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList();
        if(nums == null || nums.length == 0){
            return ans;
        }
        ans.add(new ArrayList());
        subSetHelper(nums,nums.length-1);
        return ans;
    }

    public void subSetHelper(int[] nums,int index) {
        if(index < 0){
            return;
        }
        int n = nums[index];
        subSetHelper(nums,index-1);

        int size = ans.size();
        for(int i = 0;i< size;i++){
            List<Integer> temp = new ArrayList(ans.get(i));
            temp.add(n);
            ans.add(temp);
        }
    }*/

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
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


    public static void  getRandom(ListNode head) {
        Random rd = new Random();

        int ans = 0;
        int cnt = 0;
        ListNode p = head;
        while(p != null){
            int val = rd.nextInt(++cnt);
            if(val == 0){
                ans = p.val;
            }
            p = p.next;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public int romanToInt(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        int pre = getValue(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            int curr = getValue(chars[i]);
            if (pre < curr) {
                sum -= pre;
            } else {
                sum += pre;
            }
            pre = curr;
        }
        sum += pre;

        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public boolean isValid(String str) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        char[] characters = str.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        for (char c : characters) {
            if (map.containsKey(c)) {
                char top = stack.isEmpty() ? '#' : stack.pop();
                if (top != c) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    int index = 0;
    int k;

    TreeNode findKthTreeNode(TreeNode root, int K) {
        if (root == null || k <= 0) {
            return null;
        }
        this.k = k;
        return findKthTreeNode(root);
    }

    TreeNode findKthTreeNode(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode result = null;

        result = findKthTreeNode(root.left);
        index++;
        if (index == k) {
            result = root;
            return result;
        }
        result = findKthTreeNode(root.right);
        return result;
    }


    void pong() throws InterruptedException {
        notify();
    }

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i : nums) {
            sum += i;
            if (sum > result) {
                result = sum;
            }

            if (sum < 0) sum = 0;
        }
        return result;
    }

    static int times = 0;

    static int fib(int N) {
        if (N < 1) return 0;
        // 备忘录全初始化为 0
        int[] memo = new int[N + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = 0;
        }
        // 初始化最简情况
        memo[1] = memo[2] = 1;
        return helper(memo, N);
    }

    static int helper(int[] memo, int n) {
        System.out.println(times + "   " + n);
        // 未被计算过
        if (n > 0 && memo[n] == 0)
            memo[n] = helper(memo, n - 1) +
                    helper(memo, n - 2);
        times += 1;
        return memo[n];
    }
}
