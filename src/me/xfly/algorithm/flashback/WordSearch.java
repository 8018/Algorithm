package me.xfly.algorithm.flashback;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A'}};
        String str = "A";
        /*char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String str = "ABCCED";*/
        new WordSearch().exist(board,str);
    }
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m;
    int n;
    boolean[][] marked;

    public boolean exist(char[][] board, String word) {
         m = board.length;
         n = board[0].length;
        marked = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; ++j) {
                if (dfs(i, j, 0, word, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int x, int y, int index, String word, char[][] board) {
        if (index == word.length()-1) {
            return word.charAt(index) == board[x][y];
        }

        if (word.charAt(index) == board[x][y]) {
            marked[x][y] = true;
            for (int i = 0; i < directions.length; ++i) {
                int newX = directions[i][0]+x;
                int newY = directions[i][1]+y;
                if (isValid(newX,newY)&&!marked[newX][newY]) {
                    if (dfs(newX, newY, index + 1, word, board)) {
                        return true;
                    }
                }
            }
            marked[x][y] = false;
        }

        return false;
    }

    public boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}