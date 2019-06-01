package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LC17 {
    static Map<Character, List<String>> m = new HashMap<>();
    static {
        m.put('2', Arrays.asList("a","b","c"));
        m.put('3', Arrays.asList("d","e","f"));
        m.put('4', Arrays.asList("g","h","i"));
        m.put('5', Arrays.asList("j","k","l"));
        m.put('6', Arrays.asList("m","n","o"));
        m.put('7', Arrays.asList("p","q","r","s"));
        m.put('8', Arrays.asList("t","u","v"));
        m.put('9', Arrays.asList("w","x","y","z"));
    }
    public List<String> append(List<String> prefixes, List<String> suffixes) {
        List<String> res = new ArrayList<>();
        if (prefixes.isEmpty())
            prefixes.add("");
        for (String p: prefixes) {
            for (String s: suffixes) {
                res.add(p+s);
            }
        }
        return res;
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        for (Character c: digits.toCharArray()) {
            res = append(res, m.get(c));
        }
        return res;
    }
}
