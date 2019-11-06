package lc;

import utils.CharCounter;


public class MinWindow {
    public static void main(String[] args) {
        String S = "ADOBECODEBANC";
        String T = "ABC";
        CharCounter matchedCharsInWindow = new CharCounter();
        CharCounter targetChars = new CharCounter();
        targetChars.add(T);
        int s=0, e=0, minWindowSize = S.length(), minS = s , minE = e;
        while (s<S.length() && e<S.length()) {
            if (targetChars.containsKey(S.charAt(e))) {
                matchedCharsInWindow.add(S.charAt(e));
            }
            while (matchedCharsInWindow.contains(targetChars)) {
                int curWindowSize = e-s+1;
                if (curWindowSize < minWindowSize) {
                    minE = e;
                    minS = s;
                    minWindowSize = curWindowSize;
                }
                matchedCharsInWindow.remove(S.charAt(s));
                s++;
            }
            e++;
        }
        StringBuilder output = new StringBuilder(S);
        output.insert(minS, "[");
        output.insert(minE+2, "]");
        System.out.println(String.format("%s %s", minWindowSize, output));
    }
}
