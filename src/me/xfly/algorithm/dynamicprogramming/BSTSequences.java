package me.xfly.algorithm.dynamicprogramming;

import me.xfly.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class BSTSequences {

    public static void main(String[] args) {
        BSTSequences bstSequences = new BSTSequences();
        TreeNode node3 = new TreeNode(3);
        TreeNode node0 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node3.left = node0;
        node3.right = node4;
        node0.right = node1;
        node1.right = node2;

        bstSequences.BSTSequences(node3);
    }

    List<List<Integer>> reses = new LinkedList<>();
    LinkedList<Integer> res = new LinkedList<>();

    /**
     * 一个节点后面出现的并不一定是它的子节点
     *
     * 维护一个「下一个节点」列表
     * 从该列表里选择一个作为下一个输出
     *
     * 输出一个节点之后把它的子节点加入「下一个节点列表」
     *
     * 回溯 找到所有满足的结果
     *
     * */
    public List<List<Integer>> BSTSequences(TreeNode root) {
        if(root==null){reses.add(res);return reses;}
        HashSet<TreeNode> curLevel = new HashSet<>();
        curLevel.add(root);
        dfs(curLevel);
        return reses;
    }
    public void dfs(HashSet<TreeNode> curLevel) {
        //当前集合没有需要遍历的元素，说明遍历到底
        if(curLevel.size()==0) {
            reses.add(new LinkedList<>(res));
            return;
        }
        HashSet<TreeNode> nextLevel = new HashSet<>(curLevel);
        for(TreeNode t:curLevel) {
            res.add(t.value);
            nextLevel.remove(t);//出了当前节点，其余节点下一层都可以遍历
            if(t.left!=null)nextLevel.add(t.left);
            if(t.right!=null)nextLevel.add(t.right);
            dfs(nextLevel);
            if(t.left!=null)nextLevel.remove(t.left);
            if(t.right!=null)nextLevel.remove(t.right);
            nextLevel.add(t);
            res.removeLast();
        }
    }

}
