package lc;


public class LC45 {
    static int minJumps(int a[], int cur) {
        int cnt = 0;


        int maxJi = cur;
        if (maxJi >= a.length-1)
            return cnt;
        for (int i=cur;i <= cur+a[cur]; i++) {
            if(a[i]>=a[maxJi])
                maxJi = i;
        }
        cur = maxJi;
        cnt++;
        return -1;
    }

    public static void main(String[] args) {
        int a[] = new int[]{2, 3, 1, 1, 4};

    }
}
