package lc;

//https://leetcode.com/problems/longest-palindromic-substring/

public class Q5 {

    String traverse(String s, int p, int q) {
        if (!(p>=0 && q<=s.length()))
            return "";
        int begin = p, end = p;
        while (true)
        {
            if (p>=0 && q<s.length() && s.charAt(p) == s.charAt(q)) {
                begin = p--;
                end = q++;
            } else
                return s.substring(begin, end + 1);
        }
    }

    public String longestPalindrome(String s) {
        String longest = "";
        for(int i = 0; i < s.length(); i++) {
            String oddP = traverse(s, i, i);
            String evenP = traverse(s, i, i+1);
            if (oddP.length()>longest.length())
                longest = oddP;
            if (evenP.length()>longest.length())
                longest = evenP;
        }
        return longest;
    }

    public static void main(String[] args) {
        Q5 q = new Q5();
        q.longestPalindrome("babad");
    }
}
