package me.xfly.algorithm.window;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_76 {

    public static void main(String[] args) {
        System.out.println(minWindow("aa"
                , "aa"));
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c,0) + 1);
        }

        int start = 0;
        int len = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int valid = 0;
        char[] chars = s.toCharArray();
        while (right < s.length()) {
            char c = chars[right];
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c,0)+1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = chars[left];
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }


        if (len == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + len);
    }
}
