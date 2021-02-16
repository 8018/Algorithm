package me.xfly.algorithm.tree;

import me.xfly.algorithm.listnode.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codec {



    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeHelper(root,"");
    }

    public String serializeHelper(TreeNode root,String str){
        if(root == null){
            str += "None,";
        }else{
            str += root.value +",";
            str = serializeHelper(root.left,str);
            str = serializeHelper(root.right,str);
        }

        return str;
    }

    public TreeNode deserialize(String data) {
        String[] array = data.split(",");
        List<String> strs = new ArrayList<>(Arrays.asList(array));
        return  deserializeHelper(strs);
    }

    public TreeNode deserializeHelper(List<String> strs){
        if(strs.get(0).equals("None")){
            strs.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(strs.get(0)));
        strs.remove(0);
        root.left = deserializeHelper(strs);
        root.right = deserializeHelper(strs);

        return root;
    }

    @Test
    public void test(){
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(5);
        String str = serialize(node);
        System.out.println(str);

        TreeNode node1 = deserialize(str);
        System.out.println(str);
    }

}
