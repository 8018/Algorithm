package me.xfly.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeNode {
	public int value;
	public TreeNode left;
	public TreeNode right;
	
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
	 * 迭代的方式实现中序遍历
	 * 1、先把所有左子节点加入栈中
	 * 2、出栈，打印当前值，当前节点的右节点执行步骤 1
	 */
	public static List<Integer> inorderTraversalWithStack(TreeNode root) {

		Stack<TreeNode> stack = new Stack<TreeNode>();

		List<Integer> result = new ArrayList<Integer>();

		addNodeToStack(stack, root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();

			result.add(node.value);

			System.out.println(node.value);

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

	public static List<Integer> inorderTraversal2(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();

		if (root == null) {
			return result;
		}

		result.addAll(inorderTraversal2(root.left));
		result.add(root.value);
		result.addAll(inorderTraversal2(root.right));

		return result;
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		TreeNode currentLast = root;
		TreeNode nextLast = root;

		List<TreeNode> nodes = new ArrayList<>();

		List<Integer> level = new ArrayList<>();

		while (root!=null){
			level.add(root.value);
			if (root.left!=null){
				nextLast = root.left;
				nodes.add(root.left);
			}
			if (root.right!=null){
				nextLast = root.right;
				nodes.add(root.right);
			}

			if (root == currentLast){
				currentLast = nextLast;
				result.add(level);
				level = new ArrayList<>();
			}

			if (!nodes.isEmpty()){
				root = nodes.get(0);
				nodes.remove(0);
			}else{
				root = null;
			}

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
		if (root == null){
			return 0;
		}

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return Math.max(left,right)+1;
	}

	public static boolean isBalanced(TreeNode root) {
		return depth(root) != -1;
	}

	private static int depth(TreeNode root) {
		if (root == null) return 0;
		int left = depth(root.left);
		if(left == -1) return -1;
		int right = depth(root.right);
		if(right == -1) return -1;
		return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
	}

	public static int minDepth(TreeNode root) {
		if (root == null){
			return 0;
		}

		int left = minDepth(root.left);
		int right = minDepth(root.right);
		if (left==0){
			return right+1;
		}
		if (right==0){
			return left+1;
		}
		return Math.min(left,right)+1;
	}

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();

		if (root == null) {
			return result;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode current = root;

		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				System.out.println(current.value);
				result.add(current.value);
				stack.push(current);

				current = current.left;
			} else {
				current = stack.pop();
				current = current.right;
			}
		}

		return result;
	}

	public static List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<>();
		LinkedList<Integer> output = new LinkedList<>();
		if (root == null) {
			return output;
		}

		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pollLast();
			output.addFirst(node.value);
			System.out.println(node.value);
			if (node.left != null) {
				stack.add(node.left);
			}
			if (node.right != null) {
				stack.add(node.right);
			}
		}
		return output;
	}


}
