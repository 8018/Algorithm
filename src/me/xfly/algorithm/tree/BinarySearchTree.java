package me.xfly.algorithm.tree;

import java.time.temporal.ValueRange;

public class BinarySearchTree {

    public TreeNode tree;

    public void insert(int data){
        if(tree == null){
            tree = new TreeNode(data);
            return;
        }
        TreeNode p = tree;
        while (p!=null){
            if(data > p.value){
                if (p.right == null){
                    p.right = new TreeNode(data);
                    return;
                }
                p = p.right;
            }else{
                if(p.left == null){
                    p.left = new TreeNode(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public TreeNode find(int data){
        while (tree!=null){
            if(tree.value > data){
                tree = tree.left;
            } else if (tree.value < data) {
                tree = tree.right;
            }else{
                return tree;
            }
        }

        return null;
    }

    /**
     * 删除节点的时候有三种情况
     * 1、被删节点没有子节点，可以直接删除
     * 2、被删节点有一个子节点，子节点代替被删节点
     * 3、被删节点有两个子节点，找右子树的最小值（左子树的最大值）跟被删节点交换
     *    交换后情况变成 1 或 2
     * *//*
    public void delete(int data) {
        //指向被删除的节点，初始指向根节点
        TreeNode p = tree;
        //指向被删节点的父节点
        TreeNode pp = null;

        //找到要被删节点
        while (p != null && p.value != data) {
            pp = p;
            if (data > p.value) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        if (p == null) {
            return;
        }

        //如果被删节点有两个子节点，找一个节点跟目标节点交换
        if (p.left != null && p.right != null) {
            TreeNode miniP = p.right;
            TreeNode miniPP = p;

            while (miniP.left != null) {
                miniPP = miniP;
                miniP = miniPP.left;
            }

            p.value = miniP.value;
            p = miniP;
            pp = miniPP;
        }

        //两个child 的情况处理过之后，变成只有一个或没有 child，找到这个child
        TreeNode child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        //pp == null 目标节点是根节点
        if (pp == null) {
            tree = child;
            return;
        }
        //将目标节点替换成它的 child
        if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }*/
    /**
     * 被删除的节点有三种情况：
     * 1、没有子节点，可直接删除
     * 2、被删除的节点只有一个子节点，用子节点代替被删除节点
     * 3、被删除的节点有两个子节点，找到右子树最小节点或左子树最大节点替换被删节点
     *    替换之后情况变成1或2
     */
    public void delete(int data){
        //指向被删节点，初始指向根结点
        TreeNode p = tree;
        //指向被删节点的父节点
        TreeNode pp = null;

        //找到被删节点和它的父节点
        while (p!=null && p.value!=data){
            pp = p;
            if(p.value > data){
                p = p.left;
            }else{
                p = p.right;
            }
        }

        if(p == null){
            return;
        }

        //如果两个孩子都不为 null，找到左子树最大节点或右子树最小节点替换目标节点
        if(p.left!=null && p.right !=null){
            TreeNode miniP = p.right;
            TreeNode miniPP = p;

            while (miniP.left !=null){
                miniPP = miniP;
                miniP = miniPP.left;
            }

            p.value = miniP.value;
            p = miniP;
            pp = miniPP;
        }

        TreeNode child;
        if(p.left!= null){
            child = p.left;
        }else if (p.right!=null){
            child = p.right;
        }else{
            child = null;
        }

        if(pp == null){
            tree =  child;
            return;
        }

        if (pp.left == p){
            pp.left = child;
        }else{
            pp.right = p;
        }
    }
}
