package me.xfly.algorithm.string;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseWords {

    @Test
    public void test(){
        reverseWords("a   good example");
    }

    public String reverseWords(String str) {
        int left = 0;
        int right = str.length() - 1;

        char[] chars = str.toCharArray();

        while (left <= right && chars[left] == ' ') {
            left ++;
        }
        while (left <= right && chars[right] == ' ') {
            right --;
        }

        StringBuilder builder = new StringBuilder();
        Deque<String> deque = new ArrayDeque<>();

        while(left <= right){
            char c = chars[left];
            if((builder.length() != 0) && (c == ' ')){
                deque.offerFirst(builder.toString());
                builder.setLength(0);
            }else if(c != ' '){
                builder.append(c);
            }
            ++left;
        }

        deque.offerFirst(builder.toString());
        return String.join(" ", deque);
    }
}
