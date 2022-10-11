package me.xfly.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class GenerateBST {

    public void test(){
        generateTrees(3);
    }

    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList();
        }
        return generateTrees(1,n);
    }

    public List<TreeNode> generateTrees(int start,int end){
        List<TreeNode> ans = new ArrayList();

        if(start > end){
            ans.add(null);
            return ans;
        }

        for(int i = start;i<= end;i++){
            List<TreeNode> leftTrees = generateTrees(start,i-1);
            List<TreeNode> rightTrees = generateTrees(i+1,end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    ans.add(currTree);
                }
            }
        }

        return ans;
    }
}
