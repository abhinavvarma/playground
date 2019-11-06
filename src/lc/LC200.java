package lc;

import utils.Display;

public class LC200 {
    private boolean dfs(Character[][] grid, int i, int j) {
        if (i>-1 && j>-1 && i<grid.length && j<grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i-1, j);
            dfs(grid, i+1, j);
            dfs(grid, i, j+1);
            dfs(grid, i, j-1);
            return true;
        }

        return false;
    }

    public int numIslands(Character[][] grid) {
        int n = 0;
        for (int i= 0; i<grid.length; i++) {
            for (int j= 0; j<grid[0].length; j++) {
                if (dfs(grid, i, j)) {
                    Display.printLine();
                    n++;
                }
            }
        }

        return n;
    }

    public static void main(String[] args) {
        Character[][] g = new Character[][] {{'1','0','1','1','1'},{'1','0','1','0','1'},{'1','1','1','0','1'}};
        System.out.println(new LC200().numIslands(g));
    }
}
