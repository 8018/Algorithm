package me.xfly.algorithm.flashback;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_39 {

    public static void main(String[] args) {
        combinationSum(new int[]{2, 3, 6, 7},7);
        System.out.println();
    }

    static List<List<Integer>> container = new ArrayList();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList();

        flashBack(temp,candidates,target,0);
        return container;
    }

    public static void flashBack(List<Integer> temp,int[] candidates,int target,int index){
        if(target == 0){
            container.add(temp);
            temp = new ArrayList();
            return;
        }

        if(target < 0){
            return;
        }

        for(int i = 0;i <candidates.length;i++){
            target = target - candidates[i];
            temp.add(candidates[i]);
            index = index +1;
            flashBack(temp,candidates,target,index);
            target = target + candidates[i];
            temp.remove(index-1);
            index = index - 1;
        }
    }
}
