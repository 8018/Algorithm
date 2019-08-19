package me.xfly.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Iterator {
	public static void main(String[] args) {
		TreeNode tree = TreeNode.generateTree();
		
		/**
		 * 前、中、后 遍历的时候没个节点最多被访问两次
		 * 所以时间复杂度是 O（n）
		 * */
		/*
		 * preOrder(tree); System.out.println("=============================");
		 * inOrder(tree); System.out.println("=============================");
		 * postOrder(tree);
		 */
		
		printByLevel(tree);
	}
	
	static void preOrder(TreeNode tree) {
		if (tree == null) {
			return;
		}
		System.out.println(tree.value+"");
		preOrder(tree.leftNode);
		preOrder(tree.rightNode);
	}
	
	static void inOrder(TreeNode tree) {
		if (tree == null) {
			return;
		}
		inOrder(tree.leftNode);
		System.out.println(tree.value+"");
		inOrder(tree.rightNode);
	}
	
	static void postOrder(TreeNode tree) {
		if (tree == null) {
			return;
		}
		postOrder(tree.leftNode);
		postOrder(tree.rightNode);
		System.out.println(tree.value+"");
	}
	
	static void printByLevel(TreeNode treeNode) {
		
		/*
		 * Q:什么情况下表示该换行了
		 * Q:什么情况下表示已经遍历完所有数据
		 */
		
		/*
		 * A:当前节点指向当前行最后一个元素时表示该换行了
		 * A:链表数据为空时表示已经遍历完所有数据
		 * */
		
		/* 把所有元素添加到链表
		 * 一个指针记录当前行的最后一个元素
		 * 一个指针记录下一行的最后一个元素
		 */
		
		TreeNode currentLast = treeNode;
		TreeNode nextLast = treeNode;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(treeNode);
		
		while (!queue.isEmpty()) {
			
			TreeNode node = queue.poll();
			System.out.print(node.value);
			
			if (node.leftNode != null) {
				queue.offer(node.leftNode);
				nextLast = node.leftNode;
			}
			
			if (node.rightNode != null) {
				queue.offer(node.rightNode);
				nextLast = node.rightNode;
			}
			
			if (node == currentLast) {
				currentLast = nextLast;
				System.out.println("");
			}
		}
		
	}
}
