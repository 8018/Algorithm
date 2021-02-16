package me.xfly.algorithm.tree;

public class ISValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    public boolean isValidBSTHelper(TreeNode node, Integer low, Integer high) {
        if (node == null) return true;
        int val = node.value;

        if (low!=null && val <=low) return false;
        if (high !=null && val >= high)return false;

        if (!isValidBSTHelper(node.right,val,high))return false;
        if (!isValidBSTHelper(node.left,low,val)) return false;

        return true;
    }
}
