package me.xfly.algorithm.tree;

public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = new TreeNode(pre[0]);
        buildTree(root, pre, 0, pre.length, in, 0, in.length);
        return root;
    }

    public void buildTree(TreeNode root, int[] pre, int pLeft, int pRight, int[] in, int iLeft, int iRight) {
        //1、找到根结点在中序数组中的位置
        int i;
        for (i = iLeft; i < iRight; i++) {
            if (root.value == in[i]) {
                break;
            }
        }

        //左子树的节点数
        int t = i - iLeft;

        //pRight 不可到达，iRight 同样不可到达
        if (t > 0) {
            //pLeft 是根结点，pLeft+1 即左节点
            root.left = new TreeNode(pre[pLeft + 1]);
            buildTree(root.left, pre, pLeft + 1, pLeft + 1 + t, in, iLeft, i);
        }

        //总的节点数减去 1 个父节点数，再减去 t 个 左子树节点数，剩下的表示右子树节点数
        if (pRight - pLeft - 1 - t > 0) {
            root.right = new TreeNode(pLeft + 1 + t);
            buildTree(root.right,pre,pLeft+1+t,pRight,in,i+1,iRight);
        }


    }
}
