package me.xfly.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuxiangfei
 *
 */
public class BinaryTree {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insert(8);
		tree.insert(4);
		tree.insert(6);
		tree.insert(9);
		tree.insert(11);
		tree.insert(3);
		tree.insert(2);

		System.out.println(getTreeHeight(tree.tree));
		System.out.println(getTreeHeightByLevel(tree.tree));
	}

	/**
	 * 求二叉树的高度 1 当前节点的高度等于左右子树中 最高的子树的高度加 1
	 */
	public static int getTreeHeight(Node node) {
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
	static int getTreeHeightByLevel(Node treeNode) {

		int height = 0;

		if (treeNode == null) {
			return height;
		}

		Node currentLast = treeNode;
		Node nextLast = treeNode;
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(treeNode);

		while (!queue.isEmpty()) {

			Node node = queue.poll();

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

	public static void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.println(node.data + "");
		inOrder(node.right);
	}

	public Node tree;

	public Node find(int data) {
		Node p = tree;
		while (p != null) {
			if (data < p.data)
				p = p.left;
			else if (data > p.data)
				p = p.right;
			else
				return p;
		}
		return null;
	}

	public static class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public void insert(int data) {
		if (tree == null) {
			tree = new Node(data);
			return;
		}

		Node p = tree;
		while (p != null) {
			if (data > p.data) {
				if (p.right == null) {
					p.right = new Node(data);
					return;
				}
				p = p.right;
			} else { // data < p.data
				if (p.left == null) {
					p.left = new Node(data);
					return;
				}
				p = p.left;
			}
		}
	}

	/**
	 * 删除一个节点分三种情况 1、要删除的节点没有字节点 直接删除 2、要删除的节点有一个字节点 字节点代替要删除的节点 3、要删除的节点有两个字节点
	 * 找到右子树的最小值代替当前节点
	 */
	public void delete(int data) {
		Node p = tree; // p 指向要删除的节点，初始化指向根节点
		Node pp = null; // pp 记录的是 p 的父节点
		while (p != null && p.data != data) {
			pp = p;
			if (data > p.data)
				p = p.right;
			else
				p = p.left;
		}
		if (p == null)
			return; // 没有找到

		// 要删除的节点有两个子节点
		if (p.left != null && p.right != null) { // 查找右子树中最小节点
			Node minP = p.right;
			Node minPP = p; // minPP 表示 minP 的父节点
			while (minP.left != null) {
				minPP = minP;
				minP = minP.left;
			}
			p.data = minP.data; // 将 minP 的数据替换到 p 中
			p = minP; // 下面就变成了删除 minP 了
			pp = minPP;
		}

		// 删除节点是叶子节点或者仅有一个子节点
		Node child; // p 的子节点
		if (p.left != null)
			child = p.left;
		else if (p.right != null)
			child = p.right;
		else
			child = null;

		if (pp == null)
			tree = child; // 删除的是根节点
		else if (pp.left == p)
			pp.left = child;
		else
			pp.right = child;
	}

}
