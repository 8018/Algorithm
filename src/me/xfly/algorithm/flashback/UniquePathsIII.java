package me.xfly.algorithm.flashback;

public class UniquePathsIII {


    public static void main(String[] args) {
        UniquePathsIII uniquePathsIII = new UniquePathsIII();
        int[][] data = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        System.out.println(uniquePathsIII.uniquePathsIII(data));
    }

    int[][] grid;
    int R,C;
    int endR,endC;
    int[] dr = new int[]{0, -1, 0, 1};
    int[] dc = new int[]{1, 0, -1, 0};
    int ans;
    public int uniquePathsIII(int[][] grid){
        this.grid = grid;
        R = grid.length;
        C = grid[0].length;
        int sr = 0,sc = 0,todo = 0;
        for (int i = 0;i<R;i++){
            for (int j = 0;j<C;j++){
                if (grid[i][j] != -1){
                    todo++;
                }

                if (grid[i][j] == 1){
                    sr = i;
                    sc = j;
                }else if (grid[i][j] == 2){
                    endR = i;
                    endC = j;
                }
            }
        }

        backTrack(sr,sc,todo);

        return ans;
    }

    public void backTrack(int r,int c,int todo){
        todo--;
        if (todo < 0){
            return;
        }

        if (r == endR && c == endC) {
            if (todo == 0) ans++;
            return;
        }

        grid[r][c] = 3;

        for (int k = 0;k<4;k++){
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                if (grid[nr][nc] % 2 == 0)
                    backTrack(nr, nc, todo);
            }

        }

        grid[r][c] = 0;

    }
}
