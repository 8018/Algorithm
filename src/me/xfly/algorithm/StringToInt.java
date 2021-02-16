package me.xfly.algorithm;

import org.junit.Test;

public class StringToInt {
    public int myAtoi(String str) {
        int len = str.length();
        char[] chars = str.toCharArray();
        int index = 0;
        while (chars[index] == ' ' && index < len) {
            index++;
        }

        if (index == len) return 0;

        int sign = 1;
        int firstChar = chars[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        int ans = 0;
        while (index < len) {
            char currChar = chars[index];
            if (currChar > '9' || currChar < '0') {
                break;
            }

            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE / 10)) {
                return Integer.MAX_VALUE;
            }

            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            ans = ans * 10 + sign * (currChar - '0');
            index++;


        }
        return ans;
    }

    @Test
    public void test(){
        myAtoi("+1000s99");
    }
}