package lc;

import utils.arrays.Boxing;
import utils.arrays.Matrix2D;

import java.util.Arrays;
import java.util.Collections;

class LIP extends Matrix2D<Integer> {
    private int longest;

    public LIP(Integer[][] array) {
        super(array);
    }

    @Override
    public boolean set(int r, int c, Integer v) {
        boolean isSet = super.set(r, c, v);
        if (isSet && longest < v) {
            longest = v;
        }
        return isSet;
    }

    public int getLongest() {
        return longest;
    }
}

public class LC329 {
    private int step(Matrix2D<Integer> matrix, int cur, int r, int c, LIP dp) {
        if (matrix.isInBounds(r,c)) {
            int next = matrix.get(r, c);
            if (cur < next)
                return traverse(matrix, r, c, dp);
        }
        return 0;
    }

    private int traverse(Matrix2D<Integer> matrix, int r, int c, LIP dp) {
        if (dp.isInBounds(r, c)) {
            int cur = matrix.get(r, c);
            int right = step(matrix, cur, r, c+1, dp);
            int down = step(matrix, cur, r+1, c, dp);
            int left = step(matrix, cur, r, c-1, dp);
            int top = step(matrix, cur, r-1, c, dp);
            Integer[] vals = {right, down, left, top};
            int max = Collections.max(Arrays.asList(vals)) + 1;
            dp.set(r, c, max);
            return max;
        }

        return 0;
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0)
            return 0;
        LIP dp = new LIP(new Integer[matrix.length][matrix[0].length]);
        Matrix2D<Integer> matrix2D = new Matrix2D<Integer>(Boxing.toInteger2DArray(matrix));
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                traverse(matrix2D, r, c, dp);
            }
        }
        dp.print();
        return dp.getLongest();
    }

    public static void main(String[] args) {
        LC329 lc = new LC329();
        int[][] matrix = {
          {9,9,4},
          {6,6,8},
          {2,1,1}
        };
        lc.longestIncreasingPath(matrix);
    }
}
