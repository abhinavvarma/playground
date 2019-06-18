package lc;

public class LC72 {

    public int minDistance(String word1, String word2) {
        char[] wordA1 = word1.toCharArray();
        char[] wordA2 = word2.toCharArray();

        int[][] t = new int[wordA1.length+1][wordA2.length+1];

        for (int i = 0; i <= wordA1.length; i++) {
            t[i][0] = i;
        }
        for (int i = 1; i <= wordA2.length; i++) {
            t[0][i] = i;
        }

        for (int i = 1; i <= wordA1.length; i++) {
            for (int j = 1; j <= wordA2.length; j++) {
                if (wordA1[i-1] == wordA2[j-1])
                    t[i][j] = t[i-1][j-1];
                else
                    t[i][j] = Math.min(t[i-1][j-1], Math.min(t[i][j-1], t[i-1][j])) + 1;
            }
        }

        return t[wordA1.length][wordA2.length];
    }

    public static void main(String[] args) {
        LC72 l = new LC72();
        System.out.println(l.minDistance("horse", "ros"));
    }
}
