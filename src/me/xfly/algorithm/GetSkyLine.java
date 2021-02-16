package me.xfly.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GetSkyLine {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList();
        if(buildings == null || buildings.length == 0){
            return ans;
        }
        return getSkylineHelper(buildings,0,buildings.length -1);
    }

    public List<List<Integer>> getSkylineHelper(int[][] buildings,int left,int right) {
        List<List<Integer>> ans = new ArrayList();
        if(left == right){
            List<Integer> temp = new ArrayList();
            temp.add(buildings[left][0]);
            temp.add(buildings[left][2]);
            ans.add(temp);

            List<Integer> temp1 = new ArrayList();
            temp1.add(buildings[left][1]);
            temp1.add(0);
            ans.add(temp1);
            return ans;
        }

        int mid = (left + right)/2;

        List<List<Integer>> leftSkyLine = getSkylineHelper(buildings,left,mid);
        List<List<Integer>> rightSkyLine = getSkylineHelper(buildings,mid+1,right);

        int leftIndex = 0;
        int rightIndex = 0;
        int leftHeight = 0;
        int rightHeight = 0;

        while(leftIndex < leftSkyLine.size() || rightIndex < rightSkyLine.size()){
            long x1 = leftIndex < leftSkyLine.size() ? leftSkyLine.get(leftIndex).get(0) : Long.MAX_VALUE;
            long x2 = rightIndex < rightSkyLine.size() ? rightSkyLine.get(rightIndex).get(0) : Long.MAX_VALUE;
            long x = 0;
            if(x1 > x2){
                x = x2;
                rightHeight = rightSkyLine.get(rightIndex).get(1);
                rightIndex ++;

            }else if(x2 > x1){
                x = x1;
                leftHeight = leftSkyLine.get(leftIndex).get(1);
                leftIndex ++;
            }else{
                x = x1;
                leftHeight = leftSkyLine.get(leftIndex).get(1);
                rightHeight = rightSkyLine.get(rightIndex).get(1);
                leftIndex ++;
                rightIndex ++;
            }
            int height = Math.max(leftHeight,rightHeight);

            if(ans.isEmpty() || ans.get(ans.size() - 1).get(1) != height){
                List<Integer> temp = new ArrayList<>();
                temp.add((int) x);
                temp.add(height);
                ans.add(temp);
            }
        }

        return ans;
    }

    @Test
    public void test(){
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        getSkyline(buildings);
    }
}
