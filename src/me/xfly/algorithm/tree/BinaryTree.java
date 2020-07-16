package me.xfly.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuxiangfei
 *
 */
public class BinaryTree {
	public static void main(String[] args) {
	}

	/**
	 * 求二叉树的高度 1 当前节点的高度等于左右子树中 最高的子树的高度加 1
	 */
	public static int getTreeHeight(TreeNode node) {
		int leftHeight = 1;
		int rightHeight = 1;
		if (node == null) {
			return 0;
		}

		if (node.left != null) {
			leftHeight = getTreeHeight(node.left) + 1;
		}

		if (node.right != null) {
			rightHeight = getTreeHeight(node.right) + 1;
		}

		return leftHeight > rightHeight ? leftHeight : rightHeight;
	}

	/**
	 * 求二叉树的高度 2
	 * 根据分层遍历的思想
	 */
	static int getTreeHeightByLevel(TreeNode treeNode) {

		int height = 0;

		if (treeNode == null) {
			return height;
		}

		TreeNode currentLast = treeNode;
		TreeNode nextLast = treeNode;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(treeNode);

		while (!queue.isEmpty()) {

			TreeNode node = queue.poll();

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
				height = height + 1;
			}
		}

		return height;

	}

	public static void inOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.println(node.value + "");
		inOrder(node.right);
	}



}
