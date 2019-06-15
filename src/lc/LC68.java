package lc;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;


public class LC68 {
    List<List<String>> lines;
    int maxWidth = 0;

    public LC68(int maxWidth) {
        lines = new ArrayList<>();
        this.maxWidth = maxWidth;
    }

    private int currentLineNumber() {
        return lines.size()-1;
    }

    private boolean hasSpaceFor(String word) {
        if (lines.size() == 0) {
            return false;
        }
        return lines.get(currentLineNumber()).size() + word.length() + 1 < maxWidth;
    }

    public String spaces( int spaces ) {
        return CharBuffer.allocate( spaces ).toString().replace( '\0', ' ' );
    }

    private void reformat(int lineNumber) {
        List<String> words = lines.get(lineNumber);
//        if (words.size()==0) {
//            lines.set(lineNumber, sp)
//        }
        int wordsTotal = 0;
        for (String word : words) {
            wordsTotal += word.length();
        }
        int minPad = (maxWidth - wordsTotal) / (words.size()-1);


    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        for (int i = 0; i < words.length; i++) {
            if (hasSpaceFor(words[i])) {
                lines.get(currentLineNumber()).add(words[i]);
            } else {

            }
        }

        return null;
    }

    public static void main(String[] args) {
        String[] words = new String[] {
                "This", "is", "an", "example", "of", "text", "justification."
        };
        LC68 l = new LC68(16);
        List<String> strings = l.fullJustify(words, 16);
        for (String s :
                strings) {
            System.out.println(s);
        }
    }
}
