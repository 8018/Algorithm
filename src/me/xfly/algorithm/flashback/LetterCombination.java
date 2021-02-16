package me.xfly.algorithm.flashback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits == null||digits.length() == 0){
            return ans;
        }

        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backTrack(digits,map,0,new StringBuffer(),ans);
        return ans;
    }

    public void backTrack(String digits, Map<Character,String> map,int index,StringBuffer buffer,List<String> ans){
        if(index == digits.length()){
            ans.add(buffer.toString());
            return;
        }

        char digit = digits.charAt(index);
        String str = map.get(digit);

        for(int i = 0;i<str.length();i++){
            buffer.append(str.charAt(i));
            backTrack(digits,map,index+1,buffer,ans);
            buffer.deleteCharAt(index);
        }
    }


}