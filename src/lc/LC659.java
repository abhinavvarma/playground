package lc;

public class LC659 {
    int chainsWithSize1 = 0;
    int chainsWithSize2 = 0;
    int chainsWithSize3OrMore = 0;
    /**
     * fills the maximum possible chains with the chainIndex by one element each and passes on the left over to the next chainIndex
     * @param chainIndex
     * @param rMap
     * @param pC - overflown no. of eles from previous chain index to current
     * @param c  - being added to current chainIndex
     * @return
     */
//    private int addToChain(int chainIndex, int[] rMap, int pC, int c) {
//        if (chainIndex < rMap.length) {
//            int noOfChainsWhoseLengthIncreasedBy1 = Math.min(rMap[chainIndex], c);
//            int excess = addToChain(chainIndex + 1, rMap, noOfChainsWhoseLengthIncreasedBy1, c - noOfChainsWhoseLengthIncreasedBy1);
//            if (chainIndex == 1)
//                pC = excess;
//            if (chainIndex == rMap.length-1)
//                pC = excess;
//            rMap[chainIndex] = rMap[chainIndex] - noOfChainsWhoseLengthIncreasedBy1 + pC;
//        }
//    }

    private int getIfPositive(int v) {
        return v > 0 ? v : 0;
    }

    private int addToChain(int c) {
        int size0ToSize1 = getIfPositive(c - chainsWithSize1 - chainsWithSize2 - chainsWithSize3OrMore);
        int size2Tosize3 = Math.min(chainsWithSize2, getIfPositive(c-chainsWithSize1));
        int size1ToSize2 = Math.min(chainsWithSize1, c);
        chainsWithSize3OrMore += size2Tosize3;
        chainsWithSize2 = getIfPositive(chainsWithSize2 - size2Tosize3) + size1ToSize2;
        chainsWithSize1 = getIfPositive(chainsWithSize1 - size1ToSize2) + size0ToSize1;
        return chainsWithSize1 + chainsWithSize2 + chainsWithSize3OrMore;
    }

    public boolean isPossible(int[] nums) {
        if (nums.length<3)
            return false;

        int count = 1, i= 0;
        while (i<nums.length) {
            if (i<nums.length-1 && nums[i] == nums[i+1]) {
                count++;
            } else {
                addToChain(count);
                count = 1;
            }
            i++;
        }
        return chainsWithSize1 == 0 && chainsWithSize2 == 0;
    }

    public static void main(String[] args) {
        LC659 l = new LC659();
        l.isPossible(new int[]{1,2,5,5,6,6,7,8,8,9});
    }
}
