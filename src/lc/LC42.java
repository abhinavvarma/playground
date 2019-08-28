package lc;

public class LC42 {
    public int trap(int[] h) {
        if (h.length<3) {
            return 0;
        }
        int[] rH = new int[h.length];
        int w = 0, maxL = 0, c;
        rH[h.length-1] = 0;
        for (int i=h.length-2;i>=0;i--) {
            rH[i] = Math.max(rH[i+1], h[i+1]);
        }
        for (int i=1;i<h.length;i++) {
            c = Math.min(maxL, rH[i]) - h[i];
            if (c>0) {
                w += c;
            }
            maxL = Math.max(h[i], maxL);
        }
        return w;
    }

    public static void main(String[] args) {
        LC42 l = new LC42();
        l.trap(new int[]{2,0,2});
    }
}
