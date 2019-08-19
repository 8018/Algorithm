package me.xfly.algorithm.tree;

public class TreeNode {
	public int value;
	public TreeNode leftNode;
	public TreeNode rightNode;
	
	public TreeNode(int value) {
		this.value = value;
	}
	
	public static TreeNode generateTree() {
		TreeNode  tree = new TreeNode(1);

		TreeNode  tree2 = new TreeNode(2);
		TreeNode  tree3 = new TreeNode(3);
		
		tree.leftNode = tree2;
		tree.rightNode = tree3;
		
		TreeNode  tree4 = new TreeNode(4);
		TreeNode  tree5 = new TreeNode(5);		
		TreeNode  tree6 = new TreeNode(6);
		TreeNode  tree7 = new TreeNode(7);
		
		tree2.leftNode = tree4;
		tree2.rightNode = tree5;
		tree3.leftNode = tree6;
		tree3.rightNode = tree7;
		
		TreeNode  tree8 = new TreeNode(8);
		TreeNode  tree9 = new TreeNode(9);		
		TreeNode  tree10 = new TreeNode(10);
		TreeNode  tree11 = new TreeNode(11);		
		TreeNode  tree12 = new TreeNode(12);
		TreeNode  tree13 = new TreeNode(13);		
		TreeNode  tree14 = new TreeNode(14);
		TreeNode  tree15 = new TreeNode(15);
		
		tree4.leftNode = tree8;
		tree4.rightNode = tree9;
		tree5.leftNode = tree10;
		tree5.rightNode = tree11;		
		tree6.leftNode = tree12;
		tree6.rightNode = tree13;
		tree7.leftNode = tree14;
		tree7.rightNode = tree15;
		
		
		return tree;
	}
}
