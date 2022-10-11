package me.xfly.algorithm.tree;

import java.util.*;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public static TreeNode array2TreeNode(int[] nums) {
        List<TreeNode> list = new ArrayList();
        int length = nums.length;
        for (int i = 1; i <= length; i++) {
            if (nums[i - 1] > 0) {
                list.add(new TreeNode(nums[i - 1]));
            } else {
                list.add(null);
            }
        }
        for (int i = 1; i <= list.size() / 2 - 1 && list != null; i++) {
            TreeNode node = list.get(i - 1);
            if (node != null) {
                node.left = list.get(i * 2 - 1);
                node.right = list.get(i * 2);
            }
        }
        int lastIndex = list.size() / 2;

        TreeNode last = list.get(lastIndex - 1);

        if (last != null) {
            last.left = list.get(lastIndex * 2 - 1);
            if (list.size() % 2 == 1) {
                last.right = list.get(lastIndex * 2);
            }
        }


        return list.get(0);
    }

    /**
     * 递归先序遍历
     */
    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        result.add(root.value);
        result.addAll(preOrder(root.left));
        result.addAll(preOrder(root.right));
        return result;
    }

    /**
     * 迭代先序遍历，使用栈做辅助
     */
    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                result.add(current.value);
                current = current.left;
            } else {
                current = stack.pop();
                current = current.right;
            }
        }

        return result;
    }

    /**
     * 递归中序遍历
     */
    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        result.addAll(inOrder(root.left));
        result.add(root.value);
        result.addAll(inOrder(root.right));

        return result;
    }

    /**
     * 迭代方式实现中序遍历
     * 使用栈作为辅助工具
     * 1、先把当前节点以及当前节点的左子节点依次放入栈中
     * 2、取出栈顶节点，打印它的值，对当前节点的右子节点执行步骤1
     */
    public static List<Integer> inOrderTraversalWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        addNodeToStack(stack, root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.value);
            if (node.right != null) {
                addNodeToStack(stack, node.right);
            }
        }

        return result;
    }


    public static void addNodeToStack(Stack<TreeNode> stack, TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /**
     * 递归后序遍历
     */
    public static List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        result.addAll(postOrder(root.left));
        result.addAll(postOrder(root.right));
        result.add(root.value);
        return result;
    }

    /**
     *  迭代实现后序遍历
     *  使用栈做辅助
     *
     */
    public static List<Integer> postOrderTraversal(TreeNode root){
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        if (root == null){
            return result;
        }

        nodes.add(root);
        while (!nodes.isEmpty()){
            TreeNode node = nodes.pollLast();
            result.addFirst(node.value);

            if (node.left!=null){
                nodes.push(node.left);
            }
            if (node.right!= null){
                nodes.push(node.right);
            }
        }
        return result;
    }

    /**
     * 层序遍历
     * 记录当前层以及下一层的最后一个节点，当前节点与当前层最后一个节点相同时换层
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        TreeNode currentLast = root;
        TreeNode nextLast = root;
        TreeNode node = root;
        Queue<TreeNode> nodes = new LinkedList<>();
        List<Integer> levelResult = new ArrayList<>();
        while (node != null) {
            levelResult.add(node.value);
            if (node.left != null) {
                nextLast = node.left;
                nodes.add(node.left);
            }
            if (node.right != null) {
                nextLast = node.right;
                nodes.add(node.right);
            }

            if (node == currentLast) {
                result.add(levelResult);
                levelResult = new ArrayList<>();
                currentLast = nextLast;
            }
            node = nodes.poll();
        }

        return result;
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        TreeNode currentLast = root;
        TreeNode nextLast = root;

        List<TreeNode> nodes = new ArrayList<>();

        List<Integer> level = new ArrayList<>();

        int height = 0;

        while (root != null) {
            level.add(root.value);
            if (height % 2 == 0) {
                level.add(root.value);
            } else {
                level.add(0, root.value);
            }
            System.out.print(root.value);
            if (root.left != null) {
                nextLast = root.left;
                nodes.add(root.left);
            }
            if (root.right != null) {
                nextLast = root.right;
                nodes.add(root.right);
            }

            if (root == currentLast) {
                currentLast = nextLast;
                result.add(level);
                height += 1;
                level = new ArrayList<>();
                System.out.println();
            }

            if (!nodes.isEmpty()) {
                root = nodes.get(0);
                nodes.remove(0);
            } else {
                root = null;
            }

        }


        return result;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private static int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        if (left == -1) return -1;
        int right = depth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0) {
            return right + 1;
        }
        if (right == 0) {
            return left + 1;
        }
        return Math.min(left, right) + 1;
    }

}
