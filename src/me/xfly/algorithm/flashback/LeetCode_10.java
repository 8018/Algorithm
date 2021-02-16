package me.xfly.algorithm.flashback;

public class LeetCode_10 {

    public static void main(String[] args) {
        new LeetCode_10().isMatch("abbbbc"
                , "ab*d*c");
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] ans = new boolean[m + 1][n + 1];

        ans[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(p.charAt(j-1) == '*'){
                    ans[i][j] = ans[i][j-2];
                    if(matches(s,p,i,j-1)){
                        ans[i][j] = ans[i][j] || ans[i-1][j];
                    }
                }else{
                    if(matches(s,p,i,j)){
                        ans[i][j] = ans[i-1][j-1];
                    }
                }
            }
        }

        return ans[m][n];
    }

    public boolean matches(String s, String p, int si, int pi) {
        if (si == 0) {
            return false;
        }
        if (p.charAt(pi - 1) == '.') {
            return true;
        }

        return s.charAt(si - 1) == p.charAt(pi - 1);
    }

}
