package lc;

public class LC64 {
    public static void main(String[] args) {
        LC64 l = new LC64();
        System.out.println(l.minPathSum(new int[][] {
                new int[] { 1, 2, 5 },
                new int[] { 3, 2, 1 }
        }));
    }

    private int get(int[][] grid, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return Integer.MAX_VALUE;
        }

        return grid[i][j];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] cache = new int[m][n];
        int min = 0;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i != m - 1 || j != n - 1) {
                    min = Integer.min(
                            get(cache, m, n, i + 1, j),
                            get(cache, m, n, i, j + 1)
                    );
                }
                cache[i][j] = min + grid[i][j];
            }
        }
        return cache[0][0];
    }
}
