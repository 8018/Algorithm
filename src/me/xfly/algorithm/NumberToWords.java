package me.xfly.algorithm;

import org.junit.Test;

public class NumberToWords {

    @Test
    public void test(){
        numberToWords(123);
    }

    public String numberToWords(int num) {
        if(num == 0){
            return "zero";
        }

        int billion = num / 1000000000;
        int million = (num - billion * 1000000000) / 1000000;
        int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
        int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;

        String ans = "";
        if(billion != 0){
            ans += three(billion) + " billion";
        }
        if(million != 0){
            if (! ans.isEmpty())
                ans += " ";
            ans += three(million) + " million";
        }

        if(thousand != 0){
            if (! ans.isEmpty())
                ans += " ";
            ans += three(thousand) + " thousand";
        }

        if (rest != 0) {
            if (! ans.isEmpty())
                ans += " ";
            ans += three(rest);
        }
        return ans;

    }

    public String one(int num){
        switch(num){
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
        }
        return "";
    }

    public String twoLessThanTwenty(int num){
        switch(num){
            case 10 : return "ten";
            case 11 : return "eleven";
            case 12 : return "twelve";
            case 13 : return "thirteen";
            case 14 : return "fourteen";
            case 15 : return "fifteen";
            case 16 : return "sixteen";
            case 17 : return "seventeen";
            case 18 : return "eightteen";
            case 19 : return "nineteen";
        }
        return "";
    }

    public String ten(int num){
        switch(num){
            case 2 : return "twenty";
            case 3 : return "thirty";
            case 4 : return "fourty";
            case 5 : return "fifty";
            case 6 : return "sixty";
            case 7 : return "seventy";
            case 8 : return "eighty";
            case 9 : return "ninety";
        }
        return "";
    }

    public String two(int num){
        if(num == 0){
            return "";
        }else if(num < 10){
            return one(num);
        }else if(num < 20){
            return twoLessThanTwenty(num);
        }else{
            int tenner = num/10;
            int rest = num - tenner * 10;

            if(rest != 0){
                return ten(tenner) + " "+ one(rest);
            }else{
                return ten(tenner);
            }
        }
    }

    public String three(int num){
        int hundred = num/100;
        int rest = num - hundred * 100;
        String res = "";
        if(hundred * rest != 0){
            return one(hundred) + " Hundred " + two(rest);
        }else if(hundred != 0 && rest == 0){
            return one(hundred) + " Hundred ";
        }else if(hundred == 0 && rest != 0){
            return two(rest);
        }
        return "";
    }
}
