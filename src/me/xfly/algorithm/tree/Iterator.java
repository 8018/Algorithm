package me.xfly.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Iterator {
	public static void main(String[] args) {
		//TreeNode tree = TreeNode.generateTree();

		TreeNode tree;

		/**
		 * 前、中、后 遍历的时候没个节点最多被访问两次 所以时间复杂度是 O（n）
		 */
		/*
		 * preOrder(tree); System.out.println("=============================");
		 * inOrder(tree); System.out.println("=============================");
		 * postOrder(tree);
		 */

		// printByLevel(tree);

		/*
		 * inOrder(tree); System.out.println(""); inOrderByStack(tree);
		 */

		/*
		 * preOrder(tree); System.out.println(""); preOrderByStack(tree);
		 * System.out.println(""); preOrderByStack2(tree);
		 */

		/*postOrder(tree);
		System.out.println("");
		postOrderByStack(tree);
		System.out.println("");*/

	}

	static void preOrder(TreeNode tree) {
		if (tree == null) {
			return;
		}
		System.out.print(tree.value + " ");
		preOrder(tree.left);
		preOrder(tree.right);
	}

	/*
	 * 非递归先序遍历 1 1、申请一个栈 2、打印当前节点 循环 如果当前节点的左节点不为 null 打印它的值并加它放入栈中 3、取出栈顶节点 执行 2
	 */
	public static void preOrderByStack(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = treeNode;

		while (stack.size() != 0 || current != null) {

			while (current != null) {
				System.out.print(current.value + " ");
				stack.push(current);
				current = current.left;
			}

			TreeNode node = stack.pop();
			current = node.right;
		}
	}

	/*
	 * 非递归先序遍历 2 1、申请一个栈，将根结点添加进去 2、从栈中取出一个节点，打印这个节点的值 3、如果这个节点的右节点不为 null
	 * ，将右节点添加到栈中 4、如果这个节点的左节点不为 null ，将左节点添加到栈中 2、3、4 循环
	 * 
	 * 后进先出，先打印当前节点，然后右节点先被放进去、后打印，左节点后被放进去 先打印
	 * 
	 */
	public static void preOrderByStack2(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(treeNode);

		while (stack.size() != 0) {

			TreeNode current = stack.pop();
			System.out.print(current.value + " ");
			if (current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) {
				stack.push(current.left);
			}
		}
	}

	static void inOrder(TreeNode tree) {
		if (tree == null) {
			return;
		}
		inOrder(tree.left);
		System.out.print(tree.value + " ");
		inOrder(tree.right);
	}

	/*
	 * 1、申请一个栈 2、将当前节点放入栈中 如果左节点不为 null 将左节点标为当前节点 循环 3、取出栈顶节点 打印它的值 如果它的右节点不为 null
	 * 右节点标为当前节点 执行 2
	 */
	public static void inOrderByStack(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode cur = treeNode;

		while (stack.size() != 0 || cur != null) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			TreeNode node = stack.pop();
			System.out.print(node.value + " ");
			cur = node.right;
		}
	}

	static void postOrder(TreeNode tree) {
		if (tree == null) {
			return;
		}
		postOrder(tree.left);
		postOrder(tree.right);
		System.out.print(tree.value + " ");
	}

	/*
	 * 两个栈第二个栈存储最后的输出顺序
	 * 第一个栈用来辅助向第二个栈中添加数据
	 * 
	 * Q:为什么先序和中序只用一个栈就行了，而后序需要两个栈
	 * 
	 * A:先序和中序的时候可以把左节点先出栈不影响最后的输出结果
	 * 后序的时候如果先把右节点进栈 
	 * 不出栈无法把左节点添加进栈
	 * 出栈了最后输出结果不完全
	 */
	public static void postOrderByStack(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}

		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();

		stack1.push(treeNode);
		TreeNode current = treeNode;

		while (stack1.size() != 0) {
			current = stack1.pop();
			if (current.left != null) {
				stack1.push(current.left);
			}
			if (current.right != null) {
				stack1.push(current.right);
			}
			stack2.push(current);
		}

		while (stack2.size() != 0) {
			TreeNode node = stack2.pop();
			System.out.print(node.value + " ");
		}
	}

	static void printByLevel(TreeNode treeNode) {

		/*
		 * Q:什么情况下表示该换行了 Q:什么情况下表示已经遍历完所有数据
		 */

		/*
		 * A:当前节点指向当前行最后一个元素时表示该换行了 A:链表数据为空时表示已经遍历完所有数据
		 */

		/*
		 * 把所有元素添加到链表 一个指针记录当前行的最后一个元素 一个指针记录下一行的最后一个元素
		 */

		TreeNode currentLast = treeNode;
		TreeNode nextLast = treeNode;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(treeNode);

		while (!queue.isEmpty()) {

			TreeNode node = queue.poll();
			System.out.print(node.value);

			if (node.left != null) {
				queue.offer(node.left);
				nextLast = node.left;
			}

			if (node.right != null) {
				queue.offer(node.right);
				nextLast = node.right;
			}

			if (node == currentLast) {
				currentLast = nextLast;
				System.out.println("");
			}
		}

	}
}
