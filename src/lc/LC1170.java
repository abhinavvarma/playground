package lc;

public class LC1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {

        int [] fCount = new int[11];

        for(String word : words){
            int count = getFCount(word);
            fCount[count]++;
        }


        int sum = 0;
        for(int i=0;i<fCount.length;i++){
            sum += fCount[i];
            fCount[i] = sum;
        }
        for(int i=0;i<fCount.length;i++){
            System.out.println(fCount[i]);
        }

        int [] res = new int[queries.length];

        for(int i=0;i<queries.length;i++){

            int count = getFCount(queries[i]);
            res[i] = fCount[fCount.length -1] - fCount[count];
        }

        return res;
    }

    public int getFCount(String word){
        int [] count = new int[26];

        for(int i=0;i<word.length();i++){
            count[word.charAt(i)-'a']++;
        }

        for(int i=0;i<count.length;i++){
            if(count[i] != 0){
                return count[i];
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        LC1170 l = new LC1170();
        l.numSmallerByFrequency(new String[]{
                "bbb","cc"
        },
                new String[]{
                        "a","aa","aaa","aaaa"
                });
    }
}