package me.xfly.algorithm.listnode;

import me.xfly.algorithm.tree.TreeNode;

import java.util.Stack;

public class TreeNodeConvertToListNode {
    /**
     *  二叉搜索树转为双向链表——本质上是中序遍历
     */
    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return pRootOfTree;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode ans = new TreeNode(-1);
        TreeNode temp = ans;

        addToStack(stack,pRootOfTree);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            temp.right = node;
            node.left = temp;
            temp = node;
            if (node.right != null) {
                addToStack(stack,node.right);
            }
        }
        ans.right.left = null;
        return ans.right;
    }

    public void addToStack(Stack<TreeNode> stack,TreeNode node){
        while (node != null) {
            stack.add(node);
            node = node.left;
        }
    }
}
