package lc;

//https://leetcode.com/problems/median-of-two-sorted-arrays/

class NoMedianException extends Exception {

}

public class Q4 {
    int getMedianOfSortedArray(int[] num) {
        return num[num.length/2];
    }

    private int getElement(int[] num, int i) {
        if (i < num.length)
            return num[i];
        return Integer.MAX_VALUE;

    }

    float median(int[] num1, int[] num2) throws NoMedianException {
        int i = 0, j = 0, k = 0, median = 0;
        if (num1.length+num2.length == 0) {
            throw new NoMedianException();
        }
        int finalSize = num1.length+num2.length;
        int medianIndex = (finalSize%2)==0?finalSize/2-1:finalSize/2;
        while(k <= medianIndex) {
            if(getElement(num1, i) < getElement(num2, j)) {
                median = num1[i++];
            } else {
                median = num2[j++];
            }
            k++;
        }
        if ((num1.length + num2.length)%2 == 0) {
            if(getElement(num1, i) < getElement(num2, j)) {
                return (float)(median + num1[i]) / 2;
            } else {
                return (float) (median + num2[j]) / 2;
            }
        }
        return median;
    }

    public static void main(String[] args) throws NoMedianException {
        Q4 q = new Q4();
        System.out.println(q.median(new int[]{}, new int[]{3,4}));
    }
}
